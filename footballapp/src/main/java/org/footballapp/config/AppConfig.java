package org.footballapp.config;

import org.footballapp.api.ApiFootballClient;
import org.footballapp.api.ApiFootballService;
import org.footballapp.databaserepository.*;
import org.footballapp.model.teamstatistics.TeamStatistics;
import org.footballapp.service.*;

public class AppConfig {

    /**
     * External API access
     */
    private final ApiFootballClient apiClient;
    private final ApiFootballService apiFootballService;

    /**
     * Database repositories
     */
    private final LeagueUkRepository leagueUkRepository;
    private final TeamRepository teamRepository;
    private final TeamStatisticsRepository teamStatisticsRepository;
    private final VenueRepository venueRepository;
    //private final LeagueRepository leagueRepository;
    private final LeagueTeamRepository leagueTeamRepository;
    private final StandingRepository standingRepository;
    private final FixtureRepository fixtureRepository;

    private final TeamStatisticsImportService teamStatisticsImportService;
    private final TeamImportService teamImportService;
    private final StandingsImportService standingsImportService;
    private final FixtureImportService fixtureImportService;

    private final LeagueImportService leagueImportService;
    private final LeagueUkImportService leagueUkImportService;
    private final LeagueDataService leagueDataService;

    private final PlayerRepository playerRepository;
    private final PlayerImportService playerImportService;
    private final PlayerStatisticsRepository playerStatisticsRepository;

    public AppConfig() {

        /**
         * API Layer
         */
        String apiKey =
                System.getenv("API_FOOTBALL_KEY");

        apiClient =
                new ApiFootballClient(apiKey);

        apiFootballService =
                new ApiFootballService(apiClient);

        /**
         * Repository Layer
         */

        playerRepository =
                new PlayerRepository();

        playerStatisticsRepository =
                new PlayerStatisticsRepository();

        leagueUkRepository =
                new LeagueUkRepository();

        teamRepository =
                new TeamRepository();

        teamStatisticsRepository =
                new TeamStatisticsRepository();

        venueRepository =
                new VenueRepository();

//        leagueRepository =
//                new LeagueRepository();

        leagueTeamRepository =
                new LeagueTeamRepository();

        standingRepository =
                new StandingRepository();

        fixtureRepository =
                new FixtureRepository();

        /**
         * Import Layer
         */

        playerImportService =
                new PlayerImportService(
                        apiFootballService,
                        playerRepository,
                        playerStatisticsRepository
                );

        teamImportService =
                new TeamImportService(
                        apiFootballService,
                        teamRepository,
                        venueRepository,
                        leagueTeamRepository
                );

        teamStatisticsImportService =
                new TeamStatisticsImportService(
                        apiFootballService,
                        teamStatisticsRepository,
                        standingRepository
                );

        standingsImportService =
                new StandingsImportService(
                        apiFootballService,
                        standingRepository
                );

        fixtureImportService =
                new FixtureImportService(
                        apiFootballService,
                        fixtureRepository
                );

        leagueUkImportService =
                new LeagueUkImportService(
                        apiFootballService,
                        leagueUkRepository
                );

        leagueImportService =
                new LeagueImportService(
                        teamImportService,
                        standingsImportService,
                        fixtureImportService,
                        teamStatisticsImportService
                );

        /**
         * Application Services
         */
        leagueDataService =
                new LeagueDataService(
                        leagueUkRepository,
                        teamRepository,
                        teamStatisticsRepository,
                        venueRepository,
                        standingRepository,
                        fixtureRepository,
                        playerStatisticsRepository,
                        playerRepository
                );
    }

    public TeamStatisticsImportService getTeamStatisticsImportService() {
        return teamStatisticsImportService;
    }
    public ApiFootballService getApiFootballService() {return apiFootballService;}

    public LeagueUkImportService getLeagueUkImportService() {return leagueUkImportService;}

    public LeagueImportService getLeagueImportService() {
        return leagueImportService;
    }

    public LeagueDataService getLeagueDataService() {
        return leagueDataService;
    }

    public StandingsImportService getStandingsImportService() {return standingsImportService;}

    public PlayerImportService getPlayerImportService() {return playerImportService;}

}// End of AppConfig Class.
