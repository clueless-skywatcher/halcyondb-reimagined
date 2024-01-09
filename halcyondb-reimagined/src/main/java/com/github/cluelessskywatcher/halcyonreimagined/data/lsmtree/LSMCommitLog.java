package com.github.cluelessskywatcher.halcyonreimagined.data.lsmtree;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataConstants;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.IntegerField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.StringField;

import lombok.Getter;

public class LSMCommitLog {
    private @Getter File commitLogFile;
    private @Getter TupleMetadata metadata;

    public LSMCommitLog(String tableName, TupleMetadata metadata) throws Exception {
        this.commitLogFile = new File(
            String.format(
                "%s/data/commit_log/%s.wal", 
                HalcyonDBInstance.BASE_DIRECTORY,
                tableName
            )
        );

        if (!this.commitLogFile.exists()){
            this.commitLogFile.getParentFile().mkdirs();
            this.commitLogFile.createNewFile();
        }

        this.metadata = metadata;
    }

    public void append(Tuple tuple, LSMOperation op) throws Exception {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(commitLogFile, true));
        tuple.serialize(dos);
        dos.writeInt(op.getId());
        dos.close();
    }

    public void reset() throws IOException {
        commitLogFile.delete();
        commitLogFile.createNewFile();
    }

    public void loadToMemTableIfNotEmpty(LSMMemTable memTable) throws Exception {
        DataInputStream dis = new DataInputStream(new FileInputStream(commitLogFile));
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

            int op = dis.readInt();

            if (op == LSMOperation.WRITE.getId()) {
                Tuple tuple = Tuple.construct(fields, metadata, key, tombstone);
                memTable.insert(tuple);
            }
        }
        dis.close();
        commitLogFile.createNewFile();
    }
}
