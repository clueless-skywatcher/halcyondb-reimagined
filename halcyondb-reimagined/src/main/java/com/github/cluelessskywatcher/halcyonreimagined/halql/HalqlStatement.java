package com.github.cluelessskywatcher.halcyonreimagined.halql;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class HalqlStatement {
    String statement;

    public HalqlStatement(String statement) {
        this.statement = statement;
        extractDataFromStatement();
    }
    
    public abstract void execute();

    public abstract void extractDataFromStatement();
}
