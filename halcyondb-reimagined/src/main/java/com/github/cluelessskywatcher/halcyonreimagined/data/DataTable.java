package com.github.cluelessskywatcher.halcyonreimagined.data;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import lombok.Getter;

public class DataTable {
    private Page[] pages;
    private @Getter String tableName;
    private @Getter TupleMetadata metadata;
    private @Getter File file;
    
    public DataTable(String tableName) throws Exception {
        this.pages = new Page[DataConstants.MAX_PAGES_IN_TABLE];
        this.tableName = tableName;
        this.metadata = HalcyonDBInstance.getCatalog().getTableMetadata(tableName);
        this.file = new File(String.format("/tmp/halcyon/data/%s.dat", tableName));
        if (!this.file.exists()) {
            this.file.getParentFile().mkdirs();
            this.file.createNewFile();
        }
    }

    public DataTable(String tableName, TupleMetadata metadata) throws Exception {
        this.pages = new Page[DataConstants.MAX_PAGES_IN_TABLE];
        this.tableName = tableName;
        this.metadata = metadata;
        this.file = new File(String.format("/tmp/halcyon/data/%s.dat", tableName));
        if (!this.file.exists()) {
            this.file.getParentFile().mkdirs();
            this.file.createNewFile();
        }
    }

    public void insert(Tuple tuple) throws Exception {
        int i = 0;

        // Iterate over the page list until we get a 
        // null page or a page with empty rows
        while (i < pages.length) {
            if (pages[i] == null || pages[i].getNumEmptySlots() > 0) break;
            i++;
        }

        if (pages[i] == null) {
            // If page is null, we read that page from disk, then insert the tuple
            // in that page. Disk flushes are yet to occur.
            pages[i] = Page.readFromDisk(file, metadata, i * DataConstants.PAGE_SIZE);
            pages[i].insert(tuple);
        }
        else {
            // Otherwise we check if the page has any empty slots to insert a row.
            // If yes, we insert it. If no, throw an exception since i is supposed to
            // denote the page which should have an empty slot
            if (pages[i].getNumEmptySlots() > 0) {
                pages[i].insert(tuple);
            }
            else {
                throw new Exception(String.format("Table %s is full", tableName));
            }
        }
        // We are flushing the page to disk for every insert.
        // TODO: Think of a better approach (maybe a transactional approach)
        // when saving data
        flushToDisk(pages[i], file, i * DataConstants.PAGE_SIZE);
    }

    private void flushToDisk(Page page, File file, int offset) throws Exception {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(offset);
        raf.write(page.getHeader());
        raf.write(page.getContent());
        raf.close();
    }

    public List<Tuple> selectAll() throws Exception {
        // Since we need to select all rows, we need to populate
        // the page list
        List<Tuple> results = new ArrayList<>();

        for (int i = 0; i < pages.length; i++) {
            pages[i] = Page.readFromDisk(file, metadata, i * DataConstants.PAGE_SIZE);
        }

        for (int i = 0; i < pages.length; i++) {
            Page page = pages[i];
            for (int j = 0; j < page.getMaxRows(); j++) {
                if (page.hasValue(j)) {
                    results.add(page.deserialize(j));
                }
            }
        }

        return results;
    }

    public int hashCode() {
        return this.tableName.hashCode();
    }
}
