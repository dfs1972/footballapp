package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Team information contained within a player's statistics.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerTeam {

    @JsonProperty("id")
    private int teamId;

    private String name;

    @JsonProperty("logo")
    private String logoUrl;

    public PlayerTeam() {
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}