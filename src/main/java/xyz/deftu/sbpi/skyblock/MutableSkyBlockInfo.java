package xyz.deftu.sbpi.skyblock;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.deftu.sbpi.api.info.*;

import java.util.Objects;

public class MutableSkyBlockInfo implements SkyBlockInfo {
    private boolean alpha;
    private @NotNull Location location;
    private int bits;
    private int coins;
    private int activeSoupTime;
    private @Nullable MutableSlayerQuestInfo slayerQuest;
    private @Nullable MutableDungeonInfo dungeon;

    public MutableSkyBlockInfo() {
        this.alpha = false;
        this.location = Location.UNKNOWN;
        this.bits = -1;
        this.coins = -1;
        this.activeSoupTime = -1;
        this.slayerQuest = null;
        this.dungeon = null;
    }

    public @NotNull ImmutableSkyBlockInfo makeImmutable() {
        return new ImmutableSkyBlockInfo(
                alpha,
                location,
                bits,
                coins,
                activeSoupTime,
                slayerQuest == null ? null : slayerQuest.makeImmutable(),
                dungeon == null ? null : dungeon.makeImmutable()
        );
    }

    public @NotNull MutableSkyBlockInfo copy() {
        MutableSkyBlockInfo value = new MutableSkyBlockInfo();
        value.setAlpha(alpha);
        value.setLocation(location);
        value.setBits(bits);
        value.setCoins(coins);
        value.setActiveSoupTime(activeSoupTime);
        value.setSlayerQuest(slayerQuest);
        value.setDungeon(dungeon);
        return value;
    }

    public boolean isAlpha() {
        return alpha;
    }

    public void setAlpha(boolean alpha) {
        this.alpha = alpha;
    }

    public @NotNull Location getLocation() {
        return location;
    }

    public void setLocation(@NotNull Location location) {
        this.location = location;
    }

    public int getBits() {
        return bits;
    }

    public void setBits(int bits) {
        this.bits = bits;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getActiveSoupTime() {
        return activeSoupTime;
    }

    public void setActiveSoupTime(int activeSoupTime) {
        this.activeSoupTime = activeSoupTime;
    }

    public @Nullable MutableSlayerQuestInfo getSlayerQuest() {
        return slayerQuest;
    }

    public void setSlayerQuest(@Nullable MutableSlayerQuestInfo slayerQuest) {
        this.slayerQuest = slayerQuest;
    }

    public @Nullable MutableDungeonInfo getDungeon() {
        return dungeon;
    }

    public void setDungeon(@Nullable MutableDungeonInfo dungeon) {
        this.dungeon = dungeon;
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
