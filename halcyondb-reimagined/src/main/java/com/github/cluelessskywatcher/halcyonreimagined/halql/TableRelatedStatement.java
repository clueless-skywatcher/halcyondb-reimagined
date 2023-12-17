package com.github.cluelessskywatcher.halcyonreimagined.halql;

import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class TableRelatedStatement extends HalqlStatement {
    private TupleMetadata tableDescription;

    public TableRelatedStatement(String statement) {
        super(statement);
    }
}
