package org.footballapp.model.fixtures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FixtureResponse {

    private Fixture fixture;
    private FixtureLeague league;
    private FixtureTeams teams;
    private FixtureGoals goals;

    public FixtureResponse() {
    }

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

    public FixtureLeague getLeague() {
        return league;
    }

    public void setLeague(FixtureLeague league) {
        this.league = league;
    }

    public FixtureTeams getTeams() {
        return teams;
    }

    public void setTeams(FixtureTeams teams) {
        this.teams = teams;
    }

    public FixtureGoals getGoals() {
        return goals;
    }

    public void setGoals(FixtureGoals goals) {
        this.goals = goals;
    }
}