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
import com.github.cluelessskywatcher.halcyonreimagined.filtering.FilterMap;

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
        
        // First load SSTable data from all SSTables
        Tuple[] resultsFromSSTables = ssTableManager.selectAll();
        
        for (Tuple tuple : resultsFromSSTables) {
            if (!tuple.isTombStone()) {
                map.put(tuple.getTupleKey(), tuple);
            }
        }

        // Then load all data from the memtable since it contains the most recent data
        for (Map.Entry<Long, Tuple> entry: memTable.getMemMap().entrySet()) {
            if (!entry.getValue().isTombStone()) {
                map.put(entry.getKey(), entry.getValue());
            }
        }

        List<Tuple> results = new ArrayList<>(map.values());
        
        return results;
    }

    public List<Tuple> selectByFilter(FilterMap filters) throws Exception {
        Map<Long, Tuple> result = new TreeMap<>();

        // First filter everything from ssTables
        List<Tuple> ssTableResults = ssTableManager.selectByFilter(filters);
        for (Tuple tuple : ssTableResults) {
            result.put(tuple.getTupleKey(), tuple);
        }

        // Now we filter from the memTable. MemTables have all the recent
        // updates and entries, so it should replace the old tuples found
        // from sstables

        List<Tuple> memMapResults = memTable.selectByFilter(filters);
        for (Tuple tuple : memMapResults) {
            result.put(tuple.getTupleKey(), tuple);
        }
        
        return new ArrayList<>(result.values());
    }
}
