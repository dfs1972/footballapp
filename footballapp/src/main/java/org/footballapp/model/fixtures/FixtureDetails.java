package org.footballapp.model.fixtures;

public class FixtureDetails {

    private long fixtureId;

    private String fixtureDate;

    private int homeTeamId;
    private String homeTeam;

    private int awayTeamId;
    private String awayTeam;

    private Integer homeGoals;
    private Integer awayGoals;

    private String venueName;

    private int leagueId;
    private String leagueName;

    private int season;


    /**
     * Fixture Details Getters.
     */

    public long getFixtureId() {
        return fixtureId;
    }

    public String getFixtureDate() {
        return fixtureDate;
    }

    public int getHomeTeamId() {
        return homeTeamId;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public int getAwayTeamId() {
        return awayTeamId;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public Integer getHomeGoals() {
        return homeGoals;
    }

    public Integer getAwayGoals() {
        return awayGoals;
    }

    public String getVenueName() {
        return venueName;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public int getSeason() {
        return season;
    }

    public String getRound() {
        return round;
    }

    private String round;

    /**
     * Fixture Details Setters
     */

    public void setFixtureId(long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public void setFixtureDate(String fixtureDate) {
        this.fixtureDate = fixtureDate;
    }

    public void setHomeTeamId(int homeTeamId) {
        this.homeTeamId = homeTeamId;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeamId(int awayTeamId) {
        this.awayTeamId = awayTeamId;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setHomeGoals(Integer homeGoals) {
        this.homeGoals = homeGoals;
    }

    public void setAwayGoals(Integer awayGoals) {
        this.awayGoals = awayGoals;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public void setRound(String round) {
        this.round = round;
    }
}
