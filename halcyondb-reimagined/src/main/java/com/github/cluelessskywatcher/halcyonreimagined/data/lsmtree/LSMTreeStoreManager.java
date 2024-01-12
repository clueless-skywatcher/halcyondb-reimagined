package com.github.cluelessskywatcher.halcyonreimagined.data.lsmtree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataConstants;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataStoreManager;
import com.github.cluelessskywatcher.halcyonreimagined.data.DataTable;
import com.github.cluelessskywatcher.halcyonreimagined.data.Tuple;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleMetadata;

import lombok.Getter;

public class LSMTreeStoreManager implements DataStoreManager {
    private LSMMemTable memTable;
    private LSMCommitLog commitLog;
    private LSMSSTableManager ssTableManager;
    private @Getter TupleMetadata metadata;
    private @Getter DataTable table;
    
    public LSMTreeStoreManager(DataTable table) throws Exception {
        this.table = table;
        metadata = table.getMetadata();
        memTable = new LSMMemTable(table.getTableName(), metadata);
        commitLog = new LSMCommitLog(table.getTableName(), metadata);
        ssTableManager = new LSMSSTableManager(table.getTableName(), metadata);
        commitLog.loadToMemTableIfNotEmpty(memTable);
    }

    public void insert(Tuple tuple) throws Exception {
        commitLog.append(tuple, LSMOperation.WRITE);
        memTable.insert(tuple);
        if (memTable.size() >= DataConstants.MAX_MEM_TABLE_SIZE) {
            ssTableManager.flush(memTable);
            memTable.reset();
            commitLog.reset();
        }
    }

    public List<Tuple> selectAll() throws Exception {
        Map<Long, Tuple> map = new TreeMap<>();
        
        // First load all SSTable data from all SSTables
        Tuple[] resultsFromSSTables = ssTableManager.selectAll();
        
        for (Tuple tuple : resultsFromSSTables) {
            map.put(tuple.getTupleKey(), tuple);
        }

        // Then load all data from the memtable
        for (Map.Entry<Long, Tuple> entry: memTable.getMemMap().entrySet()) {
            map.put(entry.getKey(), entry.getValue());
        }

        List<Tuple> results = new ArrayList<>(map.values());
        
        return results;
    }
}
