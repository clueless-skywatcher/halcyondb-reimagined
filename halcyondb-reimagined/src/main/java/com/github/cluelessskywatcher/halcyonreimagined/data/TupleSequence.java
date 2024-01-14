package com.github.cluelessskywatcher.halcyonreimagined.data;

public class TupleSequence {
    private long keyCounter;
    
    public TupleSequence(long initialValue) {
        this.keyCounter = initialValue;
    }

    public long getNextInSequence() {
        long result = Long.valueOf(this.keyCounter);
        this.keyCounter++;
        return result;
    }

    public long getCurrent() {
        return Long.valueOf(this.keyCounter);
    }
}
