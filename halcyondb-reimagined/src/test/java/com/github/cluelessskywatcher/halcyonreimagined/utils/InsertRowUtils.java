package com.github.cluelessskywatcher.halcyonreimagined.utils;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;

import com.github.cluelessskywatcher.halcyonreimagined.InputBuffer;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;
import com.github.cluelessskywatcher.halcyonreimagined.halql.HalqlStatementFactory;
import com.github.cluelessskywatcher.halcyonreimagined.halql.dml.InsertRowStatement;

public class InsertRowUtils {
    public static void testInsertQueryData(String insertQuery, 
        String tableName, DataField[] values
    ) throws Exception {
        InputBuffer buffer = new TestingBuffer();
        
        HalqlStatementFactory factory = new HalqlStatementFactory();
        buffer.setBuffer(insertQuery);
        
        factory.prepareStatementFromBuffer(buffer);
        InsertRowStatement statement1 = (InsertRowStatement) factory.getPreparedStatement();
        
        Assertions.assertTrue(statement1.getTable().getTableName().equals(tableName));
        Assertions.assertTrue(Arrays.equals(statement1.getValues(), values));
    }
}
