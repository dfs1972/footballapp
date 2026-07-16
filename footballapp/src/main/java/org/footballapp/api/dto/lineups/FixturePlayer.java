package org.footballapp.api.dto.lineups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Player information returned by the
 * API-Football fixtures/lineups endpoint.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixturePlayer {

    private int id;

    private String name;

    private int number;

    private String pos;

    private String grid;

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

    public int getNumber() {
        return number;
    }

    public void setNumber(
            int number
    ) {
        this.number = number;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(
            String pos
    ) {
        this.pos = pos;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(
            String grid
    ) {
        this.grid = grid;
    }

}