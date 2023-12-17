package com.github.cluelessskywatcher.halcyonreimagined;

import com.github.cluelessskywatcher.halcyonreimagined.halql.HalqlStatement;
import com.github.cluelessskywatcher.halcyonreimagined.halql.HalqlStatementFactory;
import com.github.cluelessskywatcher.halcyonreimagined.repl.MetaCommands;
import com.github.cluelessskywatcher.halcyonreimagined.repl.ReplInputBuffer;

public class HalcsRepl {
    public static void main(String[] args) {
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

            HalqlStatementFactory factory = new HalqlStatementFactory();

            switch (factory.prepareStatementFromBuffer(buffer)) {
                case PREPARE_SUCCESS:
                    break;
                case PREPARE_UNRECOGNIZED:
                    System.out.printf("Unrecognized statement: '%s'\n", buffer.getBuffer());
                    continue;
                case PREPARE_SYNTAX_ERROR:
                    System.out.println("Syntax error");
                    continue;
            }

            HalqlStatement statement = factory.getPreparedStatement();
            statement.execute();            
        }
    }
}
