package com.github.cluelessskywatcher.halcyonreimagined.models.dml;

import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.models.TableRelatedResult;

public class InsertRowResult extends TableRelatedResult {
    private Tuple[] rows;

    public InsertRowResult(String tableName, Tuple[] rows) {
        this.rows = rows;
        this.tableName = tableName;
    }
}
