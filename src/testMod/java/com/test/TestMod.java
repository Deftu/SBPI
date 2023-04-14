package com.test;

import cc.polyfrost.oneconfig.utils.commands.CommandManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xyz.deftu.sbpi.api.events.SkyBlockInfoUpdateEvent;

@Mod(
    modid = "test-mod",
    name = "Test Mod",
    version = "1.0.0",
    clientSideOnly = true,
    acceptedMinecraftVersions = "[1.8.9]"
) public class TestMod {
    public static final Logger LOGGER = LogManager.getLogger();

    @Mod.EventHandler
    public void initialize(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        CommandManager.register(new TestCommand());
    }

    @SubscribeEvent
    public void onSkyBlockInfoUpdate(SkyBlockInfoUpdateEvent event) {
        if (event.updatedInfo != null) {
            LOGGER.info("SkyBlock Info has been updated: " + event.updatedInfo);
        }
    }

}
