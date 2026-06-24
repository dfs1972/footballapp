package org.footballapp.config;

import org.footballapp.api.ApiFootballClient;
import org.footballapp.api.ApiFootballService;
import org.footballapp.databaserepository.*;
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
    private final VenueRepository venueRepository;
    //private final LeagueRepository leagueRepository;
    private final LeagueTeamRepository leagueTeamRepository;
    private final StandingRepository standingRepository;
    private final FixtureRepository fixtureRepository;

    private final TeamImportService teamImportService;
    private final StandingsImportService standingsImportService;
    private final FixtureImportService fixtureImportService;

    private final LeagueImportService leagueImportService;
    private final LeagueUkImportService leagueUkImportService;
    private final LeagueDataService leagueDataService;

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
        leagueUkRepository =
                new LeagueUkRepository();

        teamRepository =
                new TeamRepository();

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
        teamImportService =
                new TeamImportService(
                        apiFootballService,
                        teamRepository,
                        venueRepository,
                        leagueTeamRepository
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
                        fixtureImportService
                );

        /**
         * Application Services
         */
        leagueDataService =
                new LeagueDataService(
                        leagueUkRepository,
                        teamRepository,
                        standingRepository,
                        fixtureRepository
                );
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

}// End of AppConfig Class.