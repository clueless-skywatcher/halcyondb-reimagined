package com.github.cluelessskywatcher.halcyonreimagined;

public class HalcyonDBInstance {
    private static HalcyonDBInstance instance = new HalcyonDBInstance();
    
    private SchemaCatalog catalog;

    private HalcyonDBInstance() {
        catalog = new SchemaCatalog();
    }

    public static SchemaCatalog getCatalog() {
        return instance.catalog;
    }

    public static void reset() {
        instance = new HalcyonDBInstance();
    }
}
