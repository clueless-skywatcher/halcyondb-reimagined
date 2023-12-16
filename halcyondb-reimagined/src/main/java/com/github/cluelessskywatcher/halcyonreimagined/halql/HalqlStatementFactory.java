package com.github.cluelessskywatcher.halcyonreimagined.halql;

import com.github.cluelessskywatcher.halcyonreimagined.halql.dml.InsertRowStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.dql.SelectTableStatement;
import com.github.cluelessskywatcher.halcyonreimagined.repl.PrepareResult;
import com.github.cluelessskywatcher.halcyonreimagined.repl.ReplInputBuffer;

import lombok.Getter;

@Getter
public class HalqlStatementFactory {
    private HalqlStatement preparedStatement;

    public HalqlStatementFactory() {
        this.preparedStatement = null;
    }

    public PrepareResult prepareStatementFromBuffer(ReplInputBuffer buffer) {
        String bufferContent = buffer.getBuffer();
        
        if (bufferContent.startsWith("insert")) {
            this.preparedStatement = new InsertRowStatement(bufferContent);
            return PrepareResult.PREPARE_SUCCESS;
        }
        if (bufferContent.startsWith("select")) {
            this.preparedStatement = new SelectTableStatement(bufferContent);
            return PrepareResult.PREPARE_SUCCESS;
        }
        
        return PrepareResult.PREPARE_UNRECOGNIZED;
    }
}
