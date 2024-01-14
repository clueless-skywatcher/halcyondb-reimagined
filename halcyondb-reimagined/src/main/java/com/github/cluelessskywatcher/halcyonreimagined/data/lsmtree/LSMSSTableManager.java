package com.github.cluelessskywatcher.halcyonreimagined.data.lsmtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;
import com.github.cluelessskywatcher.halcyonreimagined.filtering.FilterMap;


import lombok.Getter;

public class LSMSSTableManager {
    private Map<Long, LSMSSTable> ssTableMap;
    private @Getter String tableName;
    private @Getter TupleMetadata metadata;

    public LSMSSTableManager(String tableName, TupleMetadata metadata) {
        this.ssTableMap = new TreeMap<>();
        this.tableName = tableName;
        this.metadata = metadata;
    }

    public void flush(LSMMemTable memTable) throws Exception {
        LSMSSTable ssTable = new LSMSSTable(tableName, System.nanoTime(), metadata);
        ssTable.flush(memTable.getMemMap());
        ssTableMap.put(ssTable.getTimestamp(), ssTable);
    }

    public Tuple[] selectAll() throws Exception {
        List<Tuple> allTuples = new ArrayList<>();

        for (LSMSSTable ssTable : this.ssTableMap.values()) {
            allTuples.addAll(ssTable.selectAll());
        } 

        return allTuples.toArray(new Tuple[0]);
    }

    public List<Tuple> selectByFilter(FilterMap filters) throws Exception {
        List<Tuple> filterTuples = new ArrayList<>();

        for (LSMSSTable ssTable : this.ssTableMap.values()) {
            filterTuples.addAll(ssTable.selectByFilter(filters));
        }

        return filterTuples;
    } 
}
