package org.footballapp;

import org.footballapp.api.ApiFootballClient;
import org.footballapp.databaserepository.TeamRepository;
import org.footballapp.databaserepository.VenueRepository;
import org.footballapp.model.teams.Team;
import org.footballapp.model.teams.TeamResponse;
import org.footballapp.model.teams.TeamsApiResponse;
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

        //leagueImportService.importLeague();

        try {
            String apiKey = System.getenv("API_FOOTBALL_KEY");

            ApiFootballClient client =
                    new ApiFootballClient(apiKey);

            TeamService service =
                    new TeamService(client);

            TeamRepository repository =
                    new TeamRepository();

            VenueRepository vRepository =
                    new VenueRepository();

            TeamsApiResponse response =
                    service.getScottishPremiershipTeams();

            for (TeamResponse teamResponse : response.getResponse()) {

                repository.saveTeam(teamResponse.getTeam());

                vRepository.saveVenue(teamResponse.getVenue());


                System.out.println(
                        teamResponse.getTeam().getName() + " - " + teamResponse.getTeam().getCountry()
                                + " - " + teamResponse.getTeam().getFounded()
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }// End of main.
}// End of Main Class.