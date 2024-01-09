package com.github.cluelessskywatcher.halcyonreimagined.querytest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.IntegerField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.StringField;
import com.github.cluelessskywatcher.halcyonreimagined.halql.dql.SelectTableStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.models.dql.SelectTableResult;
import com.github.cluelessskywatcher.halcyonreimagined.utils.GeneralUtils;
import com.github.cluelessskywatcher.halcyonreimagined.utils.TestingBuffer;

@TestInstance(Lifecycle.PER_CLASS)
public class SelectTableStatementTest {
    private TestingBuffer buffer;
    
    @BeforeAll
    public void setUp() throws Exception {
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
        GeneralUtils.invokeInsert("insert into table1 values (2, 3);", buffer);
        GeneralUtils.invokeInsert("insert into table1 values (3, 11);", buffer);
        GeneralUtils.invokeInsert("insert into table2 values (\"This\", \"is\", \"Sentence1\");", buffer);
        GeneralUtils.invokeInsert("insert into table2 values (\"This\", \"is\", \"Sentence2\");", buffer);
        GeneralUtils.invokeInsert("insert into table2 values (\"This\", \"is\", \"Sentence3\");", buffer);
    }

    @AfterAll
    public void shutDown() throws Exception {
        HalcyonDBInstance.factoryReset();
    }

    @Test
    public void testQueryType() throws Exception {
        Assertions.assertEquals(
            GeneralUtils.getQueryType("select * from table1;", buffer),
            SelectTableStatement.class
        );
    }

    @Test
    public void testQueryDataInt() throws Exception {
        TupleMetadata metadata = new TupleMetadata(
            new DataType[] {DataType.INTEGER, DataType.INTEGER},
            new String[] {"field1", "field2"}
        );

        Tuple[] table1ExpectedResult = new Tuple[] {
            Tuple.construct(
                new DataField[] {
                    new IntegerField(1),
                    new IntegerField(2)
                }, 
                metadata,
                0
            ),
            Tuple.construct(
                new DataField[] {
                    new IntegerField(2),
                    new IntegerField(3)
                }, 
                metadata,
                1
            ),
            Tuple.construct(
                new DataField[] {
                    new IntegerField(3),
                    new IntegerField(11)
                }, 
                metadata,
                2
            )
        };
        SelectTableResult result = GeneralUtils.invokeSelect("select * from table1;", buffer);
        Assertions.assertEquals(result.getRows().length, 3);
        Assertions.assertTrue(GeneralUtils.matchTuples(result.getRows(), table1ExpectedResult));
    }

    @Test
    public void testQueryDataStr() throws Exception {
        TupleMetadata metadata = new TupleMetadata(
            new DataType[] {DataType.STRING, DataType.STRING, DataType.STRING},
            new String[] {"field1", "field2", "field3"}
        );

        Tuple[] table2ExpectedResult = new Tuple[] {
            Tuple.construct(
                new DataField[] {
                    new StringField("This"),
                    new StringField("is"),
                    new StringField("Sentence1")
                }, 
                metadata,
                3
            ),
            Tuple.construct(
                new DataField[] {
                    new StringField("This"),
                    new StringField("is"),
                    new StringField("Sentence2")
                },
                metadata,
                4
            ),
            Tuple.construct(
                new DataField[] {
                    new StringField("This"),
                    new StringField("is"),
                    new StringField("Sentence3")
                },
                metadata,
                5
            )
        };
        SelectTableResult result = GeneralUtils.invokeSelect("select * from table2;", buffer);
        Assertions.assertEquals(result.getRows().length, 3);
        Assertions.assertTrue(GeneralUtils.matchTuples(result.getRows(), table2ExpectedResult));
    }
}
