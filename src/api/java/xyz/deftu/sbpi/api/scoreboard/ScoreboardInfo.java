package xyz.deftu.sbpi.api.scoreboard;

import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;

import java.util.List;

public class ScoreboardInfo {
    private final Scoreboard scoreboard;
    private final ScoreObjective objective;
    private final String objectiveName;
    private final String objectiveNameStripped;
    private final List<Score> scores;
    private final List<String> lines;
    private final List<String> linesStripped;


    public ScoreboardInfo(Scoreboard scoreboard, ScoreObjective objective, String objectiveName, String objectiveNameStripped, List<Score> scores, List<String> lines, List<String> linesStripped) {
        this.scoreboard = scoreboard;
        this.objective = objective;
        this.objectiveName = objectiveName;
        this.objectiveNameStripped = objectiveNameStripped;
        this.scores = scores;
        this.lines = lines;
        this.linesStripped = linesStripped;
    }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public ScoreObjective getObjective() {
        return objective;
    }

    public String getObjectiveName() {
        return objectiveName;
    }

    public String getObjectiveNameStripped() {
        return objectiveNameStripped;
    }

    public List<Score> getScores() {
        return scores;
    }

    public List<String> getLines() {
        return lines;
    }

    public List<String> getLinesStripped() {
        return linesStripped;
    }
}
