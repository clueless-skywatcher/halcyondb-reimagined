package com.github.cluelessskywatcher.halcyonreimagined.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataType;
import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.DataField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.IntegerField;
import com.github.cluelessskywatcher.halcyonreimagined.data.fields.StringField;
import com.github.cluelessskywatcher.halcyonreimagined.exceptions.InvalidFieldNameException;

import lombok.Getter;
import lombok.Setter;

public class FilterMap {
    private Map<String, Object> filter;
    private @Getter @Setter TupleMetadata metadata;
    
    public FilterMap() {
        filter = new HashMap<>();
    }

    public FilterMap(TupleMetadata metadata) {
        filter = new HashMap<>();
        this.metadata = metadata;
    }

    public Object getFilterValue(String fieldName) {
        return filter.get(fieldName);
    }

    public void addFilter(String name, Object value) throws InvalidFieldNameException {
        if (!name.equals("id") && !Arrays.asList(metadata.getFieldNames()).contains(name)) {
            throw new InvalidFieldNameException(String.format("Field name %s does not exist", name));
        }
        DataType type = metadata.getTypeOf(name);
        if (type == DataType.STRING) {
            value = ((String) value).replace("\"", "");
        }
        filter.put(name, value);
    }

    public List<String> getFilterNames() {
        return new ArrayList<>(filter.keySet());
    }

    public boolean satisfiesFilters(Tuple tuple) throws Exception {
        boolean satisfiesAll = true;

        for (String filterName : getFilterNames()) {
            if (filterName.equals("id")) {
                Long filterKey = Long.parseLong((String) getFilterValue(filterName));

                satisfiesAll = satisfiesAll && (filterKey == tuple.getTupleKey());
            }
            else {
                DataField tupleValue = tuple.getFieldFromName(filterName);
                DataType filterType = metadata.getTypeOf(filterName);
                Object filterValue = getFilterValue(filterName);
                DataField filterValueDataField;

                if (filterType == DataType.INTEGER) {
                    filterValueDataField = new IntegerField(
                        Integer.parseInt((String) filterValue)
                    );
                }
                else if (filterType == DataType.STRING) {
                    filterValueDataField = new StringField(((String) filterValue));
                }
                else {
                    throw new Exception(String.format("DataType %s not supported", filterType.toString()));
                }

                satisfiesAll = satisfiesAll && (tupleValue.equals(filterValueDataField));
            }            
        }

        return satisfiesAll;
    }
}
