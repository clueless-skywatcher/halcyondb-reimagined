package com.github.cluelessskywatcher.halcyonreimagined.data;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.StringJoiner;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.LongField;
import com.github.cluelessskywatcher.halcyonreimagined.exceptions.InvalidFieldNameException;

import lombok.Getter;
import lombok.Setter;

public class Tuple {
    private DataField[] fields;
    private @Getter TupleMetadata metadata;
    private @Getter long tupleKey;
    private @Getter @Setter boolean isTombStone;

    public Tuple(TupleMetadata metadata) {
        this.fields = new DataField[metadata.getFieldCount()];
        this.metadata = metadata;
        this.tupleKey = HalcyonDBInstance.getNextId();
        this.isTombStone = false;
    }

    public Tuple(TupleMetadata metadata, long key) {
        this.fields = new DataField[metadata.getFieldCount()];
        this.metadata = metadata;
        this.tupleKey = key;
        this.isTombStone = false;
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

    public static Tuple construct(DataField[] fields, TupleMetadata metadata, long key, boolean tombstone) {
        Tuple tuple = new Tuple(metadata, key);
        for (int i = 0; i < fields.length; i++) {
            tuple.setFieldAt(i, fields[i]);
        }
        tuple.setTombStone(tombstone);
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
            if (isTombStone() != otherTuple.isTombStone()) {
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
        dos.writeBoolean(isTombStone);
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < fields.length; i++) {
            joiner.add(fields[i].toString());
        }

        return String.format("%s => (%s)", tupleKey, joiner.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isValidField(String name) {
        return metadata.isValidField(name);
    }

    public DataField getFieldFromName(String fieldName) throws Exception {
        if (fieldName.equals("id")) {
            return new LongField(this.tupleKey);
        }

        for (int i = 0; i < metadata.getFieldCount(); i++) {
            if (fieldName.equals(metadata.getFieldAt(i))) {
                return fields[i];
            }
        }

        throw new InvalidFieldNameException(String.format("Cannot find field %s", fieldName));
    }

    public String represent() {
        /*
         * Different from toString. Used only in utility functions
         * for constructing insert queries
         */
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].getType() == DataType.STRING) {
                joiner.add(String.format("\"%s\"", fields[i].toString()));
            }
            else {
                joiner.add(fields[i].toString());
            }
        }

        return String.format("(%s)", joiner.toString());
    }
}
