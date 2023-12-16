package com.github.cluelessskywatcher.halcyonreimagined.data.fields;

import java.io.DataOutputStream;
import java.io.IOException;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;

public class IntegerField implements DataField {
    private int value;

    public IntegerField(int value) {
        this.value = value;
    }

    @Override
    public DataType getType() {
        return DataType.INTEGER;
    }

    @Override
    public Object getValue() {
        return value;
    }
    
    public boolean equals(Object other) {
        if (other instanceof IntegerField) {
            IntegerField otherString = (IntegerField) other;
            return this.value == otherString.value;
        }
        return false;
    }

    @Override
    public void serialize(DataOutputStream stream) throws IOException {
        stream.writeInt(value);
    }
}
