package com.github.cluelessskywatcher.halcyonreimagined.halql.ddl;

import java.util.Map;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataTable;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.halql.TableRelatedStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.models.ddl.CreateTableResult;

import lombok.Getter;

public class CreateTableStatement extends TableRelatedStatement {
    private @Getter String tableName;

    public CreateTableStatement(String tableName, Map<String, DataType> fieldDef) {
        this.tableName = tableName;
        if (HalcyonDBInstance.getCatalog().tableExists(this.tableName)) {
            this.result = new CreateTableResult(String.format("Table %s already exists", tableName));
            return;
        }

        String[] fieldNames = fieldDef.keySet().toArray(new String[0]);

        DataType[] types = new DataType[fieldNames.length];
        for (int i = 0; i < fieldNames.length; i++) {
            types[i] = fieldDef.get(fieldNames[i]);
        }

        this.tableDescription = new TupleMetadata(types, fieldNames);
        try {
            this.table = new DataTable(this.tableName, tableDescription);
        } catch (Exception e) {
            e.printStackTrace();
            this.result = new CreateTableResult(String.format("Table creation failed: %s", tableName));
            return;
        }
    }

    @Override
    public void execute() throws Exception {
        if (HalcyonDBInstance.getCatalog().tableExists(tableName)) {
            this.result = new CreateTableResult(String.format("Table %s already exists", tableName));
            return;
        }
        long time = System.currentTimeMillis();
        HalcyonDBInstance.getCatalog().addTable(tableName, this.tableDescription);
        time = System.currentTimeMillis() - time;
        this.result = new CreateTableResult(tableName, this.tableDescription, time);
    }
}
