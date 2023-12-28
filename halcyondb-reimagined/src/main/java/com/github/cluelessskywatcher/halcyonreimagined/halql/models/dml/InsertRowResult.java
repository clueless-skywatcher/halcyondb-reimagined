package com.github.cluelessskywatcher.halcyonreimagined.halql.models.dml;

import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.halql.models.TableRelatedResult;

public class InsertRowResult extends TableRelatedResult {
    private Tuple[] rows;

    public InsertRowResult(String tableName, Tuple[] rows, long timeTaken) {
        this.rows = rows;
        this.tableName = tableName;
        this.timeTaken = timeTaken;
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
                String.format("Inserted {} rows", 
                rows.length, 
                getTimeTaken()
            ));
            System.out.println(
                String.format("Time taken: {} ms", 
                    getTimeTaken()
                )
            );
        }
    }
}
