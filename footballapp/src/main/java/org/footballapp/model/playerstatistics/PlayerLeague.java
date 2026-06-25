package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * League information contained within a player's statistics.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerLeague {

    @JsonProperty("id")
    private int leagueId;

    private String name;

    private int season;

    public PlayerLeague() {
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}