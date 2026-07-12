package org.footballapp.tools;

import org.footballapp.config.AppConfig;
import org.footballapp.service.LeagueImportService;

/**
 * Imports updated data from Database
 */
public class ImportRunner {

    private static final int LEAGUE_ID = 179;
    private static final int SEASON = 2024;

    public static void main(String[] args)

            throws Exception {
        System.out.println(
                "API KEY = " +
                        System.getenv("API_FOOTBALL_KEY")
        );

        AppConfig config =
                new AppConfig();

        LeagueImportService importer =
                config.getLeagueImportService();

        importer.importLeague(
                LEAGUE_ID,
                SEASON
        );

        System.out.println(
                "Import complete."
        );
    }
}