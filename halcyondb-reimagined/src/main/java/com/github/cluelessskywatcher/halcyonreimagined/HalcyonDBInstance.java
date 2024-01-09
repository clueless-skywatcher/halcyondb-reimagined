package com.github.cluelessskywatcher.halcyonreimagined;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.stream.Stream;

import com.github.cluelessskywatcher.halcyonreimagined.data.FileDirectoryConstants;
import com.github.cluelessskywatcher.halcyonreimagined.data.TupleSequence;

public class HalcyonDBInstance {
    private static HalcyonDBInstance instance = new HalcyonDBInstance();

    public static final String BASE_DIRECTORY = ".halcs";

    private SchemaCatalog catalog;
    private TupleSequence globalTupleSequence;

    private HalcyonDBInstance() {
        catalog = new SchemaCatalog();
        globalTupleSequence = new TupleSequence(0);
    }

    public static SchemaCatalog getCatalog() {
        return instance.catalog;
    }

    public static long getNextId() {
        return instance.globalTupleSequence.getNextInSequence();
    }

    public static void factoryReset() throws Exception {
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

    private static void clearAllFiles() throws Exception {
        File dir = new File(FileDirectoryConstants.BASE_DIR);
        if (dir.exists()) {
            try (Stream<Path> pathStream = Files.walk(dir.toPath())) {
                pathStream.sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
            }
        }       
    }
}
