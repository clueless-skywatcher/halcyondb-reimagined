package com.github.cluelessskywatcher.halcyonreimagined.data.lsmtree;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataConstants;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.IntegerField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.StringField;
import com.github.cluelessskywatcher.halcyonreimagined.filtering.FilterMap;

import lombok.Getter;

public class LSMSSTable implements Comparable<LSMSSTable> {
    private @Getter File dataFile;
    private @Getter File indexFile;
    private @Getter Long timestamp;
    private @Getter TupleMetadata metadata;

    public static final String SSTABLE_DIR = "data/sstables";

    public LSMSSTable(String tableName, Long timestamp, TupleMetadata metadata) throws Exception {
        this.timestamp = timestamp;

        this.dataFile = new File(
            MessageFormat.format(
                "{2}/{3}/{0}/sstable-data-{0}-{1}.ss",
                tableName,
                this.timestamp,
                HalcyonDBInstance.BASE_DIRECTORY,
                SSTABLE_DIR
            )
        );
        this.indexFile = new File(
            MessageFormat.format(
                "{2}/{3}/{0}/sstable-index-{0}-{1}.idx",
                tableName,
                this.timestamp,
                HalcyonDBInstance.BASE_DIRECTORY,
                SSTABLE_DIR
            )
        );

        createFile(dataFile);
        createFile(indexFile);

        this.metadata = metadata;
    }

    private void createFile(File file) throws Exception {
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
    }

    public void flush(Map<Long, Tuple> tupleMap) throws Exception {
        RandomAccessFile dataRaf = new RandomAccessFile(dataFile, "rw");
        dataRaf.seek(0);

        RandomAccessFile indexRaf = new RandomAccessFile(indexFile, "rw");
        indexRaf.seek(0);

        for (Map.Entry<Long, Tuple> entry : tupleMap.entrySet()) {
            indexRaf.writeLong(entry.getKey());
            indexRaf.writeLong(dataRaf.getFilePointer());
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            entry.getValue().serialize(dos);
            byte[] tupleBytes = baos.toByteArray();

            dataRaf.write(tupleBytes);
        }

        dataRaf.close();
        indexRaf.close();
    }
    
    public List<Tuple> selectAll() throws Exception {
        List<Tuple> results = new ArrayList<>();

        DataInputStream dis = new DataInputStream(new FileInputStream(dataFile));

        while (dis.available() > 0) {
            DataField[] fields = new DataField[metadata.getFieldCount()];
            long key = dis.readLong();
            for (int i = 0; i < fields.length; i++) {
                if (metadata.getTypeAt(i) == DataType.INTEGER) {
                    int value = dis.readInt();
                    fields[i] = new IntegerField(value);
                }
                else if (metadata.getTypeAt(i) == DataType.STRING) {
                    int length = dis.readInt();
                    byte[] stringBytes = new byte[length];
                    dis.readFully(stringBytes);
                    int current = DataConstants.MAX_STRING_LENGTH - length;
                    while (current-- > 0) {
                        dis.readByte();
                    }
                    fields[i] = new StringField(new String(stringBytes, "UTF-8"));
                }
            }
            boolean tombstone = dis.readBoolean();
            if (tombstone) {
                continue;
            }

            Tuple tuple = Tuple.construct(fields, metadata, key, tombstone);
            results.add(tuple);
        }
        dis.close();

        return results;
    }

    public List<Tuple> selectByFilter(FilterMap filters) throws Exception {
        List<Tuple> results = new ArrayList<>();

        DataInputStream dis = new DataInputStream(new FileInputStream(dataFile));

        while (dis.available() > 0) {
            DataField[] fields = new DataField[metadata.getFieldCount()];
            long key = dis.readLong();
            for (int i = 0; i < fields.length; i++) {
                if (metadata.getTypeAt(i) == DataType.INTEGER) {
                    int value = dis.readInt();
                    fields[i] = new IntegerField(value);
                }
                else if (metadata.getTypeAt(i) == DataType.STRING) {
                    int length = dis.readInt();
                    byte[] stringBytes = new byte[length];
                    dis.readFully(stringBytes);
                    int current = DataConstants.MAX_STRING_LENGTH - length;
                    while (current-- > 0) {
                        dis.readByte();
                    }
                    fields[i] = new StringField(new String(stringBytes, "UTF-8"));
                }
            }
            boolean tombstone = dis.readBoolean();
            if (tombstone) {
                continue;
            }

            Tuple tuple = Tuple.construct(fields, metadata, key, tombstone);
            if (filters.satisfiesFilters(tuple)) {
                results.add(tuple);
            }
        }
        dis.close();

        return results;
    }

    @Override
    public int compareTo(LSMSSTable arg0) {
        return this.timestamp.compareTo(arg0.getTimestamp());
    }
}
