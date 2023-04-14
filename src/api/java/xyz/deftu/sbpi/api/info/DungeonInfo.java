package xyz.deftu.sbpi.api.info;

import org.jetbrains.annotations.NotNull;

public interface DungeonInfo {
    @NotNull DungeonType getType();
    int getFloor();
}
