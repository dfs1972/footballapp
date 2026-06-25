package org.footballapp.model.playerstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerStatistics {

    private PlayerTeam team;

    private PlayerLeague league;

    private PlayerGames games;

    private PlayerGoals goals;

    private PlayerCards cards;

    public PlayerStatistics() {
    }

    public PlayerTeam getTeam() {
        return team;
    }

    public void setTeam(PlayerTeam team) {
        this.team = team;
    }

    public PlayerLeague getLeague() {
        return league;
    }

    public void setLeague(PlayerLeague league) {
        this.league = league;
    }

    public PlayerGames getGames() {
        return games;
    }

    public void setGames(PlayerGames games) {
        this.games = games;
    }

    public PlayerGoals getGoals() {
        return goals;
    }

    public void setGoals(PlayerGoals goals) {
        this.goals = goals;
    }

    public PlayerCards getCards() {
        return cards;
    }

    public void setCards(PlayerCards cards) {
        this.cards = cards;
    }
}