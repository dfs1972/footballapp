package org.footballapp.api.dto.lineups;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Wrapper around a player returned by the
 * API-Football fixtures/lineups endpoint.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FixturePlayerWrapper {

    private FixturePlayer player;

    public FixturePlayer getPlayer() {
        return player;
    }

    public void setPlayer(
            FixturePlayer player
    ) {
        this.player = player;
    }

}