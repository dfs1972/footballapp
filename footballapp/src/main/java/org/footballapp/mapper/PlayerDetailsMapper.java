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
        PlayerStatistics fallbackStatistics = null;

        if (response.getStatistics() != null) {

            for (PlayerStatistics playerStatistics
                    : response.getStatistics()) {

                if (playerStatistics == null) {
                    continue;
                }

                /*
                 * Keep the first available statistics record as a fallback.
                 *
                 * This can provide useful squad information such as
                 * position and shirt number even when the requested
                 * league has no statistics for this player.
                 */
                if (fallbackStatistics == null) {
                    fallbackStatistics = playerStatistics;
                }

                /*
                 * Prefer statistics belonging to the requested
                 * league and season.
                 */
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

        /*
         * Use the requested league statistics when available.
         *
         * If they are not available, use a fallback statistics
         * record only for player/squad information such as
         * position, shirt number and club.
         */
        PlayerStatistics squadStatistics =
                statistics != null
                        ? statistics
                        : fallbackStatistics;

        if (squadStatistics != null) {

            /*
             * Squad/player information.
             *
             * These values can still be useful when the player
             * has no statistics for the requested league.
             */
            if (squadStatistics.getGames() != null) {

                details.setPosition(
                        squadStatistics.getGames().getPosition()
                );

                details.setShirtNumber(
                        squadStatistics.getGames().getNumber()
                );

                details.setCaptain(
                        squadStatistics.getGames().getCaptain()
                );
            }

            /*
             * Team information.
             */
            if (squadStatistics.getTeam() != null) {

                details.setTeamId(
                        squadStatistics.getTeam().getTeamId()
                );

                details.setTeamName(
                        squadStatistics.getTeam().getName()
                );
            }
        }

        /*
         * Only populate statistics when they actually belong
         * to the requested league and season.
         *
         * Otherwise these remain null and Android displays N/A.
         */
        if (statistics != null) {

            if (statistics.getGames() != null) {

                details.setStarts(
                        statistics.getGames().getLineups()
                );

                details.setAppearances(
                        statistics.getGames().getAppearances()
                );

                details.setMinutes(
                        statistics.getGames().getMinutes()
                );

                details.setRating(
                        statistics.getGames().getRating()
                );
            }

            if (statistics.getGoals() != null) {

                details.setGoals(
                        statistics.getGoals().getTotal()
                );

                details.setAssists(
                        statistics.getGoals().getAssists()
                );
            }

            if (statistics.getCards() != null) {

                details.setYellowCards(
                        statistics.getCards().getYellow()
                );

                details.setRedCards(
                        statistics.getCards().getRed()
                );
            }

            if (statistics.getLeague() != null) {

                details.setLeagueId(
                        statistics.getLeague().getLeagueId()
                );

                details.setLeagueName(
                        statistics.getLeague().getName()
                );

                details.setSeason(
                        statistics.getLeague().getSeason()
                );
            }
        }

        System.out.println(
                details.getDisplayName()
        );

        return details;

    }

}