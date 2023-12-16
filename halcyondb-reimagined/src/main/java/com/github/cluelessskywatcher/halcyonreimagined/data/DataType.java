package com.github.cluelessskywatcher.halcyonreimagined.data;

import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;

public enum DataType {
    INTEGER {
        @Override
        public int getSize() {
            return 4;
        }

        @Override
        public DataField parse() {
            throw new UnsupportedOperationException("Unimplemented method 'parse'");
        }
    },
    STRING {
        @Override
        public int getSize() {
            return DataConstants.MAX_STRING_LENGTH + 4;
        }

        @Override
        public DataField parse() {
            throw new UnsupportedOperationException("Unimplemented method 'parse'");
        }
    };

    public abstract int getSize();

    public abstract DataField parse();
}
