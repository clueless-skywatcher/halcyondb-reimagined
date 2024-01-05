package com.github.cluelessskywatcher.halcyonreimagined.data;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import com.github.cluelessskywatcher.halcyonreimagined.HalcyonDBInstance;
import lombok.Getter;
import lombok.Setter;

public class DataTable {
    private Page[] pages;
    private @Getter String tableName;
    private @Getter TupleMetadata metadata;
    private @Getter File file;
    private @Getter @Setter int rowCount;
    private @Getter long lastRowSequenceId;
    
    public DataTable(String tableName) throws Exception {
        this.pages = new Page[DataConstants.MAX_PAGES_IN_TABLE];
        this.tableName = tableName;
        this.metadata = HalcyonDBInstance.getCatalog().getTableMetadata(tableName);
        this.file = new File(String.format("/tmp/halcyon/data/%s.dat", tableName));
        if (!this.file.exists()) {
            this.file.getParentFile().mkdirs();
            this.file.createNewFile();
        }
        reevaluateRowCount();
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
        reevaluateRowCount();
    }

    public void reevaluateRowCount() throws Exception {
        int rc = 0;

        for (int i = 0; i < DataConstants.MAX_PAGES_IN_TABLE; i++) {
            Page page = Page.readFromDisk(file, metadata, i * DataConstants.PAGE_SIZE);
            rc += page.getPageRowCount();
        }

        this.rowCount = rc;
    }

    public void insert(Tuple tuple) throws Exception {
        DataCursor cursor = endCursor();
        int pageNum = cursor.getRowNum() / getMaxRowsPerPage();
        
        if (pages[pageNum] == null) {
            pages[pageNum] = Page.readFromDisk(file, metadata, pageNum * DataConstants.PAGE_SIZE);
        }

        int rowOffset = cursor.getRowNum() % getMaxRowsPerPage();
        pages[pageNum].insertAt(tuple, rowOffset * metadata.getTotalSize());

        flushToDisk(pages[pageNum], file, pageNum * DataConstants.PAGE_SIZE);
        rowCount++;
    }

    private void flushToDisk(Page page, File file, int offset) throws Exception {
        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        raf.seek(offset);
        raf.write(page.getHeader());
        raf.write(page.getContent());
        raf.close();
    }

    public List<Tuple> selectAll() throws Exception {
        DataCursor cursor = startCursor();
        
        List<Tuple> results = new ArrayList<>();

        while (!cursor.isEndOfTable()) {
            results.add(getRowFromCursor(cursor));
            cursor = nextCursor(cursor);
        }

        return results;
    }

    public int hashCode() {
        return this.tableName.hashCode();
    }

    public int getMaxRowsPerPage() {
        return (DataConstants.PAGE_SIZE * 8) / (metadata.getTotalSize() * 8 + 1);
    }

    public Tuple getRowFromCursor(DataCursor cursor) throws Exception {
        int pageNum = cursor.getRowNum() / getMaxRowsPerPage();
        if (pages[pageNum] == null) {
            pages[pageNum] = Page.readFromDisk(file, metadata, pageNum * DataConstants.PAGE_SIZE);
        }
        return pages[pageNum].deserialize(cursor.getRowNum() % getMaxRowsPerPage());
    }

    public void insertFromCursor(DataCursor cursor, Tuple tuple) throws Exception {
        int pageNum = cursor.getRowNum() / getMaxRowsPerPage();
        if (pages[pageNum] == null) {
            pages[pageNum] = Page.readFromDisk(file, metadata, pageNum * DataConstants.PAGE_SIZE);
        }
        int rowOffset = cursor.getRowNum() % getMaxRowsPerPage();

        if (!pages[pageNum].hasValue(rowOffset)) {
            pages[pageNum].insertAt(tuple, rowOffset * metadata.getTotalSize());
        }
        else {
            throw new Exception(String.format("Cannot insert to row %d. Aborting...", cursor.getRowNum()));
        }
    }

    public DataCursor nextCursor(DataCursor cursor) {
        DataCursor resultCursor = new DataCursor(this, cursor.getRowNum() + 1, false);
        if (resultCursor.getRowNum() == getRowCount()) {
            resultCursor.setEndOfTable(true);
        }
        return resultCursor;
    }

    public DataCursor startCursor() {
        DataCursor cursor = new DataCursor(this, 0, rowCount == 0);
        return cursor;
    }

    public DataCursor endCursor() {
        DataCursor cursor = new DataCursor(this, rowCount, true);
        return cursor;
    }
}
