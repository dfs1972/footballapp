package org.footballapp.model.teams;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Returns the ID received from TeamResponse.
@JsonIgnoreProperties(ignoreUnknown = true)
public class ID {

    private int id;

    public ID() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}