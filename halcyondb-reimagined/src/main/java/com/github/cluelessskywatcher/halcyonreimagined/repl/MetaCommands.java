package com.github.cluelessskywatcher.halcyonreimagined.repl;

import com.github.cluelessskywatcher.halcyonreimagined.InputBuffer;

public class MetaCommands {
    public static MetaCommandResult performCommand(InputBuffer buffer) {
        if (buffer.getBuffer().equals(".exit")) {
            System.exit(0);
            return MetaCommandResult.META_COMMAND_SUCCESS;
        }
        else {
            return MetaCommandResult.META_COMMAND_UNRECOGNIZED;
        }
    }
}
