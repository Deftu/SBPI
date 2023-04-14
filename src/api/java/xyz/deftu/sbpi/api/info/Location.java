package xyz.deftu.sbpi.api.info;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("unused")
public enum Location {
    ISLAND("Your Island"),
    GUEST_ISLAND("'s Island"),

    // Hub
    AUCTION_HOUSE("Auction House"),
    BANK("Bank"),
    BAZAAR("Bazaar Alley"),
    CANVAS_ROOM("Canvas Room"),
    COAL_MINE("Coal Mine"),
    COLOSSEUM("Colosseum"),
    COLOSSEUM_ARENA("Colosseum Arena"),
    DUEL_ZONE("Duel Zone"),
    ELECTION_ROOM("Election Room"),
    FARM("Farm"),
    FASHION_SHOP("Fashion Shop"),
    FISHERMANS_HUT("Fisherman's Hut"),
    FLOWER_HOUSE("Flower House"),
    FOREST("Forest"),
    GRAVEYARD("Graveyard"),
    HIGH_LEVEL("High Level"),
    LIBRARY("Library"),
    MOUNTAIN("Mountain"),
    RUINS("Ruins"),
    TAVERN("Tavern"),
    VILLAGE("Village"),
    WILDERNESS("Wilderness"),
    WIZARD_TOWER("Wizard Tower"),
    CATACOMBS_ENTRANCE("Catacombs Entrance"),

    // The Park
    BIRCH_PARK("Birch Park"),
    SPRUCE_WOODS("Spruce Woods"),
    SAVANNA_WOODLAND("Savanna Woodland"),
    MELODYS_PLATEAU("Melody's Plateau"),
    DARK_THICKET("Dark Thicket"),
    JUNGLE_ISLAND("Jungle Island"),
    HOWLING_CAVE("Howling Cave"),

    GOLD_MINE("Gold Mine"),

    // Deep Caverns
    DEEP_CAVERNS("Deep Caverns"),
    GUNPOWDER_MINES("Gunpowder Mines"),
    LAPIS_QUARRY("Lapis Quarry"),
    PIGMAN_DEN("Pigmen's Den"),
    SLIMEHILL("Slimehill"),
    DIAMOND_RESERVE("Diamond Reserve"),
    OBSIDIAN_SANCTUARY("Obsidian Sanctuary"),

    // Dwarven mines
    DWARVEN_MINES("Dwarven Mines"),
    DWARVEN_VILLAGE("Dwarven Village"),
    GATES_TO_THE_MINES("Gates to the Mines"),
    THE_LIFT("The Lift"),
    THE_FORGE("The Forge"),
    FORGE_BASIN("Forge Basin"),
    LAVA_SPRINGS("Lava Springs"),
    PALACE_BRIDGE("Palace Bridge"),
    ROYAL_PALACE("Royal Palace"),
    ARISTOCRAT_PASSAGE("Aristocrat Passage"),
    HANGING_TERRACE("Hanging Terrace"),
    CLIFFSIDE_VEINS("Cliffside Veins"),
    RAMPARTS_QUARRY("Rampart's Quarry"),
    DIVANS_GATEWAY("Divan's Gateway"),
    FAR_RESERVE("Far Reserve"),
    GOBLIN_BURROWS("Goblin Burrows"),
    UPPER_MINES("Upper Mines"),
    ROYAL_MINES("Royal Mines"),
    MINERS_GUILD("Miner's Guild"),
    GREAT_ICE_WALL("Great Ice Wall"),
    THE_MIST("The Mist"),
    CC_MINECARTS_CO("C&C Minecarts Co."),
    GRAND_LIBRARY("Grand Library"),
    HANGING_COURT("Hanging Court"),

    // Crystal Hollows
    CRYSTAL_HOLLOWS("Crystal Hollows"),
    CRYSTAL_NUCLEUS("Crystal Nucleus"),
    MAGMA_FIELDS("Magma Fields"),
    JUNGLE("Jungle"),
    MITHRIL_DEPOSITS("Mithril Deposits"),
    GOBLIN_HOLDOUT("Goblin Holdout"),
    PRECURSOR_REMNANT("Precursor Remnants"),
    FAIRY_GROTTO("Fairy Grotto"),
    KHAZAD_DUM("Khazad-dûm"), //These are the random gen places in each biome
    JUNGLE_TEMPLE("Jungle Temple"),
    MINES_OF_DIVAN("Mines of Divan"),
    GOBLIN_QUEEN_DEN("Goblin Queens Den"),
    LOST_PRECURSOR_CITY("Lost Precursor City"),

    THE_BARN("The Barn"),

    // Mushroom Island
    MUSHROOM_DESERT("Mushroom Desert"),
    DESERT_SETTLEMENT("Desert Settlement"),
    TREASURE_HUNTER_CAMP("Treasure Hunter Camp"),
    OASIS("Oasis"),
    MUSHROOM_GORGE("Mushroom Gorge"),
    GLOWING_MUSHROOM_CAVE("Glowing Mushroom Cave"),
    OVERGROWN_MUSHROOM_CAVE("Overgrown Mushroom Cave"),
    JAKES_HOUSE("Jake's House"),
    SHEPHERDS_KEEP("Shepherds Keep"),
    TRAPPERS_DEN("Trappers Den"),

    SPIDERS_DEN("Spider's Den"),

    BLAZING_FORTRESS("Blazing Fortress"),

    // The End
    THE_END("The End"),
    DRAGONS_NEST("Dragon's Nest"),
    VOID_SEPULTURE("Void Sepulture"),
    ZEALOT_BRUISER_HIDEOUT("Zealot Bruiser Hideout"),
    VOID_SLATE("Void Slate"),

    // Jerry's workshop
    JERRY_POND("Jerry Pond"),
    JERRYS_WORKSHOP("Jerry's Workshop"),

    // Dungeons
    THE_CATACOMBS("The Catacombs"),
    DUNGEON_HUB("Dungeon Hub"),

    // Crimson Isle
    CRIMSON_ISLE("Crimson Isle"),
    CRIMSON_FIELDS("Crimson Fields"),
    CATHEDRAL("Cathedral"),
    BARBARIAN_OUTPOST("Barbarian Outpost"),
    MAGE_OUTPOST("Mage Outpost"),
    THE_BASTION("The Bastion"),
    BLAZING_VOLCANO("Blazing Volcano"),
    BURNING_DESERT("Burning Desert"),
    DOJO("Dojo"),
    DRAGONTAIL("Dragontail"),
    DRAGONTAIL_TOWNSQUARE("Dragontail Townsquare"),
    DRAGONTAIL_AUCTION_HOUS("Dragontail AH"),
    DRAGONTAIL_BAZAAR("Dragontail BZ"),
    DRAGONTAIL_BANK("Dragontail Bank"),
    DRAGONTAIL_BLACKSMITH("Dragontail Blacksmith"),
    MINION_SHOP("Minion Shop"),
    CHIEFS_HUT("Chief's Hut"),
    FORGOTTEN_SKULL("Forgotten Skull"),
    KUUDRAS_END("Kuudra's End"),
    MAGMA_CHAMBER("Magma Chamber"),
    MYSTIC_MARSH("Mystic Marsh"),
    ODGERS_HUT("Odger's Hut"),
    RUINS_OF_ASHFANG("Ruins of Ashfang"),
    SCARLETON("Scarleton"),
    SCARLETON_PLAZA("Scarleton Plaza"),
    SCARLETON_AUCTION_HOUS("Scarleton AH"),
    SCARLETON_BAZAAR("Scarleton BZ"),
    SCARLETON_BANK("Scarleton Bank"),
    SCARLETON_BLACKSMITH("Scarleton Blacksmith"),
    SCARLETON_MINION_SHOP("Scarleton Minion Shop"),
    STRONGHOLD("Stronghold"),
    THE_WASTELAND("The Wasteland"),
    MATRIARCHS_LAIR("Matriarch's Lair"),
    BELLY_OF_THE_BEAST("Belly of the Beast"),
    AURAS_LAB("Aura's Lab"),
    COURTYARD("Courtyard"),
    IGRUPANS_CHICKEN_COOP("Igrupan's Chicken Coop"),
    THRONE_ROOM("Throne Room"),
    MAGE_COUNCIL("Mage Council"),
    PLHLEGBLAST_POOL("Plhlegblast Pool"),
    SMOLDERING_TOMB("Smoldering Tomb"),

    /*
     * Used when the player is out of bounds.
     */
    NONE("None"),

    /*
     * Used when the player is in a location that is not yet supported.
     */
    UNKNOWN("Unknown");

    public static final Set<Location> DUNGEON_LOCATIONS = new HashSet<Location>() {
        {
            add(THE_CATACOMBS);
        }
    };

    private final @NotNull String name;

    Location(@NotNull String name) {
        this.name = name;
    }

    public @NotNull String getName() {
        return name;
    }
}
