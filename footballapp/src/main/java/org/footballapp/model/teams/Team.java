package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Returns the club data received from TeamResponse.

@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {

    private int id;
    private String name;
    private String country;
    private int founded;

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

    public int getClubFounded() {return founded;}
    public void setClubFounded(int founded) {this.founded = founded;}
}