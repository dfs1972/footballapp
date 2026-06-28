package org.footballapp.service;

import org.footballapp.databaserepository.LeagueRepository;
import org.footballapp.model.league.League;

/**
 * Data Flow
 * =========
 *
 * API-Football
 *      ↓
 * Service Layer
 *      ↓
 * Import Services
 *      ↓
 * Repository Layer
 *      ↓
 * PostgreSQL
 *
 * The database becomes the primary source of data
 * for the application, reducing API usage and allowing
 * historical data to be stored locally.
 */

/**
 * Coordinates the import of league-related data.
 *
 * This service acts as the entry point for league imports
 * and delegates work to specialised import services.
 *
 Current responsibilities:
 - Teams
 - Venues
 - League standings
 - Fixtures
 - Team statistics

 Future responsibilities:
 - Players
 - Squads
 - Transfers
 - Injuries
 - Match events
 - Line-ups
 */
public class LeagueImportService {

    //private final LeagueRepository leagueRepository;
    private final TeamImportService teamImportService;
    private final StandingsImportService standingsImportService;
    private final FixtureImportService fixtureImportService;
    private final TeamStatisticsImportService teamStatisticsImportService;

    public LeagueImportService(
            //LeagueRepository leagueRepository,
            TeamImportService teamImportService,
            StandingsImportService standingsImportService,
            FixtureImportService fixtureImportService,
            TeamStatisticsImportService teamStatisticsImportService
    ) {
        //this.leagueRepository = leagueRepository;
        this.teamImportService = teamImportService;
        this.standingsImportService = standingsImportService;
        this.fixtureImportService = fixtureImportService;
        this.teamStatisticsImportService = teamStatisticsImportService;
    }

    /**
     * Imports all available data for a league.
     */
    public void importLeague(
            int leagueId,
            int season
    ) throws Exception {

        League league = new League();

        league.setId(leagueId);
        league.setSeason(season);

        // Temporary hard-coded values.
        // Later these will come from API-Football.
        league.setName("Scottish Premiership");
        league.setCountry("Scotland");

        //leagueRepository.saveLeague(league);

        System.out.println(
                "Importing teams..."
        );

        teamImportService.importLeagueTeams(
                leagueId,
                season
        );

        System.out.println(
                "Importing standings..."
        );

        standingsImportService.importLeagueStandings(
                leagueId,
                season
        );

        System.out.println(
                "Importing fixtures..."
        );

        fixtureImportService.importLeagueFixtures(
                leagueId,
                season
        );

        System.out.println(
                "Importing team statistics..."
        );

        teamStatisticsImportService.importLeagueStatistics(
                leagueId,
                season
        );

        System.out.println(
                "League import complete."
        );
    }
}