package xyz.deftu.hbsp.items;

import java.util.regex.Pattern;

public enum ItemRarity {
    COMMON,
    UNCOMMON,
    RARE,
    EPIC,
    LEGENDARY,
    MYTHIC,
    DIVINE,
    SPECIAL,
    VERY_SPECIAL;

    public static ItemRarity from(String string) {
        for (ItemRarity rarity : values()) {
            if (rarity.name().equalsIgnoreCase(string)) return rarity;
        }

        return null;
    }

    public static Pattern createRarityPattern() {
        // Creates a dynamic regex that matches any rarity and then the item type after it (e.g. "RARE ACCESSOR", "EPIC SWORD")
        StringBuilder builder = new StringBuilder();
        builder.append("(");
        for (ItemRarity rarity : values()) builder.append(rarity.name()).append("|");

        // Remove the last pipe
        builder.deleteCharAt(builder.length() - 1);
        builder.append(")");

        // Add the item type after it, this may not exist (e.g. "RARE" or "EPIC SWORD")
        builder.append(" ?(.*)");

        return Pattern.compile(builder.toString());
    }
}
