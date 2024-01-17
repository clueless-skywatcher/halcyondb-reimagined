package com.github.cluelessskywatcher.halcyonreimagined.querytest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleProjection;
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

        TupleProjection[] table1ExpectedResult = new TupleProjection[] {
            Tuple.construct(
                new DataField[] {
                    new IntegerField(1),
                    new IntegerField(2)
                }, 
                metadata,
                0
            ).project(),
            Tuple.construct(
                new DataField[] {
                    new IntegerField(2),
                    new IntegerField(3)
                }, 
                metadata,
                1
            ).project(),
            Tuple.construct(
                new DataField[] {
                    new IntegerField(3),
                    new IntegerField(11)
                }, 
                metadata,
                2
            ).project()
        };
        SelectTableResult result = GeneralUtils.invokeSelect("select * from table1;", buffer);
        Assertions.assertEquals(result.getRows().length, 3);
        Assertions.assertTrue(GeneralUtils.matchTuples(result.getRows(), table1ExpectedResult));
    }

    @Test
    public void testProjectionField1Table1() throws Exception {
        TupleMetadata metadata = new TupleMetadata(
            new DataType[] {DataType.INTEGER, DataType.INTEGER},
            new String[] {"field1", "field2"}
        );

        List<String> projection = new ArrayList<>();
        projection.add("field1");

        TupleProjection[] table1ExpectedResult = new TupleProjection[] {
            Tuple.construct(
                new DataField[] {
                    new IntegerField(1),
                    new IntegerField(2)
                }, 
                metadata,
                0
            ).project(projection),
            Tuple.construct(
                new DataField[] {
                    new IntegerField(2),
                    new IntegerField(3)
                }, 
                metadata,
                1
            ).project(projection),
            Tuple.construct(
                new DataField[] {
                    new IntegerField(3),
                    new IntegerField(11)
                }, 
                metadata,
                2
            ).project(projection)
        };
        SelectTableResult result = GeneralUtils.invokeSelect("select field1 from table1;", buffer);
        Assertions.assertEquals(result.getRows().length, 3);
        Assertions.assertTrue(GeneralUtils.matchTuples(result.getRows(), table1ExpectedResult));
    }

    

    @Test
    public void testQueryDataStr() throws Exception {
        TupleMetadata metadata = new TupleMetadata(
            new DataType[] {DataType.STRING, DataType.STRING, DataType.STRING},
            new String[] {"field1", "field2", "field3"}
        );

        TupleProjection[] table2ExpectedResult = new TupleProjection[] {
            Tuple.construct(
                new DataField[] {
                    new StringField("This"),
                    new StringField("is"),
                    new StringField("Sentence1")
                }, 
                metadata,
                3
            ).project(),
            Tuple.construct(
                new DataField[] {
                    new StringField("This"),
                    new StringField("is"),
                    new StringField("Sentence2")
                },
                metadata,
                4
            ).project(),
            Tuple.construct(
                new DataField[] {
                    new StringField("This"),
                    new StringField("is"),
                    new StringField("Sentence3")
                },
                metadata,
                5
            ).project()
        };
        SelectTableResult result = GeneralUtils.invokeSelect("select * from table2;", buffer);
        Assertions.assertEquals(result.getRows().length, 3);
        Assertions.assertTrue(GeneralUtils.matchTuples(result.getRows(), table2ExpectedResult));
    }

    @Test
    public void testQueryDataById() throws Exception {
        TupleMetadata metadata = new TupleMetadata(
            new DataType[] {DataType.INTEGER, DataType.INTEGER},
            new String[] {"field1", "field2"}
        );

        TupleProjection[] table1Result = new TupleProjection[] {
            Tuple.construct(
                new DataField[] {
                    new IntegerField(1),
                    new IntegerField(2)
                }, 
                metadata,
                0
            ).project(),
            Tuple.construct(
                new DataField[] {
                    new IntegerField(2),
                    new IntegerField(3)
                }, 
                metadata,
                1
            ).project(),
            Tuple.construct(
                new DataField[] {
                    new IntegerField(3),
                    new IntegerField(11)
                }, 
                metadata,
                2
            ).project()
        };
        SelectTableResult result;

        result = GeneralUtils.invokeSelect("select * from table1 where id = 0;", buffer);
        Assertions.assertTrue(Arrays.equals(new TupleProjection[] {table1Result[0]}, result.getRows()));
        
        result = GeneralUtils.invokeSelect("select * from table1 where id = 1;", buffer);
        Assertions.assertTrue(Arrays.equals(new TupleProjection[] {table1Result[1]}, result.getRows()));

        result = GeneralUtils.invokeSelect("select * from table1 where id = 2;", buffer);
        Assertions.assertTrue(Arrays.equals(new TupleProjection[] {table1Result[2]}, result.getRows()));
    }

    @Test
    public void testTable1ByFields() throws Exception {
        TupleMetadata metadata = new TupleMetadata(
            new DataType[] {DataType.INTEGER, DataType.INTEGER},
            new String[] {"field1", "field2"}
        );

        TupleProjection[] table1Result = new TupleProjection[] {
            Tuple.construct(
                new DataField[] {
                    new IntegerField(1),
                    new IntegerField(2)
                }, 
                metadata,
                0
            ).project(),
            Tuple.construct(
                new DataField[] {
                    new IntegerField(2),
                    new IntegerField(3)
                }, 
                metadata,
                1
            ).project(),
            Tuple.construct(
                new DataField[] {
                    new IntegerField(3),
                    new IntegerField(11)
                }, 
                metadata,
                2
            ).project()
        };
        SelectTableResult result;

        result = GeneralUtils.invokeSelect("select * from table1 where field1 = 1;", buffer);
        Assertions.assertTrue(Arrays.equals(new TupleProjection[] {table1Result[0]}, result.getRows()));
        
        result = GeneralUtils.invokeSelect("select * from table1 where field1 = 2;", buffer);
        Assertions.assertTrue(Arrays.equals(new TupleProjection[] {table1Result[1]}, result.getRows()));

        result = GeneralUtils.invokeSelect("select * from table1 where field1 = 3;", buffer);
        Assertions.assertTrue(Arrays.equals(new TupleProjection[] {table1Result[2]}, result.getRows()));

        result = GeneralUtils.invokeSelect("select * from table1 where field2 = 2;", buffer);
        Assertions.assertTrue(Arrays.equals(new TupleProjection[] {table1Result[0]}, result.getRows()));
        
        result = GeneralUtils.invokeSelect("select * from table1 where field2 = 3;", buffer);
        Assertions.assertTrue(Arrays.equals(new TupleProjection[] {table1Result[1]}, result.getRows()));

        result = GeneralUtils.invokeSelect("select * from table1 where field2 = 11;", buffer);
        Assertions.assertTrue(Arrays.equals(new TupleProjection[] {table1Result[2]}, result.getRows()));
    }

    @Test
    public void testTable2ByFields() throws Exception {
        TupleMetadata metadata = new TupleMetadata(
            new DataType[] {DataType.STRING, DataType.STRING, DataType.STRING},
            new String[] {"field1", "field2", "field3"}
        );

        TupleProjection[] table2ExpectedResult = new TupleProjection[] {
            Tuple.construct(
                new DataField[] {
                    new StringField("This"),
                    new StringField("is"),
                    new StringField("Sentence1")
                }, 
                metadata,
                3
            ).project(),
            Tuple.construct(
                new DataField[] {
                    new StringField("This"),
                    new StringField("is"),
                    new StringField("Sentence2")
                },
                metadata,
                4
            ).project(),
            Tuple.construct(
                new DataField[] {
                    new StringField("This"),
                    new StringField("is"),
                    new StringField("Sentence3")
                },
                metadata,
                5
            ).project()
        };
        SelectTableResult result;

        result = GeneralUtils.invokeSelect("select * from table2 where field3 = \"Sentence1\";", buffer);
        Assertions.assertTrue(Arrays.equals(new TupleProjection[] {table2ExpectedResult[0]}, result.getRows()));
        
        result = GeneralUtils.invokeSelect("select * from table2 where field3 = \"Sentence2\";", buffer);
        Assertions.assertTrue(Arrays.equals(new TupleProjection[] {table2ExpectedResult[1]}, result.getRows()));

        result = GeneralUtils.invokeSelect("select * from table2 where field3 = \"Sentence3\";", buffer);
        Assertions.assertTrue(Arrays.equals(new TupleProjection[] {table2ExpectedResult[2]}, result.getRows()));
    
        result = GeneralUtils.invokeSelect("select * from table2 where field1 = \"This\";", buffer);
        Assertions.assertTrue(Arrays.equals(table2ExpectedResult, result.getRows()));
    }

    @Test
    public void testRandomRowsTable1() throws Exception  {
        HalcyonDBInstance.factoryReset();

        HalcyonDBInstance.getCatalog().addTable("table1",
            new TupleMetadata(
                new DataType[] {DataType.INTEGER, DataType.INTEGER},
                new String[] {"field1", "field2"}
            )
        );
        
        TupleProjection[] table1Results = GeneralUtils.insertRandomRowsAndSelectStar("table1", 10, buffer);
        
        SelectTableResult result = GeneralUtils.invokeSelect("select * from table1;", buffer);
        Assertions.assertTrue(Arrays.equals(table1Results, result.getRows()));

        System.err.println();
    }

    @Test
    public void testRandomRowsTable2() throws Exception  {
        HalcyonDBInstance.factoryReset();

        HalcyonDBInstance.getCatalog().addTable("table2",
            new TupleMetadata(
                new DataType[] {DataType.STRING, DataType.STRING, DataType.STRING},
                new String[] {"field1", "field2", "field3"}
            )
        );
        
        TupleProjection[] table2Results = GeneralUtils.insertRandomRowsAndSelectStar("table2", 10, buffer);

        SelectTableResult result = GeneralUtils.invokeSelect("select * from table2;", buffer);
        
        Assertions.assertTrue(Arrays.equals(table2Results, result.getRows()));

        System.err.println();
    }
}
