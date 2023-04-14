package xyz.deftu.sbpi;

import com.google.common.collect.Sets;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import xyz.deftu.sbpi.api.HypixelSkyBlockAPI;
import xyz.deftu.sbpi.api.info.SkyBlockInfo;
import xyz.deftu.sbpi.api.scoreboard.ScoreboardInfo;
import xyz.deftu.sbpi.scoreboard.ScoreboardManager;
import xyz.deftu.sbpi.skyblock.SkyBlockInfoTracker;
import xyz.deftu.sbpi.api.events.SkyBlockInfoUpdateEvent;

import java.util.Set;
import java.util.regex.Pattern;

@Mod(
    modid = HypixelSkyBlockAPIImpl.ID,
    name = HypixelSkyBlockAPIImpl.NAME,
    version = HypixelSkyBlockAPIImpl.VERSION,
    clientSideOnly = true,
    acceptedMinecraftVersions = "[1.8.9]"
) public class HypixelSkyBlockAPIImpl implements HypixelSkyBlockAPI {
    public static final String NAME = "@MOD_NAME@";
    public static final String ID = "@MOD_ID@";
    public static final String VERSION = "@MOD_VERSION@";
    private static final Logger LOGGER = LogManager.getLogger(NAME);

    private static final Pattern HYPIXEL_BRAND_PATTERN = Pattern.compile(".*Hypixel BungeeCord.*");
    private static final Set<String> SKYBLOCK_TITLES = Sets.newHashSet("SKYBLOCK", "\u7A7A\u5C9B\u751F\u5B58", "\u7A7A\u5CF6\u751F\u5B58");

    @Mod.Instance(ID) private static HypixelSkyBlockAPIImpl instance;
    private static final @NotNull HypixelSkyBlockConfig config = new HypixelSkyBlockConfig();
    private static final @NotNull ScoreboardManager scoreboardManager = new ScoreboardManager();
    private static @Nullable SkyBlockInfo skyBlockInfo;

    @Mod.EventHandler
    public void initialize(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);

        config.initialize();
        scoreboardManager.initialize();

        SkyBlockInfoTracker tracker = new SkyBlockInfoTracker();
        tracker.initialize();

        LOGGER.info("SkyBlock Programming Interface has been initialized!");
    }

    @SubscribeEvent
    public void onSkyBlockInfoUpdate(SkyBlockInfoUpdateEvent event) {
        skyBlockInfo = event.updatedInfo;
    }

    public static boolean isOnHypixel() {
        Minecraft client = Minecraft.getMinecraft();
        if (client.theWorld == null || client.thePlayer == null || client.isSingleplayer()) return false;

        String clientBrand = client.thePlayer.getClientBrand();
        if (clientBrand == null) return false;

        return HYPIXEL_BRAND_PATTERN.matcher(clientBrand).matches();
    }

    public static boolean isOnSkyBlock() {
        if (!isOnHypixel()) return false;

        ScoreboardInfo scoreboardInfo = getInstance().getCurrentScoreboardInfo();
        if (scoreboardInfo == null) return false;

        return SKYBLOCK_TITLES.contains(scoreboardInfo.getObjectiveNameStripped());
    }

    public static HypixelSkyBlockAPIImpl getInstance() {
        return instance;
    }

    public ScoreboardInfo getCurrentScoreboardInfo() {
        return scoreboardManager.getCurrentInfo();
    }

    public SkyBlockInfo getCurrentSkyBlockInfo() {
        return skyBlockInfo;
    }

    public static @NotNull HypixelSkyBlockConfig getConfig() {
        return config;
    }
}
