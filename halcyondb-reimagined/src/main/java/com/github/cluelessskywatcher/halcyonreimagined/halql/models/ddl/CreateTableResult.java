package com.github.cluelessskywatcher.halcyonreimagined.halql.models.ddl;

import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.halql.models.TableRelatedResult;

import lombok.Getter;

public class CreateTableResult extends TableRelatedResult {
    private @Getter TupleMetadata metadata;

    public CreateTableResult(String tableName, TupleMetadata metadata, long timeTaken) {
        this.tableName = tableName;
        this.metadata = metadata;
        this.timeTaken = timeTaken;
    }

    public CreateTableResult(String error) {
        this.error = error;
    }

    @Override
    public void showResult() {
        if (this.error != null) {
            System.out.println(String.format("Failed to create: %s", getError()));
        }
        else {
            System.out.println(
                String.format("Created table {}\nTime taken: {} ms", 
                tableName,
                getTimeTaken()
            ));
        }
    }
}
