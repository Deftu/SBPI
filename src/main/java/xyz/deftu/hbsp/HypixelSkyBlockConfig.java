package xyz.deftu.hbsp;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.HypixelKey;
import cc.polyfrost.oneconfig.config.annotations.Text;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class HypixelSkyBlockConfig extends Config {
    @HypixelKey
    @Text(name = "API Key", description = "Your Hypixel API key. This is used for some API features.")
    public String apiKey = "";

    public HypixelSkyBlockConfig() {
        super(new Mod(HypixelSkyBlockAPI.NAME, ModType.HYPIXEL), HypixelSkyBlockAPI.ID + ".json");
    }
}
