package org.footballapp.model.league;

import java.util.List;

public class LeagueOverview {

    private String countryName;
    private String countryFlag;
    private int leagueId;
    private String leagueName;
    private String type;
    private int season;
    private List<FeaturedLeagueOverview> featuredLeagues;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(
            int season
    ) {
        this.season = season;
    }

    public List<FeaturedLeagueOverview> getFeaturedLeagues() {
        return featuredLeagues;
    }

    public void setFeaturedLeagues(List<FeaturedLeagueOverview> featuredLeagues) {
        this.featuredLeagues = featuredLeagues;
    }
}