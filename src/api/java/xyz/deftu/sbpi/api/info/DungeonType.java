package xyz.deftu.sbpi.api.info;

import org.jetbrains.annotations.NotNull;

public enum DungeonType {
    THE_CATACOMBS(Location.THE_CATACOMBS),

    UNKNOWN(Location.UNKNOWN)
    ;

    private final @NotNull Location location;

    DungeonType(@NotNull Location location) {
        this.location = location;
    }

    public @NotNull Location getLocation() {
        return location;
    }

    public static DungeonType fromLocation(Location location) {
        for (DungeonType value : values()) {
            if (value.getLocation() == location) {
                return value;
            }
        }

        return null;
    }
}
