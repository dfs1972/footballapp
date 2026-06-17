package org.footballapp.model.teamdetails;

import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.model.teams.Team;

import java.util.List;

/**
 * Returns team, league position, points, form and recent fixtures.
 */
public class TeamDetails {

    private Team team;

    private int leaguePosition;

    private int points;

    private String form;

    private List<FixtureRow> recentFixtures;

    public TeamDetails() {
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getLeaguePosition() {
        return leaguePosition;
    }

    public void setLeaguePosition(int leaguePosition) {
        this.leaguePosition = leaguePosition;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public List<FixtureRow> getRecentFixtures() {
        return recentFixtures;
    }

    public void setRecentFixtures(
            List<FixtureRow> recentFixtures
    ) {
        this.recentFixtures = recentFixtures;
    }
}