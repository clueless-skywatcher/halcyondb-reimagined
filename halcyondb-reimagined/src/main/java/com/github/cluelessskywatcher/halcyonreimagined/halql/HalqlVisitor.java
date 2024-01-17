package com.github.cluelessskywatcher.halcyonreimagined.halql;

import java.util.List;
import java.util.Map;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import com.github.cluelessskywatcher.halcyonreimagined.filtering.FilterMap;
import com.github.cluelessskywatcher.halcyonreimagined.halql.ddl.CreateTableStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.dml.InsertRowStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.dql.SelectTableStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.generated.HalcyonQueryLanguageBaseVisitor;
import com.github.cluelessskywatcher.halcyonreimagined.halql.generated.HalcyonQueryLanguageParser;

public class HalqlVisitor extends HalcyonQueryLanguageBaseVisitor<HalqlStatement> {
    @Override
    public HalqlStatement visitSelectTableStatement(HalcyonQueryLanguageParser.SelectTableStatementContext ctx) {
        String tableName = ctx.tableIdentifier().getText();
        List<String> projection = ctx.projection().projectionList;
        Map<String, Object> filters = ctx.queryFilters() == null ? null : ctx.queryFilters().filters;
        if (filters != null) { 
            if (filters.size() > 0){
                return new SelectTableStatement(tableName, filters, projection);
            }
        }
        return new SelectTableStatement(tableName, projection);
    }

    @Override
    public HalqlStatement visitInsertRowStatement(HalcyonQueryLanguageParser.InsertRowStatementContext ctx) {
        String tableName = ctx.tableIdentifier().getText();
        String[] values = ctx.values().valueList.toArray(new String[0]);
        InsertRowStatement stmt = new InsertRowStatement(tableName, values);
        return stmt;
    }

    @Override
    public HalqlStatement visitHalqlEntryPoint(HalcyonQueryLanguageParser.HalqlEntryPointContext ctx) {
        return visitChildren(ctx.halqlStatement());
    }

    @Override
    public HalqlStatement visitCreateTableStatement(HalcyonQueryLanguageParser.CreateTableStatementContext ctx) { 
        String tableName = ctx.tableIdentifier().getText();
        Map<String, DataType> fieldDef = ctx.tableDefinition().tableDef;
        CreateTableStatement stmt = new CreateTableStatement(tableName, fieldDef);
        return stmt;
    }
}
