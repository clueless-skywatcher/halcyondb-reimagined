package com.github.cluelessskywatcher.halcyonreimagined.data.fields;

import java.io.DataOutputStream;
import java.io.IOException;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataConstants;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;

public class StringField implements DataField {
    private String value;

    public StringField(String value) {
        this.value = value;
    }

    @Override
    public DataType getType() {
        return DataType.STRING;
    }

    @Override
    public Object getValue() {
        return value;
    }

    public boolean equals(Object other) {
        if (other instanceof StringField) {
            StringField otherString = (StringField) other;
            return this.value.equals(otherString.value);
        }
        return false;
    }

    @Override
    public void serialize(DataOutputStream stream) throws IOException {
        String s = value;
        int maxLength = DataConstants.MAX_STRING_LENGTH;
        int overflow = maxLength - s.length();
        if (overflow < 0) {
            s = s.substring(0, maxLength);
        }
        stream.writeInt(s.length());
        stream.writeBytes(s);
        while (overflow-- > 0) {
            stream.write((byte) 0);
        }
    }

    public String toString() {
        return value;
    }
}
