package xyz.deftu.sbpi.scoreboard;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.jetbrains.annotations.Nullable;
import xyz.deftu.sbpi.HypixelSkyBlockAPIImpl;
import xyz.deftu.sbpi.api.scoreboard.ScoreboardInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ScoreboardManager {
    public static final Pattern SIDEBAR_EMOJI_PATTERN = Pattern.compile("[\uD83D\uDD2B\uD83C\uDF6B\uD83D\uDCA3\uD83D\uDC7D\uD83D\uDD2E\uD83D\uDC0D\uD83D\uDC7E\uD83C\uDF20\uD83C\uDF6D\u26BD\uD83C\uDFC0\uD83D\uDC79\uD83C\uDF81\uD83C\uDF89\uD83C\uDF82]+");

    private @Nullable ScoreboardInfo currentInfo;
    private int tickCounter = 0;

    public void initialize() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    private boolean isAllowedTick() {
        int pollingRate = HypixelSkyBlockAPIImpl.getConfig().scoreboardPollingRate;
        if (pollingRate == 0) return true;

        return tickCounter++ % pollingRate != 0;
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase != TickEvent.Phase.START || !isAllowedTick()) return;
        tickCounter = 0;

        Minecraft client = Minecraft.getMinecraft();
        if (client.theWorld == null) {
            currentInfo = null;
            return;
        }

        Scoreboard scoreboard = client.theWorld.getScoreboard();
        ScoreObjective objective = scoreboard.getObjectiveInDisplaySlot(1);
        // it's likely the player isn't in skyblock, or on hypixel
        if (objective == null) {
            currentInfo = null;
            return;
        }

        String objectiveName = objective.getDisplayName();
        String objectiveNameStripped = EnumChatFormatting.getTextWithoutFormattingCodes(objectiveName);

        List<Score> scores = filterScores(scoreboard.getSortedScores(objective));
        Collections.reverse(scores);

        List<String> lines = new ArrayList<>();
        List<String> linesStripped = new ArrayList<>();

        for (Score score : scores) {
            ScorePlayerTeam team = scoreboard.getPlayersTeam(score.getPlayerName());
            String line = ScorePlayerTeam.formatPlayerName(team, score.getPlayerName());
            String lineStripped = EnumChatFormatting.getTextWithoutFormattingCodes(SIDEBAR_EMOJI_PATTERN.matcher(line).replaceAll(""));

            lines.add(line);
            linesStripped.add(lineStripped);
        }

        currentInfo = new ScoreboardInfo(scoreboard, objective, objectiveName, objectiveNameStripped, scores, lines, linesStripped);
    }

    private List<Score> filterScores(Collection<Score> scores) {
        List<Score> result = scores.stream().filter(score -> score.getPlayerName() != null && !score.getPlayerName().startsWith("#")).collect(Collectors.toList());

        if (result.size() > 15) return Lists.newArrayList(Iterables.skip(result, scores.size() - 15));
        return result;
    }

    public ScoreboardInfo getCurrentInfo() {
        return currentInfo;
    }
}
