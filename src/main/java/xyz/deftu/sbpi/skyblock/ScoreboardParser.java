package xyz.deftu.sbpi.skyblock;

import xyz.deftu.sbpi.api.HypixelSkyBlockAPI;
import xyz.deftu.sbpi.api.info.DungeonType;
import xyz.deftu.sbpi.api.info.Location;
import xyz.deftu.sbpi.api.scoreboard.ScoreboardInfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScoreboardParser {
    private static final Pattern PURSE_REGEX = Pattern.compile("(?:Purse|Piggy): (?<coins>[0-9.,]*)");
    private static final Pattern BITS_REGEX = Pattern.compile("Bits: (?<bits>[0-9,]*)");

    public void parse(MutableSkyBlockInfo currentInfo) {
        ScoreboardInfo scoreboardInfo = HypixelSkyBlockAPI.getInstance().getCurrentScoreboardInfo();
        if (scoreboardInfo == null) return;

        MutableSlayerQuestInfo slayerQuest = currentInfo.getSlayerQuest();
        MutableDungeonInfo dungeon = currentInfo.getDungeon();
        for (int i = 0; i < scoreboardInfo.getLinesStripped().size(); i++) {
            String line = scoreboardInfo.getLinesStripped().get(i);
            System.out.println("New line: " + i + " - '" + line + "'");

            switch (i) {
                case 4: {
                    if (!currentInfo.hasLocation()) {
                        Location location = null;
                        for (Location value : Location.values()) {
                            if (line.endsWith(value.getName())) {
                                location = value;
                                break;
                            }
                        }

                        if (location == null) {
                            for (Location dungeonLocation : Location.DUNGEON_LOCATIONS) {
                                if (line.contains(dungeonLocation.getName())) {
                                    location = dungeonLocation;
                                    break;
                                }
                            }
                        }

                        if (location != null) {
                            currentInfo.setLocation(location);
                        }
                    }

                    break;
                }

                case 6: {
                    currentInfo.setActiveSoupTime(parseSoup(line));
                    if (!currentInfo.isSoupActive()) {
                        currentInfo.setCoins(parseCoins(line));
                    }

                    break;
                }

                case 7: {
                    if (currentInfo.isSoupActive()) {
                        currentInfo.setCoins(parseCoins(line));
                    } else {
                        currentInfo.setBits(parseBits(line));
                    }

                    break;
                }

                case 8: {
                    if (currentInfo.isSoupActive()) {
                        currentInfo.setBits(parseBits(line));
                    }

                    break;
                }
            }

            if (line.startsWith("Combat XP") || line.endsWith("Kills")) {
                if (slayerQuest == null) slayerQuest = new MutableSlayerQuestInfo();

                // TODO parse slayer quest
            }

            if (line.startsWith("Cleared: ") && !currentInfo.isInDungeon()) {
                if (dungeon == null) dungeon = new MutableDungeonInfo();

                DungeonType type = DungeonType.fromLocation(currentInfo.getLocation());
                if (type != null) dungeon.setType(type);
            }
        }

        currentInfo.setSlayerQuest(slayerQuest);
        currentInfo.setDungeon(dungeon);
    }

    private int parseSoup(String line) {
        boolean soupActive = line.startsWith("Flight");
        if (!soupActive) return -1;

        String stripped = line.substring(line.indexOf(":")).replaceFirst(":", "").replace(" ", "");
        String[] split = stripped.split(":");
        int hour = 0;
        int minute = 0;
        int second = 0;
        if (split.length == 3) {
            hour = Integer.parseInt(split[0]);
            minute = Integer.parseInt(split[1]);
            second = Integer.parseInt(split[2]);
        } else if (split.length == 2) {
            minute = Integer.parseInt(split[0]);
            second = Integer.parseInt(split[1]);
        } else if (split.length == 1) {
            second = Integer.parseInt(split[0]);
        }

        int hoursInSeconds = hour * 60 * 60;
        int minutesInSeconds = minute * 60;
        int totalSeconds = hoursInSeconds + minutesInSeconds + second;
        return totalSeconds;
    }

    private int parseCoins(String line) {
        Matcher matcher = PURSE_REGEX.matcher(line);
        if (matcher.matches()) {
            try {
                return SkyBlockInfoTracker.NUMBER_FORMAT.parse(matcher.group("coins")).intValue();
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        } else return -1;
    }

    private int parseBits(String line) {
        if (line.isEmpty()) return -1;

        Matcher matcher = BITS_REGEX.matcher(line);
        if (matcher.matches()) {
            try {
                return SkyBlockInfoTracker.NUMBER_FORMAT.parse(matcher.group("bits")).intValue();
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        } else return -1;
    }
}
