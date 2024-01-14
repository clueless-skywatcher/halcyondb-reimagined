package com.github.cluelessskywatcher.halcyonreimagined.data.fields;

import java.io.DataOutputStream;
import java.io.IOException;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;

public class LongField implements DataField {
    private long value;

    public LongField(long value) {
        this.value = value;
    }

    @Override
    public DataType getType() {
        return DataType.LONG;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void serialize(DataOutputStream stream) throws IOException {
        stream.writeLong(value);
    }

    public String toString() {
        return Long.toString(value);
    }
    
}
