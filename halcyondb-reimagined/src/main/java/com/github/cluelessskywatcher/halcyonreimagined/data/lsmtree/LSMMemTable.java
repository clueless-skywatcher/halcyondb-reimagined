package com.github.cluelessskywatcher.halcyonreimagined.data.lsmtree;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;

public class LSMMemTable {
    private Map<Long, Tuple> memMap;

    public LSMMemTable() {
        memMap = new TreeMap<>();
    }

    public int size() {
        return memMap.size();
    }

    public void deserialize(DataOutputStream dos) throws IOException {
        for (Long key : memMap.keySet()) {
            dos.writeLong(key);
            memMap.get(key).serialize(dos);
        }
    }

    public void insert(Tuple tuple) {
        memMap.put(tuple.getTupleKey(), tuple);
    }
}
