package com.github.cluelessskywatcher.halcyonreimagined.querytest;

import java.util.Random;
import java.util.StringJoiner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.IntegerField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.StringField;
import com.github.cluelessskywatcher.halcyonreimagined.halql.HalqlParserEngine;
import com.github.cluelessskywatcher.halcyonreimagined.halql.HalqlStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.dml.InsertRowStatement;
import com.github.cluelessskywatcher.halcyonreimagined.utils.GeneralUtils;
import com.github.cluelessskywatcher.halcyonreimagined.utils.InsertRowUtils;
import com.github.cluelessskywatcher.halcyonreimagined.utils.TestingBuffer;

@TestInstance(Lifecycle.PER_CLASS)
public class InsertRowStatementTest {
    private TestingBuffer buffer;
    
    @BeforeAll
    public void setUp() throws Exception {
        this.buffer = new TestingBuffer();
        
        HalcyonDBInstance.getCatalog().addTable("table1",
            new TupleMetadata(
                new DataType[] {DataType.INTEGER, DataType.INTEGER, DataType.INTEGER},
                new String[] {"field1", "field2", "field3"}
            )
        );
        HalcyonDBInstance.getCatalog().addTable("table2",
            new TupleMetadata(
                new DataType[] {DataType.STRING, DataType.STRING, DataType.STRING},
                new String[] {"field1", "field2", "field3"}
            )
        );
    }

    @AfterAll
    public void shutDown() {
        HalcyonDBInstance.factoryReset();
    }

    @Test
    public void testQueryType() throws Exception {
        buffer = new TestingBuffer();
        buffer.setBuffer("insert into table1 values (1, 2, 3);");
        HalqlStatement stmt = HalqlParserEngine.parseQuery(buffer);
        Assertions.assertEquals(stmt.getClass(), InsertRowStatement.class);
    }

    @Test
    public void testQueryDataInt() throws Exception {
        Random random = new Random();
        int[] vals = new int[3];
        StringJoiner joiner = new StringJoiner(", ");
        DataField[] fields = new DataField[3];
        for (int i = 0; i < 3; i++) {
            vals[i] = random.nextInt(100);
            joiner.add(Integer.toString(vals[i]));
            fields[i] = new IntegerField(vals[i]);
        }
        InsertRowUtils.testInsertQueryData(
            String.format(
                "insert into table1 values (%s);",
                joiner.toString()
            ),
            "table1",
            fields
        );
    }

    @Test
    public void testQueryDataStr() throws Exception {
        String[] vals = new String[] {"abc", "def", "ghi"};
        StringJoiner joiner = new StringJoiner(", ");
        DataField[] fields = new DataField[3];
        for (int i = 0; i < 3; i++) {
            joiner.add(String.format("\"%s\"", vals[i]));
            fields[i] = new StringField(vals[i]);
        }
        InsertRowUtils.testInsertQueryData(
            String.format(
                "insert into table2 values (%s);",
                joiner.toString()
            ),
            "table2",
            fields
        );
    }

    @Test
    public void testRowCount() throws Exception {
        HalcyonDBInstance.factoryReset();
        this.buffer = new TestingBuffer();
        
        HalcyonDBInstance.getCatalog().addTable("table1",
            new TupleMetadata(
                new DataType[] {DataType.INTEGER, DataType.INTEGER},
                new String[] {"field1", "field2"}
            )
        );
        HalcyonDBInstance.getCatalog().addTable("table2",
            new TupleMetadata(
                new DataType[] {DataType.STRING, DataType.STRING, DataType.STRING},
                new String[] {"field1", "field2", "field3"}
            )
        );
        
        GeneralUtils.invokeInsert("insert into table1 values (1, 2);", buffer);
        Assertions.assertEquals(HalcyonDBInstance.getCatalog().getTable("table1").getRowCount(), 1);
        GeneralUtils.invokeInsert("insert into table1 values (2, 3);", buffer);
        Assertions.assertEquals(HalcyonDBInstance.getCatalog().getTable("table1").getRowCount(), 2);
        GeneralUtils.invokeInsert("insert into table1 values (3, 11);", buffer);
        Assertions.assertEquals(HalcyonDBInstance.getCatalog().getTable("table1").getRowCount(), 3);

        GeneralUtils.invokeInsert("insert into table2 values (\"This\", \"is\", \"Sentence1\");", buffer);
        Assertions.assertEquals(HalcyonDBInstance.getCatalog().getTable("table2").getRowCount(), 1);
        GeneralUtils.invokeInsert("insert into table2 values (\"This\", \"is\", \"Sentence2\");", buffer);
        Assertions.assertEquals(HalcyonDBInstance.getCatalog().getTable("table2").getRowCount(), 2);
        GeneralUtils.invokeInsert("insert into table2 values (\"This\", \"is\", \"Sentence3\");", buffer);
        Assertions.assertEquals(HalcyonDBInstance.getCatalog().getTable("table2").getRowCount(), 3);        
    
        HalcyonDBInstance.softReset();
        this.buffer = new TestingBuffer();
        
        HalcyonDBInstance.getCatalog().addTable("table1",
            new TupleMetadata(
                new DataType[] {DataType.INTEGER, DataType.INTEGER},
                new String[] {"field1", "field2"}
            )
        );
        HalcyonDBInstance.getCatalog().addTable("table2",
            new TupleMetadata(
                new DataType[] {DataType.STRING, DataType.STRING, DataType.STRING},
                new String[] {"field1", "field2", "field3"}
            )
        );

        Assertions.assertEquals(HalcyonDBInstance.getCatalog().getTable("table1").getRowCount(), 3);
        Assertions.assertEquals(HalcyonDBInstance.getCatalog().getTable("table2").getRowCount(), 3);
    }
}
