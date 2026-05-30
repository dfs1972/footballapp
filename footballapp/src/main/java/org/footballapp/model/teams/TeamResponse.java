package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamResponse {

    private Team team;
    private Venue venue;

    public TeamResponse() {
    }

    public Team getTeam() {return team;}

    public void setTeam(Team team) {
        this.team = team;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}