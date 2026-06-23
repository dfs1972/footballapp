package org.footballapp.model.standings;


public class LeagueTableRow {

    private int position;
    private int teamId;
    private String teamName;
    private int played;
    private int wins;
    private int draws;
    private int losses;
    private int goalDifference;
    private int points;

    public int getPosition() {return position;}

    public void setPosition(int position) {this.position = position;}

    public int getTeamId() {return teamId;}

    public void setTeamId(int teamId) {this.teamId = teamId;}

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getPlayed() {return played;}

    public void setPlayed(int played) {this.played = played;}

    public int getWins() {return wins;}

    public void setWins(int wins) {this.wins = wins;}

    public int getDraws() {return draws;}

    public void setDraws(int draws) {this.draws = draws;}

    public int getLosses() {return losses;}

    public void setLosses(int losses) {this.losses = losses;}

    public int getGoalDifference() {return goalDifference;}

    public void setGoalDifference(int goalDifference) {this.goalDifference = goalDifference;}

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}