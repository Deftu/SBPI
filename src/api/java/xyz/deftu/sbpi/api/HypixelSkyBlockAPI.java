package xyz.deftu.sbpi.api;

import xyz.deftu.sbpi.api.info.SkyBlockInfo;
import xyz.deftu.sbpi.api.scoreboard.ScoreboardInfo;

public interface HypixelSkyBlockAPI {
    ScoreboardInfo getCurrentScoreboardInfo();
    SkyBlockInfo getCurrentSkyBlockInfo();

    static HypixelSkyBlockAPI getInstance() {
        return SBPICache.getOrCacheInstance();
    }
}
