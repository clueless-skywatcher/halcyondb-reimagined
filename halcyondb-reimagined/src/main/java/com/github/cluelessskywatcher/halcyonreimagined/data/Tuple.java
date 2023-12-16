package com.github.cluelessskywatcher.halcyonreimagined.data;

import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;

import lombok.Getter;

public class Tuple {
    private DataField[] fields;
    @Getter private TupleMetadata metadata;

    public Tuple(TupleMetadata metadata) {
        this.fields = new DataField[metadata.getFieldCount()];
        this.metadata = metadata;
    }

    public void setFieldAt(int i, DataField field) {
        this.fields[i] = field;
    }

    public DataField getFieldAt(int i) {
        return this.fields[i];
    }

    public int getFieldCount() {
        return this.fields.length;
    }

    public boolean equals(Object other) {
        if (other instanceof Tuple) {
            Tuple otherTuple = (Tuple) other;
            if (getFieldCount() != otherTuple.getFieldCount()) {
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
}
