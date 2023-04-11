package xyz.deftu.hbsp.items;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumChatFormatting;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SkyBlockItemStack {
    private static final Pattern RARITY_PATTERN = ItemRarity.createRarityPattern();

    private final @NotNull ItemStack stack;
    private @Nullable ItemRarity rarity;

    public SkyBlockItemStack(@NotNull ItemStack stack) {
        this.stack = stack;
    }

    private @Nullable ItemRarity getOrCalculateRarity() {
        if (rarity != null) return rarity;
        if (!stack.hasTagCompound()) return null;

        NBTTagCompound displayTag = stack.getSubCompound("display", false);
        if (displayTag == null || !displayTag.hasKey("Lore", 9)) return null;

        NBTTagList loreTag = displayTag.getTagList("Lore", 8);
        if (loreTag == null) return null;

        List<String> lore = new ArrayList<>();
        for (int i = 0; i < loreTag.tagCount(); i++)
            lore.add(loreTag.getStringTagAt(i));
        if (lore.isEmpty()) return null;

        String lastLine = lore.get(lore.size() - 1);
        if (lastLine == null) return null;

        for (int i = lore.size() - 1; i >= 0; i--) {
            String line = lore.get(i);
            if (line == null) continue;
            line = EnumChatFormatting.getTextWithoutFormattingCodes(line);

            // check if it matches the rarity pattern
            Matcher matcher = RARITY_PATTERN.matcher(line);
            if (!matcher.matches()) continue;

            // get the rarity from the line
            String rarityName = matcher.group(1);
            ItemRarity rarity = ItemRarity.from(rarityName);
            if (rarity != null) return this.rarity = rarity;
        }

        return null;
    }

    public @NotNull ItemStack getStack() {
        return stack;
    }

    public @Nullable ItemRarity getRarity() {
        return getOrCalculateRarity();
    }

    @Contract(value = "_ -> new", pure = true)
    public static @NotNull SkyBlockItemStack of(ItemStack stack) {
        return new SkyBlockItemStack(stack);
    }
}
