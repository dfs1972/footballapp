package org.footballapp;

import org.footballapp.api.ApiFootballClient;
import org.footballapp.databaserepository.TeamRepository;
import org.footballapp.databaserepository.VenueRepository;
import org.footballapp.model.teams.TeamResponse;
import org.footballapp.model.teams.TeamsApiResponse;
import org.footballapp.service.TeamService;

public class Main {

    public static void main(String[] args) {

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
                        teamResponse.getTeam().getName()
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}