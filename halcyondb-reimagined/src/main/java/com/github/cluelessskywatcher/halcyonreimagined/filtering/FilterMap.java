package com.github.cluelessskywatcher.halcyonreimagined.filtering;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.exceptions.InvalidFieldNameException;

import lombok.Getter;

public class FilterMap {
    private Map<String, Object> filter;
    private @Getter TupleMetadata metadata;
    
    public FilterMap(TupleMetadata metadata) {
        filter = new HashMap<>();
        this.metadata = metadata;
    }

    public Object getFilterValue(String fieldName) {
        return filter.get(fieldName);
    }

    public void addFilter(String name, Object value) throws Exception {
        if (name != "id" || !Arrays.asList(metadata.getFieldNames()).contains(name)) {
            throw new InvalidFieldNameException("Invalid field name");
        }
        filter.put(name, value);
    }  
}
