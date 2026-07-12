package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents a football club returned by API-Football.
 *
 * Mapped from the JSON "team" object.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {

    private int id;
    private String name;
    private String country;
    private int founded;
    private int venueId;

    public Team() {
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

    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}

    public int getFounded() {return founded;}
    public void setFounded(int founded) {this.founded = founded;}

    public int getVenueId() {return venueId;}
    public void setVenueId(int venueId) {this.venueId = venueId;}

}