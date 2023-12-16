package com.github.cluelessskywatcher.halcyonreimagined.halql.dml;

import com.github.cluelessskywatcher.halcyonreimagined.halql.HalqlStatement;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InsertRowStatement extends HalqlStatement {
    private String tableName;

    public InsertRowStatement(String statement) {
        super(statement);
    }

    @Override
    public void execute() {
        System.out.printf("Inserting row into table: %s with values\n", tableName);
    }

    @Override
    public void extractDataFromStatement() {
        this.tableName = "sample1";
    }
    
    
}
