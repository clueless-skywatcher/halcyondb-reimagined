package com.github.cluelessskywatcher.halcyonreimagined.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.InputBuffer;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataConstants;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleProjection;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.IntegerField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.StringField;
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

    public static boolean matchTuples(TupleProjection[] l1, TupleProjection[] l2) {
        if (l1.length != l2.length) {
            return false;
        }

        Map<String, Integer> elementCount = new HashMap<>();

        for (TupleProjection element : l1) {
            String elementString = element.toString();
            elementCount.put(elementString, elementCount.getOrDefault(elementString, 0) + 1);
        }

        for (TupleProjection element : l2) {
            String elementString = element.toString();
            if (!elementCount.containsKey(elementString) || elementCount.get(elementString) == 0) {
                return false;
            }

            elementCount.put(elementString, elementCount.get(elementString) - 1);
        }

        return true;
    }

    public static TupleProjection[] insertRandomRowsAndSelectStar(String table, int count, InputBuffer buffer) throws Exception {
        TupleMetadata metadata = HalcyonDBInstance.getCatalog().getTableMetadata(table);

        TupleProjection[] rows = new TupleProjection[count];

        for (int j = 0; j < count; j++) {
            DataField[] fields = new DataField[metadata.getFieldCount()];
            Random random = new Random();
            for (int i = 0; i < metadata.getFieldCount(); i++) {
                DataType type = metadata.getTypeAt(i);
                if (type == DataType.INTEGER) {
                    fields[i] = new IntegerField(random.nextInt());
                }
                else {
                    fields[i] = new StringField(getRandomString(random.nextInt(1, 10)));
                }
            }

            Tuple tuple = Tuple.construct(fields, metadata, HalcyonDBInstance.getCurrentId());

            GeneralUtils.invokeInsert(
                String.format(
                    "insert into %s values %s;",
                    table,
                    tuple.represent()
                ), 
                buffer
            );

            rows[j] = tuple.project();
        }

        return rows;
    }

    public static String getRandomString(int length) {
        StringBuilder randomStringBuilder = new StringBuilder(length);
        Random random = new Random();

        // Generate the random string by appending random characters
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(DataConstants.CHARACTER_LIST.length());
            char randomChar = DataConstants.CHARACTER_LIST.charAt(index);
            randomStringBuilder.append(randomChar);
        }

        return randomStringBuilder.toString();
    }
}
