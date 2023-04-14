package xyz.deftu.sbpi.skyblock;

import org.jetbrains.annotations.NotNull;
import xyz.deftu.sbpi.api.info.DungeonInfo;
import xyz.deftu.sbpi.api.info.DungeonType;

public class ImmutableDungeonInfo implements DungeonInfo {
    private final @NotNull DungeonType type;
    private final int floor;

    public ImmutableDungeonInfo(@NotNull DungeonType type, int floor) {
        this.type = type;
        this.floor = floor;
    }

    public @NotNull DungeonType getType() {
        return type;
    }

    public int getFloor() {
        return floor;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName()).append("(");
        builder.append("type=").append(type);
        builder.append(")");
        return builder.toString();
    }
}
