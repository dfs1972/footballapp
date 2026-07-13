package org.footballapp.service;

import org.springframework.stereotype.Service;
import org.footballapp.api.ApiFootballService;
import org.footballapp.databaserepository.PlayerRepository;
import org.footballapp.databaserepository.PlayerStatisticsRepository;
import org.footballapp.model.player.Player;
import org.footballapp.model.player.PlayerResponse;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.playerstatistics.PlayerStatistics;

/**
 * Imports player identity information from API-Football.
 *
 * Phase 1 imports player identity only.
 * Season statistics will be imported separately.
 */
@Service
public class PlayerImportService {

    private final ApiFootballService apiFootballService;
    private final PlayerRepository playerRepository;
    private final PlayerStatisticsRepository playerStatisticsRepository;

    public PlayerImportService(
            ApiFootballService apiFootballService,
            PlayerRepository playerRepository,
            PlayerStatisticsRepository playerStatisticsRepository
    ) {

        this.apiFootballService =
                apiFootballService;

        this.playerRepository =
                playerRepository;

        this.playerStatisticsRepository =
                playerStatisticsRepository;
    }

    /**
     * Imports all players for a team and season.
     */
    public void importPlayers(
            int teamId,
            int season
    ) throws Exception {

        int page = 1;
        int imported = 0;

        while (true) {

            PlayersApiResponse response =
                    apiFootballService.getPlayers(
                            teamId,
                            season
                    );

            for (PlayerResponse playerResponse
                    : response.getResponse()) {

                Player player =
                        playerResponse.getPlayer();

                playerRepository.savePlayer(
                        player
                );

                if (playerResponse.getStatistics() != null) {

                    for (PlayerStatistics statistics
                            : playerResponse.getStatistics()) {

                        playerStatisticsRepository
                                .savePlayerStatistics(

                                        player.getPlayerId(),

                                        season,

                                        statistics
                                );
                    }
                }

                imported++;

                System.out.println(
                        "Page " + page +
                                " - " +
                                player.getPlayerId() +
                                " - " +
                                player.getName()
                );

//                System.out.println(
//                        "Saved player "
//                                + player.getPlayerId()
//                                + " : "
//                                + player.getName()
//                );
            }

            if (page >= response
                    .getPaging()
                    .getTotal()) {

                break;
            }

            page++;
        }

        System.out.println();

//        System.out.println(
//                "Imported "
//                        + imported
//                        + " players."
//        );
    }
}