package xyz.deftu.sbpi.api.info;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SkyBlockInfo {
    boolean isAlpha();

    @NotNull Location getLocation();

    default boolean hasLocation() {
        return getLocation() != Location.UNKNOWN;
    }

    default boolean isGuesting() {
        return getLocation() == Location.GUEST_ISLAND;
    }

    int getBits();

    int getCoins();

    int getActiveSoupTime();

    default boolean isSoupActive() {
        return getActiveSoupTime() > 0;
    }

    @Nullable SlayerQuestInfo getSlayerQuest();

    default boolean isDoingSlayerQuest() {
        return getSlayerQuest() != null;
    }

    @Nullable DungeonInfo getDungeon();

    default boolean isInDungeon() {
        return getDungeon() != null;
    }
}
