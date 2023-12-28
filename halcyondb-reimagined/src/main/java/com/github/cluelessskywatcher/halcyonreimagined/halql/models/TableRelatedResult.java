package com.github.cluelessskywatcher.halcyonreimagined.halql.models;

import lombok.Getter;

public abstract class TableRelatedResult extends AbstractQueryResult {
    protected @Getter String tableName;
}
