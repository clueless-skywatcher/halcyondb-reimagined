package com.github.cluelessskywatcher.halcyonreimagined.data.lsmtree;

import lombok.Getter;

public enum LSMOperation {
    WRITE(1),
    READ(2),
    DELETE(3);

    private @Getter int id;

    private LSMOperation(int id) {
        this.id = id;
    }
};
