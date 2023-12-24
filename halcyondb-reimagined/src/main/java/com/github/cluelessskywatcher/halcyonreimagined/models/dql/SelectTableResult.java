package com.github.cluelessskywatcher.halcyonreimagined.models.dql;

import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.models.TableRelatedResult;

import lombok.Getter;


public class SelectTableResult extends TableRelatedResult {
    private @Getter Tuple[] rows;

    public SelectTableResult(String tableName, Tuple[] rows) {
        this.rows = rows;
        this.tableName = tableName;
    }

    public SelectTableResult(String error) {
        this.error = error;
    }

    @Override
    public void showResult() {
        if (error != null) {
            System.out.println(error);
        }
        if (rows != null) {
            for (Tuple row : rows) {
                System.out.println(row.toString());
            }
        }
    }
}
