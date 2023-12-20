package com.github.cluelessskywatcher.halcyonreimagined.halql;

import com.github.cluelessskywatcher.halcyonreimagined.models.AbstractQueryResult;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class HalqlStatement {
    protected String statement;
    protected AbstractQueryResult result;

    public HalqlStatement(String statement) throws Exception {
        this.statement = statement;
        extractDataFromStatement();
    }
    
    // Logic to execute the statement
    public abstract void execute() throws Exception;

    // Logic to parse/extract all necessary data from the statement
    public abstract void extractDataFromStatement() throws Exception;
}
