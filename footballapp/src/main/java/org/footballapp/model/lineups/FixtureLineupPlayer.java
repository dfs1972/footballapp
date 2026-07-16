package org.footballapp.model.lineups;

/**
 * Represents a player in a fixture lineup.
 *
 * One record exists per player per fixture.
 */
public class FixtureLineupPlayer {

    private long fixtureId;

    private int teamId;

    private int playerId;

    private int shirtNumber;

    private String position;

    private String grid;

    private boolean starting;

    private int displayOrder;

    public FixtureLineupPlayer() {
    }

    public FixtureLineupPlayer(

            long fixtureId,

            int teamId,

            int playerId,

            int shirtNumber,

            String position,

            String grid,

            boolean starting,

            int displayOrder

    ) {

        this.fixtureId = fixtureId;
        this.teamId = teamId;
        this.playerId = playerId;
        this.shirtNumber = shirtNumber;
        this.position = position;
        this.grid = grid;
        this.starting = starting;
        this.displayOrder = displayOrder;

    }

    public long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(
            long fixtureId
    ) {
        this.fixtureId = fixtureId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(
            int teamId
    ) {
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(
            int playerId
    ) {
        this.playerId = playerId;
    }

    public int getShirtNumber() {
        return shirtNumber;
    }

    public void setShirtNumber(
            int shirtNumber
    ) {
        this.shirtNumber = shirtNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(
            String position
    ) {
        this.position = position;
    }

    public String getGrid() {
        return grid;
    }

    public void setGrid(
            String grid
    ) {
        this.grid = grid;
    }

    public boolean isStarting() {
        return starting;
    }

    public void setStarting(
            boolean starting
    ) {
        this.starting = starting;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(
            int displayOrder
    ) {
        this.displayOrder = displayOrder;
    }

}