package org.footballapp.api.response.lineups;

public class FixtureTeamColorsResponse {

    private FixturePlayerColorsResponse player;

    private FixturePlayerColorsResponse goalkeeper;


    public FixturePlayerColorsResponse getPlayer() {
        return player;
    }

    public void setPlayer(
            FixturePlayerColorsResponse player
    ) {
        this.player = player;
    }


    public FixturePlayerColorsResponse getGoalkeeper() {
        return goalkeeper;
    }

    public void setGoalkeeper(
            FixturePlayerColorsResponse goalkeeper
    ) {
        this.goalkeeper = goalkeeper;
    }

}