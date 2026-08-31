package org.footballapp.mapper;

import org.footballapp.model.player.Player;
import org.footballapp.model.player.PlayerResponse;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.playerdetails.PlayerSummary;
import org.footballapp.model.playerstatistics.PlayerStatistics;
import org.footballapp.model.squad.SquadApiResponse;
import org.footballapp.model.squad.SquadPlayer;
import org.footballapp.model.squad.SquadResponse;
import org.footballapp.util.PlayerDisplayNameFormatter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PlayerMapper {


    /************** PLAYER SUMMARIES ********************/

    public List<PlayerSummary> toPlayerSummaries(
            PlayersApiResponse response,
            int leagueId
    ) {

        List<PlayerSummary> players =
                new ArrayList<>();

        if (response == null
                || response.getResponse() == null) {

            return players;
        }

        for (PlayerResponse playerResponse
                : response.getResponse()) {

            players.add(
                    toPlayerSummary(
                            playerResponse,
                            leagueId
                    )
            );
        }

        return players;
    }


    /****************** PLAYER SUMMARY **********************/

    private PlayerSummary toPlayerSummary(
            PlayerResponse playerResponse,
            int leagueId
    ) {

        Player player =
                playerResponse.getPlayer();

        PlayerStatistics statistics =
                null;

        if (playerResponse.getStatistics() != null) {

            for (PlayerStatistics stats : playerResponse.getStatistics()) {

                if (stats.getLeague() != null
                        && stats.getLeague().getLeagueId() == leagueId) {

                    statistics = stats;

                    break;
                }
            }

            // Fallback to first if league not found
            if (statistics == null && !playerResponse.getStatistics().isEmpty()) {
                statistics = playerResponse.getStatistics().getFirst();
            }
        }

        PlayerSummary summary =
                new PlayerSummary();

        summary.setPlayerId(
                player.getPlayerId()
        );

        summary.setDisplayName(
                PlayerDisplayNameFormatter.format(
                        player.getFirstname(),
                        player.getLastname(),
                        player.getName()
                )
        );

        summary.setPhotoUrl(
                player.getPhotoUrl()
        );

        summary.setNationality(
                player.getNationality()
        );

        summary.setAge(
                player.getAge()
        );

        /*
         * Historic-season data comes from
         * the season-specific player statistics.
         */

        if (statistics != null) {

            if (statistics.getGames() != null) {

                summary.setPosition(
                        statistics.getGames().getPosition()
                );

                summary.setCaptain(
                        statistics.getGames().getCaptain()
                );

                summary.setAppearances(
                        statistics.getGames().getAppearances()
                );

                summary.setShirtNumber(
                        statistics.getGames().getNumber()
                );
            }

            if (statistics.getGoals() != null) {

                summary.setGoals(
                        statistics.getGoals().getTotal()
                );

                summary.setAssists(
                        statistics.getGoals().getAssists()
                );
            }
        }

        /*
         * Shirt number is deliberately left null.
         *
         * The current squad endpoint must not be
         * used to supply historic-season data.
         */

        System.out.println(
                summary.getDisplayName()
                        + " -> "
                        + summary.getPosition()
                        + " -> shirt "
                        + summary.getShirtNumber()
        );

        return summary;
    }


    /************* BUILD SQUAD PLAYER MAP ********************/

    private Map<Integer, SquadPlayer> buildSquadPlayerMap(

            SquadApiResponse response

    ) {

        Map<Integer, SquadPlayer> squadPlayers =
                new HashMap<>();

        if (response == null
                || response.getResponse() == null) {

            return squadPlayers;
        }

        for (SquadResponse squadResponse
                : response.getResponse()) {

            if (squadResponse.getPlayers() == null) {
                continue;
            }

            for (SquadPlayer player
                    : squadResponse.getPlayers()) {

                squadPlayers.put(

                        player.getId(),

                        player

                );

            }

        }

        return squadPlayers;

    }

}