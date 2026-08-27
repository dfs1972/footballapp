package org.footballapp.model.competition;

public class FeaturedCompetition {

    private String country;

    private int leagueId;

    private int priority;

    public FeaturedCompetition() {
    }

    public FeaturedCompetition(
            String country,
            int leagueId,
            int priority
    ) {
        this.country = country;
        this.leagueId = leagueId;
        this.priority = priority;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(
            String country
    ) {
        this.country = country;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(
            int leagueId
    ) {
        this.leagueId = leagueId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(
            int priority
    ) {
        this.priority = priority;
    }
}