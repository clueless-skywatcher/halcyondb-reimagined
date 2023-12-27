package com.github.cluelessskywatcher.halcyonreimagined;

import com.github.cluelessskywatcher.halcyonreimagined.halql.HalqlParserEngine;
import com.github.cluelessskywatcher.halcyonreimagined.halql.HalqlStatement;
import com.github.cluelessskywatcher.halcyonreimagined.repl.MetaCommands;
import com.github.cluelessskywatcher.halcyonreimagined.repl.ReplInputBuffer;

public class HalcsRepl {
    public static void main(String[] args) throws Exception {
        ReplInputBuffer buffer = new ReplInputBuffer();
        while (true) {
            System.out.print("db >> ");
            buffer.readInput();
            if (buffer.getBuffer().startsWith(".")) {
                switch (MetaCommands.performCommand(buffer)) {
                    case META_COMMAND_SUCCESS:
                        continue;
                    case META_COMMAND_UNRECOGNIZED:
                        System.err.printf("Unrecognized command: '%s'\n", buffer.getBuffer());
                        continue;
                }
            }

            HalqlStatement stmt = HalqlParserEngine.parseQuery(buffer);
            try {
                stmt.execute();
                stmt.getResult().showResult();
            } 
            catch (Exception e) {
                stmt.getResult().showResult();
            }
        }
    }
}
