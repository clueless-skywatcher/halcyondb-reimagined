package com.github.cluelessskywatcher.halcyonreimagined.querytest;

import java.util.Random;
import java.util.StringJoiner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.function.Executable;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.IntegerField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.StringField;
import com.github.cluelessskywatcher.halcyonreimagined.exceptions.QueryParsingException;
import com.github.cluelessskywatcher.halcyonreimagined.exceptions.TableNotFoundException;
import com.github.cluelessskywatcher.halcyonreimagined.halql.HalqlStatementFactory;
import com.github.cluelessskywatcher.halcyonreimagined.halql.dml.InsertRowStatement;
import com.github.cluelessskywatcher.halcyonreimagined.utils.InsertRowUtils;
import com.github.cluelessskywatcher.halcyonreimagined.utils.TestingBuffer;

@TestInstance(Lifecycle.PER_CLASS)
public class InsertRowStatementTest {
    private TestingBuffer buffer;
    private HalqlStatementFactory factory;

    @BeforeAll
    public void setUp() {
        this.buffer = new TestingBuffer();
        this.factory = new HalqlStatementFactory();

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
        HalcyonDBInstance.reset();
    }

    @Test
    public void testQueryType() throws Exception {
        buffer = new TestingBuffer();
        factory = new HalqlStatementFactory();
        buffer.setBuffer("insert into table1 values (1, 2, 3);");
        factory.prepareStatementFromBuffer(buffer);
        Assertions.assertEquals(factory.getPreparedStatement().getClass(), InsertRowStatement.class);
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
    public void testErrors() {
        Assertions.assertThrows(TableNotFoundException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                String[] vals = new String[] {"abc", "def", "ghi"};
                StringJoiner joiner = new StringJoiner(", ");
                DataField[] fields = new DataField[3];
                for (int i = 0; i < 3; i++) {
                    joiner.add(String.format("\"%s\"", vals[i]));
                    fields[i] = new StringField(vals[i]);
                }
                InsertRowUtils.testInsertQueryData(
                    String.format(
                        "insert into table3 values (%s);",
                        joiner.toString()
                    ),
                    "table3",
                    fields
                );
            }
            
        });
        Assertions.assertThrows(QueryParsingException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                String[] vals = new String[] {"abc", "def", "ghi"};
                StringJoiner joiner = new StringJoiner(", ");
                DataField[] fields = new DataField[3];
                for (int i = 0; i < 3; i++) {
                    joiner.add(String.format("%s", vals[i]));
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
        });
    }

    @Test
    public void testQueryFieldLength() throws Exception {
        Assertions.assertThrows(QueryParsingException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                String[] vals = new String[] {"abc", "def"};
                StringJoiner joiner = new StringJoiner(", ");
                DataField[] fields = new DataField[3];
                for (int i = 0; i < vals.length; i++) {
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
        });
        Assertions.assertThrows(QueryParsingException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                String[] vals = new String[] {"abc", "def", "ghi", "jkl"};
                StringJoiner joiner = new StringJoiner(", ");
                DataField[] fields = new DataField[4];
                for (int i = 0; i < vals.length; i++) {
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
        });
    }
}
