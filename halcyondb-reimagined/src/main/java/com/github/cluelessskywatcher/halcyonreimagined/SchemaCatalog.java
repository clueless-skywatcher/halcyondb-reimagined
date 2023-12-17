package com.github.cluelessskywatcher.halcyonreimagined;

import java.util.Map;

import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;

public class SchemaCatalog {
    private Map<String, TupleMetadata> tableMetadata;
    
    public TupleMetadata getTableMetadata(String tableName) {
        return tableMetadata.get(tableName);
    }
}
