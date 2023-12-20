package com.github.cluelessskywatcher.halcyonreimagined.data;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;

import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.IntegerField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.StringField;

import lombok.Getter;

public class Page {
    private @Getter byte[] content;
    private @Getter TupleMetadata metadata;
    // Header contains the bits, each denoting whether the particular
    // row is empty or not.
    private byte[] header;
    
    public Page(TupleMetadata metadata) throws Exception {
        if (metadata.getTotalSize() > DataConstants.PAGE_SIZE) {
            throw new Exception("Tuple size exceeds page size. Cannot store");
        }
        this.content = new byte[DataConstants.PAGE_SIZE];
        this.metadata = metadata;
        this.header = new byte[getHeaderSize()];
        Arrays.fill(this.header, (byte) 0);
    }

    // Get the maximum number of rows that can fit in this
    // page. A row will occupy metadata.getTotalSize() bytes + 
    // 1 bit for storing the header info
    public int getMaxRows() {
        return (content.length * 8) / (metadata.getTotalSize() * 8 + 1);
    }

    // Get the header size
    private int getHeaderSize() {
        return (int) Math.ceil((double) getMaxRows() / 8);
    }

    public int getNumEmptySlots() {
        int numSlots = 0;
        for (int i = 0; i < getMaxRows(); i++) {
            if (!hasValue(i)) numSlots++;
        }

        return numSlots;
    }

    // Given an integer i, check whether the i-th row
    // has any value (Tuple) or not.
    public boolean hasValue(int i) {
        int rowOffset = this.header[i / 8];
        int bitOffset = 1 << (i % 8);

        return (rowOffset & bitOffset) != 0;
    }

    // Given an integer i and a boolean, set the i-th
    // row as the boolean in the header
    public void setRow(int i, boolean value) {
        // Let the byte of the particular row be 11100011
        // We want to set the 4th row (from LSB) in this byte to true (1)
        // Take i = 4, i % 8 = 4, (1 << (i % 8)) = 00010000
        // OR it with the header byte
        //   11100011
        // | 00010000
        // ----------
        //   11110011
        
        // Let the byte of the particular row be 11100011
        // We want to set the 3rd row in this byte to false (0)
        // Take i = 3, i % 8 = 3, (1 << (i % 8)) = 00001000
        // ~(1 << (i % 8)) = 11110111
        // AND it with the header byte
        //   11100011
        // & 11110111
        // ----------
        //   11100011
        if (value) {
            this.header[i / 8] |= (1 << (i % 8));
        }
        else {
            this.header[i / 8] &= ~(1 << (i % 8));
        }
    }

    // Get the first slot that has no tuples stored
    // Also, for every slot shift, there will be an increase
    // of the content offset by the size of a row
    public void insert(Tuple tuple) throws IOException {
        int i = 0;
        int contentOffset = 0;
        while (i < getMaxRows()) {
            if (!hasValue(i)) break;
            i++;
            contentOffset += metadata.getTotalSize();
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(baos);
        tuple.serialize(dos);
        byte[] tupleBytes = baos.toByteArray();

        System.arraycopy(tupleBytes, 0, content, contentOffset, tupleBytes.length);

        setRow(i, true);
    }

    public Tuple deserialize(int row) throws Exception {
        int rowOffset = row * metadata.getTotalSize();
        byte[] rowBytes = Arrays.copyOfRange(content, rowOffset, rowOffset + metadata.getTotalSize());
        ByteArrayInputStream bais = new ByteArrayInputStream(rowBytes);
        DataInputStream dais = new DataInputStream(bais);

        DataField[] fields = new DataField[metadata.getFieldCount()];

        for (int i = 0; i < fields.length; i++) {
            if (metadata.getTypeAt(i) == DataType.INTEGER) {
                int value = dais.readInt();
                fields[i] = new IntegerField(value);
            }
            else if (metadata.getTypeAt(i) == DataType.STRING) {
                int length = dais.readInt();
                byte[] stringBytes = new byte[length];
                dais.readFully(stringBytes);
                int current = DataConstants.MAX_STRING_LENGTH - length;
                while (current-- > 0) {
                    dais.readByte();
                }
                fields[i] = new StringField(new String(stringBytes, "UTF-8"));
            }
        }

        return Tuple.construct(fields, metadata);
    }
}
