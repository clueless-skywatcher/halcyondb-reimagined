package com.github.cluelessskywatcher.halcyonreimagined.halql.dql;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataTable;
import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.exceptions.QueryParsingException;
import com.github.cluelessskywatcher.halcyonreimagined.exceptions.TableNotFoundException;
import com.github.cluelessskywatcher.halcyonreimagined.halql.TableRelatedStatement;
import com.github.cluelessskywatcher.halcyonreimagined.models.dql.SelectTableResult;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SelectTableStatement extends TableRelatedStatement {
    private String tableName;
    
    public SelectTableStatement(String statement) throws Exception {
        super(statement);
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

    @Override
    public void extractDataFromStatement() throws Exception {
        Pattern selectPattern = Pattern.compile("select \\* from (\\w+);");
        Matcher matcher = selectPattern.matcher(getStatement());
        if (matcher.matches()) {
            String tableName = matcher.group(1);
            if (HalcyonDBInstance.getCatalog().getTable(tableName) == null) {
                throw new TableNotFoundException(String.format("No table called %s in database", tableName));
            }
            setTable(HalcyonDBInstance.getCatalog().getTable(tableName));
            setTableDescription(getTable().getMetadata());
        }
        else {
            throw new QueryParsingException("Cannot parse SELECT query");
        }
    }    
}
