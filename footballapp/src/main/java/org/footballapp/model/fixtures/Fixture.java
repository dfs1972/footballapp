package org.footballapp.model.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fixture {

    private long id;
    private String date;
    private FixtureVenue venue;
    private FixtureStatus status;

    public Fixture() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public FixtureVenue getVenue() {
        return venue;
    }

    public void setVenue(FixtureVenue venue) {
        this.venue = venue;
    }

    public FixtureStatus getStatus() {
        return status;
    }

    public void setStatus(FixtureStatus status) {
        this.status = status;
    }
}