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

    public List<PlayerSummary> toPlayerSummaries(

            PlayersApiResponse response,

            SquadApiResponse squadResponse

    ) {

        List<PlayerSummary> players =
                new ArrayList<>();

        if (response == null
                || response.getResponse() == null) {

            return players;
        }

        Map<Integer, SquadPlayer> squadPlayers =
                buildSquadPlayerMap(
                        squadResponse
                );

        for (PlayerResponse playerResponse
                : response.getResponse()) {

            Player player =
                    playerResponse.getPlayer();

            /*
             * Only include players who are
             * currently in the squad.
             */

            if (!squadPlayers.containsKey(
                    player.getPlayerId()
            )) {

                continue;

            }

            players.add(

                    toPlayerSummary(

                            playerResponse,

                            squadPlayers.get(
                                    player.getPlayerId()
                            )

                    )

            );

        }

        return players;

    }

    private PlayerSummary toPlayerSummary(

            PlayerResponse response,

            SquadPlayer squadPlayer

    ) {

        Player player =
                response.getPlayer();

        PlayerStatistics statistics =
                null;

        if (response.getStatistics() != null
                && !response.getStatistics().isEmpty()) {

            statistics =
                    response.getStatistics().getFirst();

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
         * Squad data is authoritative for
         * current squad information.
         */

        summary.setShirtNumber(
                squadPlayer.getNumber()
        );

        if (statistics != null) {

            summary.setPosition(
                    statistics.getGames().getPosition()
            );

            summary.setCaptain(
                    statistics.getGames().getCaptain()
            );

            summary.setAppearances(
                    statistics.getGames().getAppearances()
            );

            summary.setGoals(
                    statistics.getGoals().getTotal()
            );

            summary.setAssists(
                    statistics.getGoals().getAssists()
            );

        } else {

            /*
             * If there are no season statistics,
             * use the squad position.
             */

            summary.setPosition(
                    squadPlayer.getPosition()
            );

        }

        System.out.println(

                summary.getDisplayName()
                        + " -> "
                        + summary.getPosition()
                        + " -> shirt "
                        + summary.getShirtNumber()

        );

        return summary;

    }

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