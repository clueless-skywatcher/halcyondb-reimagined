package com.github.cluelessskywatcher.halcyonreimagined.data.lsmtree;

import java.util.Map;
import java.util.TreeMap;

import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;

import lombok.Getter;

public class LSMMemTable {
    private @Getter Map<Long, Tuple> memMap;
    private @Getter String tableName;
    private @Getter TupleMetadata metadata;

    public LSMMemTable(String tableName, TupleMetadata metadata) {
        this.memMap = new TreeMap<>();
        this.tableName = tableName;
        this.metadata = metadata;
    }

    public int size() {
        return memMap.size();
    }

    public void insert(Tuple tuple) {
        memMap.put(tuple.getTupleKey(), tuple);
    }

    public void reset() {
        memMap = new TreeMap<>();
    }
}
