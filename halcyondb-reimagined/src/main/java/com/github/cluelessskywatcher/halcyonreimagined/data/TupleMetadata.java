package com.github.cluelessskywatcher.halcyonreimagined.data;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.StringJoiner;

import com.github.cluelessskywatcher.halcyonreimagined.exceptions.InvalidFieldNameException;

public class TupleMetadata {
    private DataType[] types;
    private String[] fieldNames;

    public TupleMetadata(DataType[] types, String[] fieldNames){
        if (types.length != fieldNames.length) {
            throw new InvalidParameterException("Field type list and field name list must be equal");
        }
        this.types = types;
        this.fieldNames = fieldNames;
    }

    public DataType getTypeAt(int i) {
        return types[i];
    }

    public String getFieldAt(int i) {
        return fieldNames[i];
    }

    public void setTypeAt(int i, DataType type) {
        types[i] = type;
    }

    public void setFieldAt(int i, String fieldName) {
        fieldNames[i] = fieldName;
    }

    public int getTotalSize() {
        int totalSize = Long.SIZE;
        for (int i = 0; i < types.length; i++) {
            totalSize += types[i].getSize();
        }
        return totalSize;
    }

    public DataType getTypeOf(String fieldName) throws InvalidFieldNameException {
        // Return ID type
        if (fieldName.equals("id")) {
            return DataType.LONG;
        }
        
        for (int i = 0; i < fieldNames.length; i++) {
            if (fieldNames[i].equals(fieldName)) {
                return types[i];
            }
        }

        throw new InvalidFieldNameException(String.format("Field name %s does not exist", fieldName));
    }

    public int getFieldCount() {
        return types.length;
    }

    public boolean equals(Object other) {
        if (other instanceof TupleMetadata) {
            TupleMetadata otherMetadata = (TupleMetadata) other;
            if (getFieldCount() != otherMetadata.getFieldCount()) {
                return false;
            }
            for (int i = 0; i < getFieldCount(); i++) {
                if (!getFieldAt(i).equals(otherMetadata.getFieldAt(i))){
                    return false;
                }
                if (!getTypeAt(i).equals(otherMetadata.getTypeAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < getFieldCount(); i++) {
            joiner.add(String.format("%s %s", fieldNames[i], types[i]));
        }

        return String.format("(%s)", joiner.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isValidField(String name) {
        /*
         * Returns true if the name is equal to "id"
         * or any of the field names of the metadata
         */
        return name.equals("id") || Arrays.asList(fieldNames).contains(name);
    }

    public String[] getFieldNames() {
        return fieldNames;
    }
}
