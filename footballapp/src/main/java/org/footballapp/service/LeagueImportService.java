package org.footballapp.service;

import org.footballapp.service.FixtureImportService;
import org.footballapp.service.StandingsImportService;
import org.footballapp.service.TeamImportService;

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
/*************************************************************************
/**
 * Coordinates the import of league-related data.
 *
 * This service acts as the entry point for league imports
 * and delegates work to specialised import services.
 *
 * Future responsibilities:
 * - Teams
 * - Venues
 * - Standings
 * - Fixtures
 */
public class LeagueImportService {

    private final TeamImportService teamImportService;
    private final StandingsImportService standingsImportService;
    private final FixtureImportService fixtureImportService;

    public LeagueImportService(
            TeamImportService teamImportService,
            StandingsImportService standingsImportService,
            FixtureImportService fixtureImportService
    ) {
        this.teamImportService = teamImportService;
        this.standingsImportService = standingsImportService;
        this.fixtureImportService = fixtureImportService;
    }

    /**
     * Imports all available data for a league.
     *
     * Currently imports teams and venues only.
     */
    public void importLeague()
            throws Exception {

        teamImportService.importLeagueTeams();

        // standingsImportService.importLeagueStandings(
        //        leagueId, season);

        // fixtureImportService.importLeagueFixtures(
        //        leagueId, season);
    }
}