package xyz.deftu.sbpi.items

import net.minecraft.item.ItemStack

fun ItemStack.toSkyBlock() = SkyBlockItemStack(this)
