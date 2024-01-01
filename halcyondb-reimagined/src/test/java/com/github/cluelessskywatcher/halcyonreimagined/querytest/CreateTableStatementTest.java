package com.github.cluelessskywatcher.halcyonreimagined.querytest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.halql.models.ddl.CreateTableResult;
import com.github.cluelessskywatcher.halcyonreimagined.utils.GeneralUtils;
import com.github.cluelessskywatcher.halcyonreimagined.utils.TestingBuffer;

@TestInstance(Lifecycle.PER_CLASS)
public class CreateTableStatementTest {
    private TestingBuffer buffer;

    @BeforeAll
    public void setUp() {
        this.buffer = new TestingBuffer();
    }

    @AfterAll
    public void shutDown() {
        HalcyonDBInstance.factoryReset();
    }
    
    @Test
    public void testSuccessfulCreation() throws Exception {
        Assertions.assertFalse(HalcyonDBInstance.getCatalog().tableExists("table1"));
        CreateTableResult result;
        result = GeneralUtils.invokeCreate("create table table1 with (field1 int, field2 string, field3 int);", buffer);
        Assertions.assertEquals(result.getTableName(), "table1");
        Assertions.assertEquals(result.getMetadata(), new TupleMetadata(
            new DataType[] {DataType.INTEGER, DataType.STRING, DataType.INTEGER},
            new String[] {"field1", "field2", "field3"}
        ));
        Assertions.assertTrue(HalcyonDBInstance.getCatalog().tableExists("table1"));
        result = GeneralUtils.invokeCreate("create table table1 with (field1 int, field2 string, field3 int);", buffer);
        Assertions.assertEquals(result.getTableName(), null);
        Assertions.assertEquals(result.getMetadata(), null);
        Assertions.assertNotEquals(result.getError(), null);
    }
}
