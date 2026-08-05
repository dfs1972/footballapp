package org.footballapp.mapper;

import org.footballapp.model.player.Player;
import org.footballapp.model.player.PlayerResponse;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.playerdetails.PlayerSummary;
import org.footballapp.model.playerstatistics.PlayerStatistics;
import org.footballapp.util.PlayerDisplayNameFormatter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerMapper {

    public List<PlayerSummary> toPlayerSummaries(
            PlayersApiResponse response
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
                    toPlayerSummary(playerResponse)
            );

        }

        return players;
    }

    private PlayerSummary toPlayerSummary(
            PlayerResponse response
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

        if (statistics != null) {

            summary.setPosition(
                    statistics.getGames().getPosition()
            );

            summary.setShirtNumber(
                    statistics.getGames().getNumber()
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

        }

        return summary;

    }

}