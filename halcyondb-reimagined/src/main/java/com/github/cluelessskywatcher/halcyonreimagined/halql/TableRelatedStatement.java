package com.github.cluelessskywatcher.halcyonreimagined.halql;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataTable;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class TableRelatedStatement extends HalqlStatement {
    protected TupleMetadata tableDescription;
    protected DataTable table;
}
