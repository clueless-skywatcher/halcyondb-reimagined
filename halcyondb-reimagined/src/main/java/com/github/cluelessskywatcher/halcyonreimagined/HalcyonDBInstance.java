package com.github.cluelessskywatcher.halcyonreimagined;

import java.io.File;

import com.github.cluelessskywatcher.halcyonreimagined.data.TupleSequence;

public class HalcyonDBInstance {
    private static HalcyonDBInstance instance = new HalcyonDBInstance();

    public static final String BASE_DIRECTORY = "";

    private SchemaCatalog catalog;
    private TupleSequence globaTupleSequence;

    private HalcyonDBInstance() {
        catalog = new SchemaCatalog();
        globaTupleSequence = new TupleSequence(0);
    }

    public static SchemaCatalog getCatalog() {
        return instance.catalog;
    }

    public static long getNextId() {
        return instance.globaTupleSequence.getNextInSequence();
    }

    public static void factoryReset() {
        /*
         * Reset the database instance and delete all database files
         */
        clearAllFiles();
        instance = new HalcyonDBInstance();
    }

    public static void softReset() {
        /*
         * Reset the database instance without deleting the database files
         */
        instance = new HalcyonDBInstance();
    }

    private static void clearAllFiles() {
        File dir = new File("/tmp/halcyon/data");
        if (dir.exists()) {
            for (File file: dir.listFiles()) {
                file.delete();
            }
        }            
    }
}
