package com.github.cluelessskywatcher.halcyonreimagined.halql.dql;

import com.github.cluelessskywatcher.halcyonreimagined.halql.HalqlStatement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectTableStatement extends HalqlStatement {
    private String tableName;
    private String tableAlias;
    private String selectField;

    public SelectTableStatement(String statement) {
        super(statement);
    }

    @Override
    public void execute() {
        System.out.printf("Selecting values from table: %s\n", tableName);
    }

    @Override
    public void extractDataFromStatement() {
        this.tableName = "sample1";
    }    
}
