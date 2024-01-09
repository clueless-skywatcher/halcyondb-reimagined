package com.github.cluelessskywatcher.halcyonreimagined.data;

public interface DataStoreManager {
    public void insert(Tuple tuple) throws Exception; 

    // public void update(Long tupleKey, DataField value, String fieldName) throws Exception;

    // public void delete(List<Long> tupleKeys);
}
