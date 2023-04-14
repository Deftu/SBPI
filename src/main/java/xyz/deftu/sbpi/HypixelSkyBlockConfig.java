package xyz.deftu.sbpi;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.Dropdown;
import cc.polyfrost.oneconfig.config.annotations.HypixelKey;
import cc.polyfrost.oneconfig.config.annotations.Text;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class HypixelSkyBlockConfig extends Config {
    @HypixelKey
    @Text(name = "API Key", description = "Your Hypixel API key. This is used for some API features.")
    public String apiKey = "";

    @Dropdown(name = "Scoreboard Polling Rate", options = {"Constant", "5", "10", "15", "20"}, description = "The rate at which the scoreboard is polled for updates. Constants is the fastest rate, and 20 is the slowest rate.")
    public int scoreboardPollingRate = 1;

    @Dropdown(name = "SkyBlock Info Polling Rate", options = {"Constant", "5", "10"}, description = "The rate at which the SkyBlock is polled for updates. Constants is the fastest rate, and 10 is the slowest rate. The \"SkyBlock Info\" is things such as the player list, action bar and sidebar. Mods use these to show you useful information about the game.")
    public int skyBlockInfoPollingRate = 0;

    public HypixelSkyBlockConfig() {
        super(new Mod(HypixelSkyBlockAPIImpl.NAME, ModType.HYPIXEL), HypixelSkyBlockAPIImpl.ID + ".json");
    }

    public int getScoreboardPollingRate() {
        return scoreboardPollingRate == 0 ? 0 : 5 * scoreboardPollingRate;
    }

    public int getSkyBlockInfoPollingRate() {
        return skyBlockInfoPollingRate == 0 ? 0 : 5 * skyBlockInfoPollingRate;
    }
}
