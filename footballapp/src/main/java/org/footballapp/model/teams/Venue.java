package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Returns the stadium data received from TeamResponse.

@JsonIgnoreProperties(ignoreUnknown = true)
public class Venue {

    private int id;
    private String name;
    private int capacity;

    public Venue() {
    }

    public int getId() {return id;}
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {return capacity;}
    public void setCapacity(int capacity) {this.capacity = capacity;}
}