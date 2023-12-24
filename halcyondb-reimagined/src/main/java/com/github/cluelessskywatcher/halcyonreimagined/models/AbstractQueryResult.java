package com.github.cluelessskywatcher.halcyonreimagined.models;

import lombok.Getter;
import lombok.Setter;

public abstract class AbstractQueryResult {
    protected @Getter @Setter double timeTaken;
    protected @Getter @Setter String error;

    public abstract void showResult();
}
