package com.github.cluelessskywatcher.halcyonreimagined.halql;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.github.cluelessskywatcher.halcyonreimagined.InputBuffer;
import com.github.cluelessskywatcher.halcyonreimagined.halql.dml.InsertRowStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.dql.SelectTableStatement;
import com.github.cluelessskywatcher.halcyonreimagined.repl.PrepareResult;

import lombok.Getter;

@Getter
public class HalqlStatementFactory {
    private HalqlStatement preparedStatement;
    private HalqlParserEngine engine;

    public HalqlStatementFactory() {
        this.preparedStatement = null;
        this.engine = new HalqlParserEngine();
    }

    public PrepareResult prepareStatementFromBuffer(InputBuffer buffer) throws Exception {
        String bufferContent = buffer.getBuffer();
        
        // if (bufferContent.startsWith("insert")) {
        //     Pattern insertPattern = Pattern.compile("insert into (\\w+) values \\(([^()]*)\\);");
        //     Matcher matcher = insertPattern.matcher(bufferContent);
        //     if (matcher.matches()) {
        //         this.preparedStatement = new InsertRowStatement(bufferContent);
        //         return PrepareResult.PREPARE_SUCCESS;
        //     }
        //     else {
        //         return PrepareResult.PREPARE_SYNTAX_ERROR;
        //     }
        // }
        // else if (bufferContent.startsWith("select")) {
        //     Pattern selectPattern = Pattern.compile("select \\* from (\\w+);");
        //     Matcher matcher = selectPattern.matcher(bufferContent);
        //     if (matcher.matches()) {
        //         this.preparedStatement = new SelectTableStatement(bufferContent);
        //         return PrepareResult.PREPARE_SUCCESS;
        //     }
        //     else {
        //         return PrepareResult.PREPARE_SYNTAX_ERROR;
        //     }
        // }
        
        return PrepareResult.PREPARE_UNRECOGNIZED;
    }
}
