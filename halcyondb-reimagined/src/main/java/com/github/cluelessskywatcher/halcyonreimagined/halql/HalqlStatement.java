package com.github.cluelessskywatcher.halcyonreimagined.halql;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class HalqlStatement {
    private String statement;

    public HalqlStatement(String statement) {
        this.statement = statement;
        extractDataFromStatement();
    }
    
    // Logic to execute the statement
    public abstract void execute();

    // Logic to parse/extract all necessary data from the statement
    public abstract void extractDataFromStatement();
}
