package com.github.cluelessskywatcher.halcyonreimagined.models.dml;

import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.models.TableRelatedResult;

public class InsertRowResult extends TableRelatedResult {
    private Tuple[] rows;

    public InsertRowResult(String tableName, Tuple[] rows) {
        this.rows = rows;
        this.tableName = tableName;
    }

    public InsertRowResult(String error) {
        this.error = error;
    }

    @Override
    public void showResult() {
        if (this.error != null) {
            System.out.println(String.format("Failed to insert: %s", getError()));
        }
        else {
            System.out.println(
                String.format("Inserted {} rows. Time taken: {} ms", 
                rows.length, 
                getTimeTaken()
            ));
        }
    }
}
