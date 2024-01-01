package com.github.cluelessskywatcher.halcyonreimagined.data;

import lombok.Getter;
import lombok.Setter;

public class DataCursor {
    private @Getter DataTable table;
    private @Getter @Setter int rowNum;
    private @Getter @Setter boolean isEndOfTable;

    public DataCursor(DataTable table, int rowNum, boolean isEndOfTable) {
        this.table = table;
        this.rowNum = rowNum;
        this.isEndOfTable = isEndOfTable;
    }
}
