package com.github.cluelessskywatcher.halcyonreimagined.halql.dml;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import com.github.cluelessskywatcher.halcyonreimagined.SchemaCatalog;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataTable;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.IntegerField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.StringField;
import com.github.cluelessskywatcher.halcyonreimagined.halql.TableRelatedStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.models.dml.InsertRowResult;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InsertRowStatement extends TableRelatedStatement {
    private String[] fieldNames;
    private DataField[] values;
    public InsertRowStatement(String tableName, String[] values) {
        SchemaCatalog schemaCatalog = HalcyonDBInstance.getCatalog();

        if (schemaCatalog.getTable(tableName) == null) {
            String errorMsg = String.format(
                    "No table called %s in database",
                    tableName);
            setResult(new InsertRowResult(errorMsg));
            return;
        } else {
            setTableDescription(schemaCatalog.getTableMetadata(tableName));
            setTable(schemaCatalog.getTable(tableName));

            if (getTableDescription().getFieldCount() != values.length) {
                String errorMsg = String.format(
                        "Query has %d fields while table %s has %d fields",
                        values.length,
                        tableName,
                        getTableDescription().getFieldCount());
                setResult(new InsertRowResult(errorMsg));
                return;
            }
        }

        DataField[] fieldValues = new DataField[values.length];

        TupleMetadata metadata = getTableDescription();

        for (int i = 0; i < metadata.getFieldCount(); i++) {
            if (metadata.getTypeAt(i) == DataType.INTEGER) {
                int val = Integer.parseInt(values[i]);
                fieldValues[i] = new IntegerField(val);
            }
            else if (metadata.getTypeAt(i) == DataType.STRING) {
                String val = values[i].replace("\"", "");
                fieldValues[i] = new StringField(val);
            }
        }

        this.values = fieldValues;
    }

    @Override
    public void execute() throws Exception {
        Tuple tuple = Tuple.construct(getValues(), getTableDescription());
        DataTable table = getTable();
        
        long time = System.currentTimeMillis();
        table.insert(tuple);
        time = System.currentTimeMillis() - time;
        
        setTable(table);
        setResult(new InsertRowResult(getTable().getTableName(), new Tuple[] { tuple }, time));
        HalcyonDBInstance.getCatalog().addTable(table, getTableDescription());
    }

    // @Override
    // public void extractDataFromStatement() throws Exception {
    // // insert into tablename values (1, 'abc');
    // // We use hardcoded values for now. We need to change this to accept
    // // any name, and look it up in the catalog. Will throw exception if
    // // table is not found
    // Pattern insertPattern = Pattern.compile("insert into (\\w+) values
    // \\(([^()]*)\\);");
    // Matcher matcher = insertPattern.matcher(getStatement());
    // matcher.matches();
    // String tableName = matcher.group(1);
    // String[] fields = matcher.group(2).split("[ ,]+");

    // SchemaCatalog schemaCatalog = HalcyonDBInstance.getCatalog();

    // if (schemaCatalog.getTable(tableName) == null) {
    // String errorMsg = String.format(
    // "No table called %s in database",
    // tableName
    // );
    // setResult(new InsertRowResult(errorMsg));
    // return;
    // } else {
    // setTableDescription(schemaCatalog.getTableMetadata(tableName));
    // setTable(schemaCatalog.getTable(tableName));
    // }

    // if (getTableDescription().getFieldCount() != fields.length) {
    // String errorMsg = String.format(
    // "Query has %d fields while table %s has %d fields",
    // fields.length,
    // tableName,
    // getTableDescription().getFieldCount()
    // );
    // setResult(new InsertRowResult(errorMsg));
    // return;
    // }

    // DataField[] fieldVals = new DataField[getTableDescription().getFieldCount()];

    // for (int i = 0; i < fieldVals.length; i++) {
    // if (getTableDescription().getTypeAt(i) == DataType.INTEGER) {
    // fieldVals[i] = new IntegerField(Integer.parseInt(fields[i].trim()));
    // }
    // else if (getTableDescription().getTypeAt(i) == DataType.STRING) {
    // if (!fields[i].startsWith("\"") || !fields[i].endsWith("\"")) {
    // setResult(new InsertRowResult("Strings should be enclosed within double
    // quotes"));
    // return;
    // }
    // fields[i] = fields[i].replace("\"", "");
    // fieldVals[i] = new StringField(fields[i]);
    // }
    // }
    // System.err.println(Arrays.toString(fieldVals));
    // setValues(fieldVals);
    // }
}
