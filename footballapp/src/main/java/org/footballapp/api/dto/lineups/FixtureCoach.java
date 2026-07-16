package org.footballapp.api.dto.lineups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Coach information returned by the
 * API-Football fixtures/lineups endpoint.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureCoach {

    private int id;

    private String name;

    private String photo;

    public int getId() {
        return id;
    }

    public void setId(
            int id
    ) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(
            String name
    ) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(
            String photo
    ) {
        this.photo = photo;
    }

}