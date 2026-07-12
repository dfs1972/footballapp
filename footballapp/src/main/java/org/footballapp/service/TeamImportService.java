package org.footballapp.service;

//import org.footballapp.databaserepository.LeagueRepository;
import org.springframework.stereotype.Service;
import org.footballapp.api.ApiFootballService;
import org.footballapp.databaserepository.LeagueTeamRepository;
import org.footballapp.databaserepository.TeamRepository;
import org.footballapp.databaserepository.VenueRepository;
import org.footballapp.model.teams.TeamResponse;
import org.footballapp.model.teams.TeamsApiResponse;

/**
 * Imports team and venue data from API-Football
 * into the PostgreSQL database.
 *
 * Uses TeamService to retrieve data and repositories
 * to persist it in footballapp_db.
 */
@Service
public class TeamImportService {

    private final ApiFootballService apiService;
    //private final TeamService teamService;
    private final TeamRepository teamRepository;
    private final VenueRepository venueRepository;
    private final LeagueTeamRepository
            leagueTeamRepository;

    public TeamImportService(
            ApiFootballService apiService,
            //TeamService teamService,
            TeamRepository teamRepository,
            VenueRepository venueRepository,
            LeagueTeamRepository leagueTeamRepository
    ) {
        this.apiService = apiService;
        //this.teamService = teamService;
        this.teamRepository = teamRepository;
        this.venueRepository = venueRepository;
        this.leagueTeamRepository =
                leagueTeamRepository;
    }

    public void importLeagueTeams(
            int leagueId,
            int season
    ) throws Exception {

        TeamsApiResponse response =
                apiService.getLeagueTeams(
                        leagueId,
                        season
                );

        for (TeamResponse teamResponse : response.getResponse()) {

            teamResponse.getTeam().setVenueId(

                    teamResponse
                            .getVenue()
                            .getId()

            );

            teamRepository.saveTeam(
                    teamResponse.getTeam()
            );

            venueRepository.saveVenue(
                    teamResponse.getVenue()
            );

            leagueTeamRepository.saveLeagueTeam(
                    leagueId,
                    season,
                    teamResponse.getTeam().getId()
            );
        }
    }
}