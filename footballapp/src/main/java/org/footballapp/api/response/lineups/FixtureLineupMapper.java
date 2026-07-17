package org.footballapp.api.response.lineups;

import org.footballapp.model.lineups.FixtureLineup;
import org.footballapp.model.lineups.FixtureLineupPlayer;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FixtureLineupMapper {

    /**
     * Creates the top-level response for a fixture.
     */
    public FixtureLineupResponse createResponse(
            long fixtureId
    ) {

        FixtureLineupResponse response =
                new FixtureLineupResponse();

        response.setFixtureId(
                fixtureId
        );

        return response;

    }

    /**
     * Maps a team lineup.
     */
    public FixtureTeamLineupResponse mapTeamLineup(

            FixtureLineup lineup,

            List<PlayerLineupResponse> players

    ) {

        FixtureTeamLineupResponse response =
                new FixtureTeamLineupResponse();

        response.setTeamId(
                lineup.getTeamId()
        );

        response.setCoachId(
                lineup.getCoachId()
        );

        response.setCoachName(
                lineup.getCoachName()
        );

        response.setFormation(
                lineup.getFormation()
        );

        response.setPlayers(
                players
        );

        return response;

    }

    /**
     * Maps a lineup player.
     */
    public PlayerLineupResponse mapPlayer(

            FixtureLineupPlayer player,

            String playerName

    ) {

        PlayerLineupResponse response =
                new PlayerLineupResponse();

        response.setPlayerId(
                player.getPlayerId()
        );

        response.setPlayerName(
                playerName
        );

        response.setShirtNumber(
                player.getShirtNumber()
        );

        response.setPosition(
                player.getPosition()
        );

        response.setGrid(
                player.getGrid()
        );

        response.setStarting(
                player.isStarting()
        );

        response.setDisplayOrder(
                player.getDisplayOrder()
        );

        return response;

    }

}