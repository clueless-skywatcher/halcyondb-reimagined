package com.github.cluelessskywatcher.halcyonreimagined.halql.dql;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataTable;
import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.exceptions.TableNotFoundException;
import com.github.cluelessskywatcher.halcyonreimagined.halql.TableRelatedStatement;
import com.github.cluelessskywatcher.halcyonreimagined.models.dql.SelectTableResult;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectTableStatement extends TableRelatedStatement {
    private String tableName;

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

    @Override
    public void execute() throws Exception {
        DataTable table = getTable();
        long timeTaken = System.currentTimeMillis();
        Tuple[] rows = table.selectAll().toArray(new Tuple[0]);
        timeTaken = System.currentTimeMillis() - timeTaken;
        this.result = new SelectTableResult(tableName, rows);
        this.result.setTimeTaken((double) timeTaken);
    }
}
