package org.footballapp.api.response.lineups;

import org.footballapp.api.dto.lineups.FixturePlayerWrapper;
import org.footballapp.model.lineups.FixtureLineup;
import org.footballapp.model.lineups.FixtureLineupPlayer;
import org.footballapp.model.teams.Team;
import org.footballapp.util.TeamNameFormatter;
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

            Team team,

            List<PlayerLineupResponse> players

    ) {

        FixtureTeamLineupResponse response =
                new FixtureTeamLineupResponse();

        response.setTeamId(
                lineup.getTeamId()
        );

        if (team != null) {

            response.setTeamName(
                    TeamNameFormatter.format(
                            team.getName()
                    )
            );

        }

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
     * Maps an API-Football team lineup to the
     * backend team lineup response.
     */
    public FixtureTeamLineupResponse mapApiTeamLineup(

            org.footballapp.api.dto.lineups.FixtureLineupResponse lineup,

            List<PlayerLineupResponse> players

    ) {

        FixtureTeamLineupResponse response =
                new FixtureTeamLineupResponse();

        if (lineup.getTeam() != null) {

            response.setTeamId(
                    lineup.getTeam().getId()
            );

            response.setTeamName(
                    TeamNameFormatter.format(
                            lineup.getTeam().getName()
                    )
            );

        }

        if (lineup.getCoach() != null) {

            response.setCoachId(
                    lineup.getCoach().getId()
            );

            response.setCoachName(
                    lineup.getCoach().getName()
            );

        }

        response.setFormation(
                lineup.getFormation()
        );

        if (lineup.getTeam() != null
                && lineup.getTeam().getColors() != null) {

            FixtureTeamColorsResponse colorsResponse =
                    new FixtureTeamColorsResponse();

            if (lineup.getTeam().getColors().getPlayer() != null) {

                FixturePlayerColorsResponse playerColors =
                        new FixturePlayerColorsResponse();

                playerColors.setPrimary(
                        lineup.getTeam()
                                .getColors()
                                .getPlayer()
                                .getPrimary()
                );

                playerColors.setNumber(
                        lineup.getTeam()
                                .getColors()
                                .getPlayer()
                                .getNumber()
                );

                playerColors.setBorder(
                        lineup.getTeam()
                                .getColors()
                                .getPlayer()
                                .getBorder()
                );

                colorsResponse.setPlayer(
                        playerColors
                );
            }

            if (lineup.getTeam().getColors().getGoalkeeper() != null) {

                FixturePlayerColorsResponse goalkeeperColors =
                        new FixturePlayerColorsResponse();

                goalkeeperColors.setPrimary(
                        lineup.getTeam()
                                .getColors()
                                .getGoalkeeper()
                                .getPrimary()
                );

                goalkeeperColors.setNumber(
                        lineup.getTeam()
                                .getColors()
                                .getGoalkeeper()
                                .getNumber()
                );

                goalkeeperColors.setBorder(
                        lineup.getTeam()
                                .getColors()
                                .getGoalkeeper()
                                .getBorder()
                );

                colorsResponse.setGoalkeeper(
                        goalkeeperColors
                );
            }

            response.setColors(
                    colorsResponse
            );
        }

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

    /**
     * Maps an API-Football lineup player to the
     * backend player lineup response.
     */
    public PlayerLineupResponse mapApiPlayer(

            FixturePlayerWrapper wrapper,

            boolean starting,

            int displayOrder

    ) {

        PlayerLineupResponse response =
                new PlayerLineupResponse();

        if (wrapper == null
                || wrapper.getPlayer() == null) {

            return response;

        }

        response.setPlayerId(
                wrapper.getPlayer().getId()
        );

        response.setPlayerName(
                wrapper.getPlayer().getName()
        );

        response.setShirtNumber(
                wrapper.getPlayer().getNumber()
        );

        response.setPosition(
                wrapper.getPlayer().getPos()
        );

        response.setGrid(
                wrapper.getPlayer().getGrid()
        );

        response.setStarting(
                starting
        );

        response.setDisplayOrder(
                displayOrder
        );

        return response;
    }



}