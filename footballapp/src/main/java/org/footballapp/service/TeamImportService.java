package org.footballapp.service;

//import org.footballapp.databaserepository.LeagueRepository;
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
public class TeamImportService {

    private final TeamService teamService;
    private final TeamRepository teamRepository;
    private final VenueRepository venueRepository;

    public TeamImportService(
            TeamService teamService,
            TeamRepository teamRepository,
            VenueRepository venueRepository
            //LeagueRepository leagueRepository
    ) {
        this.teamService = teamService;
        this.teamRepository = teamRepository;
        this.venueRepository = venueRepository;
    }

    /**
     * Imports all teams and venues returned by the
     * Scottish Premiership API endpoint.
     */
    public void importLeagueTeams(
            int leagueId,
            int season
    ) throws Exception {

        TeamsApiResponse response =
                teamService.getLeagueTeams(
                        leagueId,
                        season
                );

        for (TeamResponse teamResponse : response.getResponse()) {

            teamRepository.saveTeam(
                    teamResponse.getTeam()
            );

            venueRepository.saveVenue(
                    teamResponse.getVenue()
            );
        }
    }
}