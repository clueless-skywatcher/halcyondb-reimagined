package com.github.cluelessskywatcher.halcyonreimagined.data;

import java.util.ArrayList;
import java.util.List;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import lombok.Getter;

public class DataTable {
    private Page[] pages;
    private @Getter String tableName;
    private @Getter TupleMetadata metadata;
    private @Getter int rowCount;
    
    public DataTable(String tableName) {
        this.pages = new Page[DataConstants.MAX_PAGES_IN_TABLE];
        this.tableName = tableName;
        this.metadata = HalcyonDBInstance.getCatalog().getTableMetadata(tableName);
        this.rowCount = 0;
    }

    public DataTable(String tableName, TupleMetadata metadata) {
        this.pages = new Page[DataConstants.MAX_PAGES_IN_TABLE];
        this.tableName = tableName;
        this.metadata = metadata;
        this.rowCount = 0;
    }

    public void insert(Tuple tuple) throws Exception {
        // Find the first page which has empty slots or is null
        // If page is null, make one, then we prepare to add
        // data in that page (because a newly created page will)
        // always have empty slots. In this way, it will always
        // append new data
        int i = 0;
        while (i < pages.length) {
            if (pages[i] == null) {
                break;
            }
            else if (pages[i].getNumEmptySlots() > 0) {
                break;
            }
            i++;
        }
        
        if (i >= pages.length) {
            throw new Exception("Table is full. Cannot add more tuples");
        }

        if (pages[i] == null) {
            Page page = new Page(metadata);
            page.insert(tuple);
            pages[i] = page;
        }
        else {
            pages[i].insert(tuple);
        }
        rowCount++;
    }

    public List<Tuple> selectAll() throws Exception {
        List<Tuple> results = new ArrayList<>();
        int pageIdx = 0;
        while (pageIdx < pages.length) {
            if (results.size() == getRowCount()) {
                break;
            }
            Page page = pages[pageIdx];
            if (page != null) {
                for (int i = 0; i < page.getMaxRows(); i++) {
                    if (page.hasValue(i)) {
                        results.add(page.deserialize(i));
                    }
                }
            } 
            pageIdx++;
        }
        return results;
    }

    public int hashCode() {
        return this.tableName.hashCode();
    }
}
