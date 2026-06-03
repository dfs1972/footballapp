package org.footballapp;

import org.footballapp.api.ApiFootballClient;
import org.footballapp.databaserepository.LeagueRepository;
import org.footballapp.databaserepository.TeamRepository;
import org.footballapp.databaserepository.VenueRepository;
import org.footballapp.service.LeagueImportService;
import org.footballapp.service.TeamImportService;
import org.footballapp.service.TeamService;

/**
 * Application entry point.
 *
 * Current workflow:
 *
 * API-Football
 *      ↓
 * TeamService
 *      ↓
 * TeamImportService
 *      ↓
 * Repositories
 *      ↓
 * PostgreSQL
 *
 * Future workflow:
 *
 * LeagueImportService
 *      ├── TeamImportService
 *      ├── StandingsImportService
 *      └── FixtureImportService
 */

public class Main {

    public static void main(String[] args) {

        try {

            String apiKey =
                    System.getenv("API_FOOTBALL_KEY");

            ApiFootballClient client =
                    new ApiFootballClient(apiKey);

            TeamService teamService =
                    new TeamService(client);

            TeamRepository teamRepository =
                    new TeamRepository();

            VenueRepository venueRepository =
                    new VenueRepository();

            LeagueRepository leagueRepository =
                    new LeagueRepository();

            TeamImportService teamImportService =
                    new TeamImportService(
                            teamService,
                            teamRepository,
                            venueRepository
                    );

            LeagueImportService leagueImportService =
                    new LeagueImportService(
                            leagueRepository,
                            teamImportService
                    );

            leagueImportService.importLeague(
                    179,
                    2024
            );

            System.out.println(
                    "Scottish Premiership 2024 imported successfully."
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}