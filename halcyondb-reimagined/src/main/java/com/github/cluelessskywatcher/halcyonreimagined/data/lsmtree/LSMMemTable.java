package com.github.cluelessskywatcher.halcyonreimagined.data.lsmtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.filtering.FilterMap;

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

    public Tuple getValue(Long key) {
        return memMap.get(key);
    }

    public void insert(Tuple tuple) {
        memMap.put(tuple.getTupleKey(), tuple);
    }

    public void reset() {
        memMap = new TreeMap<>();
    }

    public List<Tuple> selectByFilter(FilterMap filters) throws Exception {
        List<Tuple> tupleList = new ArrayList<>();

        for (Map.Entry<Long, Tuple> entry : memMap.entrySet()) {
            // Ignore tombstone tuples
            if (entry.getValue().isTombStone()) {
                continue;
            }
            if (filters.satisfiesFilters(entry.getValue())) {
                tupleList.add(entry.getValue());
            }
        }

        return tupleList;
    }
}
