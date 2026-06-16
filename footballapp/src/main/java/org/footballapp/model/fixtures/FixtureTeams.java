package org.footballapp.model.fixtures;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureTeams {

    private FixtureTeam home;
    private FixtureTeam away;

    public FixtureTeam getHome() {
        return home;
    }

    public void setHome(FixtureTeam home) {
        this.home = home;
    }

    /**Getters and Setters*/
    public FixtureTeam getAway() {
        return away;
    }

    public void setAway(FixtureTeam away) {
        this.away = away;
    }

    public FixtureTeams() {
    }
}
