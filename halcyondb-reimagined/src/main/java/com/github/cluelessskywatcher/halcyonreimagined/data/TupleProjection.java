package com.github.cluelessskywatcher.halcyonreimagined.data;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;

import lombok.Getter;

public class TupleProjection {
    private @Getter Tuple tuple;
    private @Getter TupleMetadata metadata;
    private @Getter List<String> projection;
    private @Getter boolean isSelectStar;
    private @Getter DataField[] fields;

    public TupleProjection(Tuple tuple, TupleMetadata metadata, List<String> projection) throws Exception {
        this.tuple = tuple;
        this.metadata = metadata;
        this.projection = projection;

        if (this.projection.size() == 0) {
            this.fields = new DataField[tuple.getFieldCount()];
            this.isSelectStar = true;
            for (int i = 0; i < tuple.getFieldCount(); i++) {
                this.fields[i] = tuple.getFieldAt(i);
            }
        }
        else {
            this.fields = new DataField[projection.size()];
            this.isSelectStar = false;
            for (int i = 0; i < projection.size(); i++) {
                this.fields[i] = tuple.getFieldFromName(projection.get(i));
            }
        }        
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < fields.length; i++) {
            joiner.add(fields[i].toString());
        }

        return String.format("(%s)", joiner.toString());
    }
}
