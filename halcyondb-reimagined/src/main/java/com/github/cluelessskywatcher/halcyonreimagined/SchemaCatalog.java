package com.github.cluelessskywatcher.halcyonreimagined;

import java.util.HashMap;
import java.util.Map;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataTable;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;

public class SchemaCatalog {
    private Map<DataTable, TupleMetadata> tableMetadata;
    private Map<String, DataTable> nameToTable;

    public SchemaCatalog() {
        nameToTable = new HashMap<>();
        tableMetadata = new HashMap<>();
    }
    
    public TupleMetadata getTableMetadata(String tableName) {
        return tableMetadata.get(nameToTable.get(tableName));
    }

    public DataTable getTable(String tableName) {
        return nameToTable.get(tableName);
    }
 
    public void addTable(String tableName, TupleMetadata metadata) throws Exception {
        DataTable table = new DataTable(tableName, metadata);
        addTable(table, metadata);
    }

    public void addTable(DataTable table, TupleMetadata metadata) {
        nameToTable.put(table.getTableName(), table);
        tableMetadata.put(table, metadata);
    }

    public boolean tableExists(String tableName) {
        return nameToTable.containsKey(tableName);
    }
}
