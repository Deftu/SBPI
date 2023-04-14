package xyz.deftu.sbpi.skyblock;

import org.jetbrains.annotations.NotNull;
import xyz.deftu.sbpi.api.info.SlayerQuestInfo;

public class MutableSlayerQuestInfo implements SlayerQuestInfo {
    public @NotNull SlayerQuestInfo makeImmutable() {
        return new ImmutableSlayerQuestInfo();
    }
}
