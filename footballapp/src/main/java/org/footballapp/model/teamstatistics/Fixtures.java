package org.footballapp.model.teamstatistics;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Fixtures {

    private FixturesTotals played;
    private FixturesTotals wins;
    private FixturesTotals draws;
    private FixturesTotals loses;

    public FixturesTotals getPlayed() {
        return played;
    }

    public void setPlayed(FixturesTotals played) {
        this.played = played;
    }

    public FixturesTotals getWins() {
        return wins;
    }

    public void setWins(FixturesTotals wins) {
        this.wins = wins;
    }

    public FixturesTotals getDraws() {
        return draws;
    }

    public void setDraws(FixturesTotals draws) {
        this.draws = draws;
    }

    public FixturesTotals getLoses() {
        return loses;
    }

    public void setLoses(FixturesTotals loses) {
        this.loses = loses;
    }
}