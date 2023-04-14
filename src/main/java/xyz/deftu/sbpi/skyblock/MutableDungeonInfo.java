package xyz.deftu.sbpi.skyblock;

import org.jetbrains.annotations.NotNull;
import xyz.deftu.sbpi.api.info.DungeonInfo;
import xyz.deftu.sbpi.api.info.DungeonType;

public class MutableDungeonInfo implements DungeonInfo {
    private @NotNull DungeonType type;
    private int floor;

    public MutableDungeonInfo() {
        this.type = DungeonType.UNKNOWN;
        this.floor = 0;
    }

    public @NotNull DungeonInfo makeImmutable() {
        return new ImmutableDungeonInfo(type, floor);
    }

    public @NotNull DungeonType getType() {
        return type;
    }

    public void setType(@NotNull DungeonType type) {
        this.type = type;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
