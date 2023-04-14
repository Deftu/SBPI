package xyz.deftu.sbpi.api.events;

import net.minecraftforge.fml.common.eventhandler.Event;
import org.jetbrains.annotations.Nullable;
import xyz.deftu.sbpi.api.info.SkyBlockInfo;

public class SkyBlockInfoUpdateEvent extends Event {
    public final @Nullable SkyBlockInfo updatedInfo;

    public SkyBlockInfoUpdateEvent(@Nullable SkyBlockInfo updatedInfo) {
        this.updatedInfo = updatedInfo;
    }
}
