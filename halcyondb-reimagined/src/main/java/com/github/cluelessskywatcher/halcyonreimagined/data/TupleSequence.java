package com.github.cluelessskywatcher.halcyonreimagined.data;

import java.util.concurrent.atomic.AtomicLong;

public class TupleSequence {
    private AtomicLong keyCounter;
    
    public TupleSequence(long initialValue) {
        this.keyCounter = new AtomicLong(initialValue);
    }

    public long getNextInSequence() {
        return this.keyCounter.getAndIncrement();
    }
}
