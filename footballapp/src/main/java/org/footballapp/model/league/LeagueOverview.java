package org.footballapp.model.league;

public class LeagueOverview {

    private int leagueId;
    private String leagueName;
    private int season;
    private int teamCount;
    private int fixtureCount;

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getTeamCount() {
        return teamCount;
    }

    public void setTeamCount(int teamCount) {
        this.teamCount = teamCount;
    }

    public int getFixtureCount() {
        return fixtureCount;
    }

    public void setFixtureCount(int fixtureCount) {
        this.fixtureCount = fixtureCount;
    }
}