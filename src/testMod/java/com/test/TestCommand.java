package com.test;

import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import xyz.deftu.sbpi.api.HypixelSkyBlockAPI;

@Command("testcommand")
public class TestCommand {

    @Main
    private void handler() {
        TestMod.LOGGER.info("SkyBlockInfo: " + HypixelSkyBlockAPI.getInstance().getCurrentSkyBlockInfo());
    }

}
