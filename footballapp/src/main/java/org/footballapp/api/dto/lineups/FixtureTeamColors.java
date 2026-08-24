package org.footballapp.api.dto.lineups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureTeamColors {

    private FixturePlayerColors player;

    private FixturePlayerColors goalkeeper;


    public FixturePlayerColors getPlayer() {
        return player;
    }

    public void setPlayer(
            FixturePlayerColors player
    ) {
        this.player = player;
    }


    public FixturePlayerColors getGoalkeeper() {
        return goalkeeper;
    }

    public void setGoalkeeper(
            FixturePlayerColors goalkeeper
    ) {
        this.goalkeeper = goalkeeper;
    }

}