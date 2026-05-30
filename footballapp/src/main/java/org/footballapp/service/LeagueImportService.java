package org.footballapp.service;

import org.footballapp.databaserepository.VenueRepository;
import org.footballapp.model.teams.TeamResponse;
import org.footballapp.model.teams.TeamsApiResponse;
import org.footballapp.databaserepository.TeamRepository;

public class LeagueImportService {

    private final TeamService teamService;
    private final TeamRepository teamRepository;
    private final VenueRepository venueRepository;

    public LeagueImportService(
            TeamService teamService,
            TeamRepository teamRepository,
            VenueRepository venueRepository
    ) {
        this.teamService = teamService;
        this.teamRepository = teamRepository;
        this.venueRepository = venueRepository;
    }

    public void importScottishPremiership2024() throws Exception {

        TeamsApiResponse response =
                teamService.getScottishPremiershipTeams();

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