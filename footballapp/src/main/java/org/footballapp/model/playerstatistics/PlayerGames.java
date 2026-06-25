package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerGames {

    @JsonProperty("appearences")
    private Integer appearances;
    private Integer lineups;
    private Integer minutes;

    private String position;

    private Integer number;

    private Boolean captain;

    private String rating;

    public PlayerGames() {
    }

    public Integer getAppearances() {
        return appearances;
    }

    public void setAppearances(Integer appearences) {
        this.appearances = appearences;
    }

    public Integer getLineups() {
        return lineups;
    }

    public void setLineups(Integer lineups) {
        this.lineups = lineups;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getCaptain() {
        return captain;
    }

    public void setCaptain(Boolean captain) {
        this.captain = captain;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}