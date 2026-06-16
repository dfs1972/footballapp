package org.footballapp.model.standings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Standing {

    private int rank;

    private StandingTeam team;

    private int points;

    private int goalsDiff;

    private StandingRecord all;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public StandingTeam getTeam() {
        return team;
    }

    public void setTeam(
            StandingTeam team
    ) {
        this.team = team;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getGoalsDiff() {
        return goalsDiff;
    }

    public void setGoalsDiff(int goalsDiff) {
        this.goalsDiff = goalsDiff;
    }

    public StandingRecord getAll() {
        return all;
    }

    public void setAll(
            StandingRecord all
    ) {
        this.all = all;
    }
}
