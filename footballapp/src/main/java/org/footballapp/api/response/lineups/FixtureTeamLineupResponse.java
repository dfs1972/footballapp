package org.footballapp.api.response.lineups;

import java.util.ArrayList;
import java.util.List;

public class FixtureTeamLineupResponse {

    private int teamId;
    private int coachId;
    private String coachName;
    private String formation;

    private List<PlayerLineupResponse> players =
            new ArrayList<>();

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public String getCoachName() {
        return coachName;
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public List<PlayerLineupResponse> getPlayers() {
        return players;
    }

    public void setPlayers(
            List<PlayerLineupResponse> players
    ) {
        this.players = players;
    }

}