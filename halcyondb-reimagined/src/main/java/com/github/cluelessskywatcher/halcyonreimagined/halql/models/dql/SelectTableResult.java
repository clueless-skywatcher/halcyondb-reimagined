package com.github.cluelessskywatcher.halcyonreimagined.halql.models.dql;

import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleProjection;
import com.github.cluelessskywatcher.halcyonreimagined.halql.models.TableRelatedResult;

import lombok.Getter;


public class SelectTableResult extends TableRelatedResult {
    private @Getter TupleProjection[] rows;

    public SelectTableResult(String tableName, TupleProjection[] rows, long timeTaken) {
        this.rows = rows;
        this.tableName = tableName;
        this.timeTaken = timeTaken;
    }

    public SelectTableResult(String error) {
        this.error = error;
    }

    @Override
    public void showResult() {
        if (error != null) {
            System.out.println(error);
        }
        else {
            if (rows != null) {
                for (TupleProjection row : rows) {
                    System.out.println(row.toString());
                }
            }
            System.out.println(
                String.format("Time taken: {} ms", 
                    getTimeTaken()
                )
            );
        }
    }
}
