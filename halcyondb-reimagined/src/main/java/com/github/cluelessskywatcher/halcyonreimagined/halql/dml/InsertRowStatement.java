package com.github.cluelessskywatcher.halcyonreimagined.halql.dml;

import java.util.Arrays;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.IntegerField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.StringField;
import com.github.cluelessskywatcher.halcyonreimagined.halql.TableRelatedStatement;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class InsertRowStatement extends TableRelatedStatement {
    private String tableName;
    private String[] fieldNames;
    private DataField[] values;

    public InsertRowStatement(String statement) {
        super(statement);
    }

    @Override
    public void execute() {
        System.out.printf("Inserting row into table: %s with values: %s\n", tableName, Arrays.toString(values));
    }

    @Override
    public void extractDataFromStatement() {
        // insert into tablename values (1, 'abc');
        // We use hardcoded values for now. We will parse statements with ANTLR later
        setTableName("sample1");
        setTableDescription(new TupleMetadata(
            new DataType[]{DataType.INTEGER, DataType.STRING},
            new String[] {"field1", "field2"}
        ));
        setValues(new DataField[] {new IntegerField(10), new StringField("Hello!")});
        System.out.println(getTableDescription());
    }    
}
