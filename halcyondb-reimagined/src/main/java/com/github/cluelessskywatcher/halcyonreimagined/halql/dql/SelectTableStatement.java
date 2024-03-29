package com.github.cluelessskywatcher.halcyonreimagined.halql.dql;

import java.util.List;
import java.util.Map;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataTable;
import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleProjection;
import com.github.cluelessskywatcher.halcyonreimagined.exceptions.InvalidFieldNameException;
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
    private List<String> projection;

    public SelectTableStatement(String tableName, List<String> projection) {
        this.tableName = tableName;
        this.projection = projection;
        if (HalcyonDBInstance.getCatalog().getTable(tableName) == null) {
            String errorMsg = String.format("No table called %s in database", tableName);
            this.result = new SelectTableResult(errorMsg);
        } else {
            this.table = HalcyonDBInstance.getCatalog().getTable(tableName);
            this.tableDescription = HalcyonDBInstance.getCatalog().getTableMetadata(tableName);
            try {
                execute();
            } catch (Exception e) {
                this.result = new SelectTableResult(e.getMessage());
            }
        }
    }

    public SelectTableStatement(String tableName, Map<String, Object> filters, List<String> projection) {
        this(tableName, projection);
        this.filters = new FilterMap(tableDescription);
        for (Map.Entry<String, Object> entry : filters.entrySet()) {
            {
                try {
                    this.filters.addFilter(entry.getKey(), entry.getValue());
                }
                catch (InvalidFieldNameException e) {
                    this.result = new SelectTableResult(String.format("Field %s does not exist in table %s", entry.getKey(), tableName));
                }
            }
        }
    }

    @Override
    public void execute() throws Exception {
        DataTable table = getTable();
        long timeTaken = System.currentTimeMillis();

        Tuple[] rows;
        if (filters == null) {
            rows = table.selectAll().toArray(new Tuple[0]);
        } else {
            rows = table.selectByFilter(this.filters).toArray(new Tuple[0]);
        }
        
        TupleProjection[] projectedTuples = new TupleProjection[rows.length];
        for (int i = 0; i < rows.length; i++) {
            projectedTuples[i] = rows[i].project(projection);
        }

        timeTaken = System.currentTimeMillis() - timeTaken;

        this.result = new SelectTableResult(tableName, projectedTuples, timeTaken);
    }
}
