package xyz.deftu.sbpi.skyblock;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.deftu.sbpi.HypixelSkyBlockAPIImpl;
import xyz.deftu.sbpi.api.events.SkyBlockInfoUpdateEvent;
import xyz.deftu.sbpi.api.info.SkyBlockInfo;

import java.text.NumberFormat;
import java.util.Locale;

public class SkyBlockInfoTracker {
    static final NumberFormat NUMBER_FORMAT = NumberFormat.getInstance(Locale.US);

    private MutableSkyBlockInfo currentInfo;
    private int tickCounter = 0;

    private final ScoreboardParser scoreboardParser = new ScoreboardParser();

    public void initialize() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    private boolean isAllowedTick() {
        int pollingRate = HypixelSkyBlockAPIImpl.getConfig().getSkyBlockInfoPollingRate();
        if (pollingRate == 0) return true;

        return tickCounter++ % pollingRate != 0;
    }

    @SubscribeEvent
    public void onWorldLoad(WorldEvent.Load event) {
        currentInfo = null;
        MinecraftForge.EVENT_BUS.post(new SkyBlockInfoUpdateEvent(null));
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.START || !isAllowedTick()) return;
        tickCounter = 0;

        Minecraft client = Minecraft.getMinecraft();
        if (
            client.theWorld == null ||
            client.isSingleplayer() ||
            !HypixelSkyBlockAPIImpl.isOnSkyBlock()
        ) {
            MinecraftForge.EVENT_BUS.post(new SkyBlockInfoUpdateEvent(null));
            currentInfo = null;
            return;
        }

        SkyBlockInfo previousInfo = currentInfo;
        if (currentInfo == null) currentInfo = new MutableSkyBlockInfo();
        scoreboardParser.parse(currentInfo);
//        parseActionBar();
//        parsePlayerList();
        if (currentInfo != null && !currentInfo.equals(previousInfo)) {
            MinecraftForge.EVENT_BUS.post(new SkyBlockInfoUpdateEvent(currentInfo.makeImmutable()));
        }
    }

    private void parseActionBar() {
        // TODO
    }

    private void parsePlayerList() {
        // TODO
    }
}
