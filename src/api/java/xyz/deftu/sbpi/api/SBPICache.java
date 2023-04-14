package xyz.deftu.sbpi.api;

import java.util.Iterator;
import java.util.ServiceLoader;

class SBPICache {
    private static HypixelSkyBlockAPI INSTANCE;

    static HypixelSkyBlockAPI getOrCacheInstance() {
        if (INSTANCE != null) return INSTANCE;

        ServiceLoader<HypixelSkyBlockAPI> loader = ServiceLoader.load(HypixelSkyBlockAPI.class);
        Iterator<HypixelSkyBlockAPI> iterator = loader.iterator();
        if (!iterator.hasNext()) throw new IllegalStateException("No implementation of HypixelSkyBlockAPI found!");

        return INSTANCE = iterator.next();
    }
}
