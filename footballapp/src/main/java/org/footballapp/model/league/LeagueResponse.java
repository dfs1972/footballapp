package org.footballapp.model.league;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a single entry within the API-Football
 * response array.
 *
 * Each response contains:
 * - League information
 * - Country information
 * - Season information
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueResponse {
    private int id;
    private String name;
    private String country;
    private int season;

    public LeagueResponse() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
