package com.github.cluelessskywatcher.halcyonreimagined.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.github.cluelessskywatcher.halcyonreimagined.InputBuffer;
import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.halql.HalqlStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.HalqlStatementFactory;
import com.github.cluelessskywatcher.halcyonreimagined.halql.dml.InsertRowStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.dql.SelectTableStatement;
import com.github.cluelessskywatcher.halcyonreimagined.models.dml.InsertRowResult;
import com.github.cluelessskywatcher.halcyonreimagined.models.dql.SelectTableResult;

public class GeneralUtils {
    public static InsertRowResult invokeInsert(String query, InputBuffer buffer, HalqlStatementFactory factory) throws Exception {
        buffer.setBuffer(query);
        factory.prepareStatementFromBuffer(buffer);
        InsertRowStatement statement1 = (InsertRowStatement) factory.getPreparedStatement();
        statement1.execute();
        return (InsertRowResult) statement1.getResult();
    }

    public static SelectTableResult invokeSelect(String query, InputBuffer buffer, HalqlStatementFactory factory) throws Exception {
        buffer.setBuffer(query);
        factory.prepareStatementFromBuffer(buffer);
        SelectTableStatement statement1 = (SelectTableStatement) factory.getPreparedStatement();
        statement1.execute();
        return (SelectTableResult) statement1.getResult();
    }

    public static Class<?> getQueryType(String query, InputBuffer buffer, HalqlStatementFactory factory) throws Exception {
        buffer.setBuffer(query);
        factory.prepareStatementFromBuffer(buffer);
        HalqlStatement statement1 = factory.getPreparedStatement();
        return statement1.getClass();
    }

    public static boolean matchTuples(Tuple[] l1, Tuple[] l2) {
        return new HashSet<>(Arrays.asList(l1)).equals(new HashSet<>(Arrays.asList(l2)));
    }
}
