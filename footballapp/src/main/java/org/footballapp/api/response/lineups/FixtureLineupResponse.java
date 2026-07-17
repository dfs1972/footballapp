package org.footballapp.api.response.lineups;

import java.util.ArrayList;
import java.util.List;

public class FixtureLineupResponse {

    private long fixtureId;

    private List<FixtureTeamLineupResponse> teams =
            new ArrayList<>();

    public long getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(long fixtureId) {
        this.fixtureId = fixtureId;
    }

    public List<FixtureTeamLineupResponse> getTeams() {
        return teams;
    }

    public void setTeams(
            List<FixtureTeamLineupResponse> teams
    ) {
        this.teams = teams;
    }

}