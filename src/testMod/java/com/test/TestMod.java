package com.test;

import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(
    modid = "test-mod",
    name = "Test Mod",
    version = "1.0.0",
    clientSideOnly = true,
    acceptedMinecraftVersions = "[1.8.9]"
) public class TestMod {

    @Mod.EventHandler
    public void initialize(FMLInitializationEvent event) {
        CommandManager.register(new TestCommand());
    }

}
