package com.github.cluelessskywatcher.halcyonreimagined.utils;

import com.github.cluelessskywatcher.halcyonreimagined.InputBuffer;

public class TestingBuffer implements InputBuffer {
    private String buffer;

    @Override
    public String getBuffer() {
        return buffer;
    }

    @Override
    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }
}
