package com.github.cluelessskywatcher.halcyonreimagined.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.LongField;

import lombok.Getter;

public class TupleProjection {
    private @Getter TupleMetadata metadata;
    private @Getter List<String> projection;
    private @Getter DataField[] fields;

    public TupleProjection(Tuple tuple, List<String> projection) throws Exception {
        this.metadata = tuple.getMetadata();
        this.projection = projection;

        if (this.projection.size() == 0) {
            String[] metadataFields = metadata.getFieldNames();

            this.projection = new ArrayList<>();
            this.projection.add("id");
            this.projection.addAll(Arrays.asList(metadataFields));

            this.fields = new DataField[tuple.getFieldCount() + 1];
            this.fields[0] = new LongField(tuple.getTupleKey());
            for (int i = 0; i < metadataFields.length; i++) {
                this.fields[i + 1] = tuple.getFieldFromName(metadataFields[i]);
            }
        }
        else {
            this.fields = new DataField[projection.size()];
            for (int i = 0; i < projection.size(); i++) {
                this.fields[i] = tuple.getFieldFromName(projection.get(i));
            }
        }        
    }

    public TupleProjection(Tuple tuple) throws Exception {
        this(tuple, new ArrayList<>());
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ");
        for (int i = 0; i < fields.length; i++) {
            joiner.add(fields[i].toString());
        }

        return String.format("(%s)", joiner.toString());
    }

    public int hashCode() {
        int result = Objects.hash(metadata, projection);
        result = 31 * result + Arrays.hashCode(fields);
        return result;
    }

    public boolean equals(Object other) {
        if (other == null) return false;
        if (!(other instanceof TupleProjection)) return false;

        TupleProjection otherProjection = (TupleProjection) other;

        return Arrays.equals(this.fields, otherProjection.fields)
            && this.projection.equals(otherProjection.projection)
            && this.metadata.equals(otherProjection.metadata);
    }
}
