package com.github.cluelessskywatcher.halcyonreimagined.repl;

import java.util.Scanner;

import com.github.cluelessskywatcher.halcyonreimagined.InputBuffer;

public class ReplInputBuffer implements InputBuffer {
    private String buffer;
    private Scanner scanner;

    public ReplInputBuffer() {
        buffer = null;
        scanner = new Scanner(System.in);
    }

    public String getBuffer() {
        return buffer;
    }

    public void setBuffer(String buffer) {
        this.buffer = buffer;
    }

    public void readInput() {
        String line = scanner.nextLine();
        setBuffer(line);
    }
}
