package com.github.cluelessskywatcher.halcyonreimagined.data;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.StringJoiner;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;

import lombok.Getter;
import lombok.Setter;

public class Tuple {
    private DataField[] fields;
    private @Getter TupleMetadata metadata;
    private @Getter long tupleKey;

    public Tuple(TupleMetadata metadata) {
        this.fields = new DataField[metadata.getFieldCount()];
        this.metadata = metadata;
        this.tupleKey = HalcyonDBInstance.getNextId();
    }

    public Tuple(TupleMetadata metadata, long key) {
        this(metadata);
        this.tupleKey = key;
    }

    // Given a list of DataFields and the metadata:
    // construct a Tuple object
    public static Tuple construct(DataField[] fields, TupleMetadata metadata) {
        Tuple tuple = new Tuple(metadata);
        for (int i = 0; i < fields.length; i++) {
            tuple.setFieldAt(i, fields[i]);
        }
        return tuple;
    }

    public static Tuple construct(DataField[] fields, TupleMetadata metadata, long key) {
        Tuple tuple = new Tuple(metadata, key);
        for (int i = 0; i < fields.length; i++) {
            tuple.setFieldAt(i, fields[i]);
        }
        return tuple;
    }

    public void setFieldAt(int i, DataField field) {
        this.fields[i] = field;
    }

    public DataField getFieldAt(int i) {
        return this.fields[i];
    }

    // Get number of fields
    public int getFieldCount() {
        return this.fields.length;
    }

    public boolean equals(Object other) {
        if (other instanceof Tuple) {
            Tuple otherTuple = (Tuple) other;
            if (getFieldCount() != otherTuple.getFieldCount()) {
                return false;
            }
            if (getTupleKey() != otherTuple.getTupleKey()) {
                return false;
            }
            for (int i = 0; i < getFieldCount(); i++) {
                if (!getFieldAt(i).equals(otherTuple.getFieldAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    // Write bytes to a DataOutputStream
    public void serialize(DataOutputStream dos) throws IOException {
        dos.writeLong(tupleKey);
        for (int i = 0; i < fields.length; i++) {
            fields[i].serialize(dos);
        }
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        joiner.add(Long.toString(tupleKey));
        for (int i = 0; i < fields.length; i++) {
            joiner.add(fields[i].toString());
        }

        return String.format("(%s)", joiner.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
