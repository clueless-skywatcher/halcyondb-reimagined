package com.github.cluelessskywatcher.halcyonreimagined.halql;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            Pattern insertPattern = Pattern.compile("insert into (\\w+) values \\(([^)]*)\\);");
            Matcher matcher = insertPattern.matcher(bufferContent);
            if (matcher.matches()) {
                this.preparedStatement = new InsertRowStatement(bufferContent);
                return PrepareResult.PREPARE_SUCCESS;
            }
            else {
                return PrepareResult.PREPARE_SYNTAX_ERROR;
            }
        }
        if (bufferContent.startsWith("select")) {
            this.preparedStatement = new SelectTableStatement(bufferContent);
            return PrepareResult.PREPARE_SUCCESS;
        }
        
        return PrepareResult.PREPARE_UNRECOGNIZED;
    }
}
