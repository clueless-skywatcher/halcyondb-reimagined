package com.github.cluelessskywatcher.halcyonreimagined.halql.dql;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataTable;
import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.filtering.FilterMap;
import com.github.cluelessskywatcher.halcyonreimagined.halql.TableRelatedStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.models.dql.SelectTableResult;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectTableStatement extends TableRelatedStatement {
    private String tableName;
    private FilterMap filters;

    public SelectTableStatement(String tableName) {
        this.tableName = tableName;
        if (HalcyonDBInstance.getCatalog().getTable(tableName) == null) {
            String errorMsg = String.format("No table called %s in database", tableName);
            this.result = new SelectTableResult(errorMsg);
        }
        else {
            this.table = HalcyonDBInstance.getCatalog().getTable(tableName);
            this.tableDescription = HalcyonDBInstance.getCatalog().getTableMetadata(tableName);
            try {
                execute();
            }
            catch (Exception e) {
                this.result = new SelectTableResult(e.getMessage());
            }
        }
    }

    public SelectTableStatement(String tableName, FilterMap filters) {
        this(tableName);
        this.filters = filters;
    }

    @Override
    public void execute() throws Exception {
        DataTable table = getTable();
        long timeTaken = System.currentTimeMillis();
            
        Tuple[] rows;
        if (filters == null) {
            rows = table.selectAll().toArray(new Tuple[0]);
        }
        else {
            rows = table.selectByFilter(this.filters).toArray(new Tuple[0]);
        }
        timeTaken = System.currentTimeMillis() - timeTaken;

        this.result = new SelectTableResult(tableName, rows, timeTaken);
    }
}
