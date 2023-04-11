package xyz.deftu.hbsp;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
    modid = HypixelSkyBlockAPI.ID,
    name = HypixelSkyBlockAPI.NAME,
    version = HypixelSkyBlockAPI.VERSION,
    clientSideOnly = true,
    acceptedMinecraftVersions = "[1.8.9]"
) public class HypixelSkyBlockAPI {
    public static final String NAME = "@MOD_NAME@";
    public static final String ID = "@MOD_ID@";
    public static final String VERSION = "@MOD_VERSION@";
    private static final Logger LOGGER = LogManager.getLogger(NAME);

    @Mod.Instance(ID) private static HypixelSkyBlockAPI instance;
    private static HypixelSkyBlockConfig config;

    @Mod.EventHandler
    public void initialize(FMLInitializationEvent event) {
        config = new HypixelSkyBlockConfig();
        config.initialize();

        LOGGER.info("Hypixel SkyBlock API has been initialized!");
    }

    public static HypixelSkyBlockAPI getInstance() {
        return instance;
    }

    public static HypixelSkyBlockConfig getConfig() {
        return config;
    }
}
