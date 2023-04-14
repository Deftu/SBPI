package xyz.deftu.sbpi.skyblock;

import org.jetbrains.annotations.NotNull;
import xyz.deftu.sbpi.api.info.*;

import java.util.Objects;

public class ImmutableSkyBlockInfo implements SkyBlockInfo {
    private final boolean alpha;
    private final Location location;
    private final int bits;
    private final int coins;
    private final int activeSoupTime;
    private final SlayerQuestInfo slayerQuest;
    private final DungeonInfo dungeon;

    public ImmutableSkyBlockInfo(boolean alpha, Location location, int bits, int coins, int activeSoupTime, SlayerQuestInfo slayerQuest, DungeonInfo dungeon) {
        this.alpha = alpha;
        this.location = location;
        this.bits = bits;
        this.coins = coins;
        this.activeSoupTime = activeSoupTime;
        this.slayerQuest = slayerQuest;
        this.dungeon = dungeon;
    }

    public @NotNull ImmutableSkyBlockInfo copy() {
        return new ImmutableSkyBlockInfo(alpha, location, bits, coins, activeSoupTime, slayerQuest, dungeon);
    }

    public @NotNull ImmutableSkyBlockInfo makeImmutable() {
        return this;
    }

    public boolean isAlpha() {
        return alpha;
    }

    public @NotNull Location getLocation() {
        return location;
    }

    public int getBits() {
        return bits;
    }

    public int getCoins() {
        return coins;
    }

    public int getActiveSoupTime() {
        return activeSoupTime;
    }

    public boolean isSoupActive() {
        return activeSoupTime > 0;
    }

    public SlayerQuestInfo getSlayerQuest() {
        return slayerQuest;
    }

    public DungeonInfo getDungeon() {
        return dungeon;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName()).append("(");
        builder.append("alpha=").append(alpha);
        builder.append(", location=").append(location);
        builder.append(", bits=").append(bits);
        builder.append(", coins=").append(coins);
        builder.append(", activeSoupTime=").append(activeSoupTime);
        builder.append(", slayerQuest=").append(slayerQuest);
        builder.append(", dungeon=").append(dungeon);
        builder.append(")");
        return builder.toString();
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof xyz.deftu.sbpi.api.info.SkyBlockInfo)) return false;

        SkyBlockInfo other = (SkyBlockInfo) o;
        return alpha == other.isAlpha() &&
            location == other.getLocation() &&
            bits == other.getBits() &&
            coins == other.getCoins() &&
            activeSoupTime == other.getActiveSoupTime() &&
            Objects.equals(slayerQuest, other.getSlayerQuest()) &&
            Objects.equals(dungeon, other.getDungeon());
    }

    public int hashCode() {
        return Objects.hash(alpha, location, bits, coins, activeSoupTime, slayerQuest, dungeon);
    }
}
