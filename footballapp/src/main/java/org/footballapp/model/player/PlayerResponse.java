package org.footballapp.model.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.footballapp.model.playerstatistics.PlayerStatistics;

import java.util.List;

/**
 * Represents a single player returned by API-Football.
 *
 * The API also returns a statistics array, which will
 * be mapped later when player statistics are implemented.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerResponse {

    private Player player;

    private List<PlayerStatistics> statistics;

    public PlayerResponse() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<PlayerStatistics> getStatistics() {
        return statistics;
    }

    public void setStatistics(
            List<PlayerStatistics> statistics
    ) {
        this.statistics = statistics;
    }
}