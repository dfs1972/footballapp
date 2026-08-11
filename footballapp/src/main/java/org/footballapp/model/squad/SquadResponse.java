package org.footballapp.model.squad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SquadResponse {

    private SquadTeam team;

    private List<SquadPlayer> players;

    public SquadResponse() {
    }

    public SquadTeam getTeam() {
        return team;
    }

    public void setTeam(
            SquadTeam team
    ) {
        this.team = team;
    }

    public List<SquadPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(
            List<SquadPlayer> players
    ) {
        this.players = players;
    }
}