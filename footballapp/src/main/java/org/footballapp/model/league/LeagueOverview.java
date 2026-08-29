package org.footballapp.model.league;

public class LeagueOverview {

    private String countryName;
    private String countryFlag;
    private int leagueId;
    private String leagueName;
    private int season;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(
            int leagueId
    ) {
        this.leagueId = leagueId;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(
            String leagueName
    ) {
        this.leagueName = leagueName;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(
            int season
    ) {
        this.season = season;
    }
}