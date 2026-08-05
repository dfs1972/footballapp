package org.footballapp.mapper;

import org.footballapp.model.player.Player;
import org.footballapp.model.player.PlayerResponse;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.playerdetails.PlayerDetails;
import org.footballapp.model.playerstatistics.PlayerStatistics;
import org.footballapp.util.PlayerDisplayNameFormatter;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class PlayerDetailsMapper {

    public PlayerDetails toPlayerDetails(
            PlayersApiResponse response,
            int leagueId,
            int season
    ) {

        if (response == null
                || response.getResponse() == null
                || response.getResponse().isEmpty()) {

            return null;
        }

        return toPlayerDetails(
                response.getResponse().getFirst(),
                leagueId,
                season
        );

    }

    private PlayerDetails toPlayerDetails(
            PlayerResponse response,
            int leagueId,
            int season
    ) {

        Player player =
                response.getPlayer();

        PlayerStatistics statistics = null;

        if (response.getStatistics() != null) {

            for (PlayerStatistics playerStatistics
                    : response.getStatistics()) {

                if (playerStatistics.getLeague() == null) {
                    continue;
                }

                if (playerStatistics.getLeague().getLeagueId() == leagueId
                        && playerStatistics.getLeague().getSeason() == season) {

                    statistics = playerStatistics;
                    break;
                }

            }

        }

        PlayerDetails details =
                new PlayerDetails();

        details.setPlayerId(
                player.getPlayerId()
        );

        details.setDisplayName(

                PlayerDisplayNameFormatter.format(

                        player.getFirstname(),
                        player.getLastname(),
                        player.getName()

                )

        );

        details.setFirstName(
                player.getFirstname()
        );

        details.setLastName(
                player.getLastname()
        );

        if (player.getBirth() != null
                && player.getBirth().getDate() != null) {

            details.setBirthDate(
                    Date.valueOf(
                            player.getBirth().getDate()
                    )
            );

        }

        details.setAge(
                player.getAge()
        );

        details.setHeight(
                player.getHeight()
        );

        details.setWeight(
                player.getWeight()
        );

        details.setNationality(
                player.getNationality()
        );

        details.setPhotoUrl(
                player.getPhotoUrl()
        );

        if (statistics != null) {

            details.setPosition(
                    statistics.getGames().getPosition()
            );

            details.setShirtNumber(
                    statistics.getGames().getNumber()
            );

            details.setCaptain(
                    statistics.getGames().getCaptain()
            );

            details.setStarts(
                    statistics.getGames().getLineups()
            );

            details.setAppearances(
                    statistics.getGames().getAppearances()
            );

            details.setMinutes(
                    statistics.getGames().getMinutes()
            );

            details.setGoals(
                    statistics.getGoals().getTotal()
            );

            details.setAssists(
                    statistics.getGoals().getAssists()
            );

            details.setYellowCards(
                    statistics.getCards().getYellow()
            );

            details.setRedCards(
                    statistics.getCards().getRed()
            );

            details.setRating(
                    statistics.getGames().getRating()
            );

            if (statistics.getTeam() != null) {

                details.setTeamId(
                        statistics.getTeam().getTeamId()
                );

                details.setTeamName(
                        statistics.getTeam().getName()
                );

            }

            if (statistics.getLeague() != null) {

                details.setLeagueId(
                        statistics.getLeague().getLeagueId()
                );

                details.setLeagueName(
                        statistics.getLeague().getName()
                );

            }

            details.setSeason(
                    statistics.getLeague().getSeason()
            );

        }

        System.out.println(
                details.getDisplayName()
        );

        return details;

    }

}