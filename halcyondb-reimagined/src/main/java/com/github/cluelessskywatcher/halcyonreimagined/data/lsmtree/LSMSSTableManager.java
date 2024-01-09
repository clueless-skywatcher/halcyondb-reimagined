package com.github.cluelessskywatcher.halcyonreimagined.data.lsmtree;

import java.util.ArrayList;
import java.util.List;

import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;

import lombok.Getter;

public class LSMSSTableManager {
    private List<LSMSSTable> ssTables;
    private @Getter String tableName;
    private @Getter TupleMetadata metadata;

    public LSMSSTableManager(String tableName, TupleMetadata metadata) {
        this.ssTables = new ArrayList<>();
        this.tableName = tableName;
        this.metadata = metadata;
    }

    public void flush(LSMMemTable memTable) throws Exception {
        LSMSSTable ssTable = new LSMSSTable(tableName, System.nanoTime(), metadata);
        ssTable.flush(memTable.getMemMap());
        ssTables.add(ssTable);
    }

    public Tuple[] selectAll() throws Exception {
        List<Tuple> allTuples = new ArrayList<>();

        for (LSMSSTable ssTable : this.ssTables) {
            allTuples.addAll(ssTable.selectAll());
        } 

        return allTuples.toArray(new Tuple[0]);
    } 
}
