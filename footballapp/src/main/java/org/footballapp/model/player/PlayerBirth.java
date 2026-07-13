package org.footballapp.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a player's birth information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerBirth {

    private String date;
    private String place;
    private String country;

    public PlayerBirth() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}