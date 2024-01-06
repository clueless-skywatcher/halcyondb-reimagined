package com.github.cluelessskywatcher.halcyonreimagined.data.lsmtree;

import com.github.cluelessskywatcher.halcyonreimagined.data.DataTable;

public class LSMTreeManager {
    private LSMMemTable memTable;
    private LSMCommitLog commitLog;

    public LSMTreeManager() {
        memTable = new LSMMemTable();
        commitLog = new LSMCommitLog();
    }

    public void insert() {
        
    }
}
