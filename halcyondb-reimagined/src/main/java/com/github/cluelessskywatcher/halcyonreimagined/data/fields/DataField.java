package com.github.cluelessskywatcher.halcyonreimagined.data.fields;

import java.io.DataOutputStream;
import java.io.IOException;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;

public interface DataField {
    public DataType getType();

    public Object getValue();

    public void serialize(DataOutputStream stream) throws IOException;

    public int hashCode();
}
