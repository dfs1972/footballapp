package org.footballapp.model.fixtures;

public class FixtureRow {

    private String fixtureDate;
    private int homeTeamId;
    private int awayTeamId;
    private String homeTeam;
    private String awayTeam;
    private int homeGoals;
    private int awayGoals;
    private String round;

    /**Getters and Setters*/
    public String getFixtureDate() {
        return fixtureDate;
    }

    public void setFixtureDate(String fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    public int getHomeTeamId() {return homeTeamId;}

    public void setHomeTeamId(int homeTeamId) {this.homeTeamId = homeTeamId;}

    public int getAwayTeamId() {return awayTeamId;}

    public void setAwayTeamId(int awayTeamId) {this.awayTeamId = awayTeamId;}

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }
}