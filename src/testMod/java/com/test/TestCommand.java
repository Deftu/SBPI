package com.test;

import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemStack;
import xyz.deftu.hbsp.items.SkyBlockItemStack;

@Command("testcommand")
public class TestCommand {

    @Main
    private void handler() {
        EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
        if (player == null) return;

        ItemStack heldStack = player.getHeldItem();
        if (heldStack == null) return;

        SkyBlockItemStack stack = SkyBlockItemStack.of(heldStack);
        System.out.println("Held item rarity: " + stack.getRarity());
    }

}
