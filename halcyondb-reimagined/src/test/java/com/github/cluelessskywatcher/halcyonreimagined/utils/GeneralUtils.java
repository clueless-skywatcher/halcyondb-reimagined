package com.github.cluelessskywatcher.halcyonreimagined.utils;

import java.util.Arrays;
import java.util.HashSet;

import com.github.cluelessskywatcher.halcyonreimagined.InputBuffer;
import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.halql.HalqlParserEngine;
import com.github.cluelessskywatcher.halcyonreimagined.halql.HalqlStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.ddl.CreateTableStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.dml.InsertRowStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.dql.SelectTableStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.models.ddl.CreateTableResult;
import com.github.cluelessskywatcher.halcyonreimagined.halql.models.dml.InsertRowResult;
import com.github.cluelessskywatcher.halcyonreimagined.halql.models.dql.SelectTableResult;

public class GeneralUtils {
    public static InsertRowResult invokeInsert(String query, InputBuffer buffer) throws Exception {
        buffer.setBuffer(query);
        InsertRowStatement statement1 = (InsertRowStatement) HalqlParserEngine.parseQuery(buffer);
        statement1.execute();
        return (InsertRowResult) statement1.getResult();
    }

    public static SelectTableResult invokeSelect(String query, InputBuffer buffer) throws Exception {
        buffer.setBuffer(query);
        SelectTableStatement statement1 = (SelectTableStatement) HalqlParserEngine.parseQuery(buffer);
        statement1.execute();
        return (SelectTableResult) statement1.getResult();
    }

    public static CreateTableResult invokeCreate(String query, InputBuffer buffer) throws Exception {
        buffer.setBuffer(query);
        CreateTableStatement statement1 = (CreateTableStatement) HalqlParserEngine.parseQuery(buffer);
        statement1.execute();
        return (CreateTableResult) statement1.getResult();
    }

    public static Class<?> getQueryType(String query, InputBuffer buffer) throws Exception {
        buffer.setBuffer(query);
        HalqlStatement statement1 = HalqlParserEngine.parseQuery(buffer);
        return statement1.getClass();
    }

    public static boolean matchTuples(Tuple[] l1, Tuple[] l2) {
        return new HashSet<>(Arrays.asList(l1)).equals(new HashSet<>(Arrays.asList(l2)));
    }
}
