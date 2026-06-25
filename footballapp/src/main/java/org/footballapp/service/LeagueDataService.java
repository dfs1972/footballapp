package org.footballapp.service;

/**Import repositories*/
import org.footballapp.databaserepository.FixtureRepository;
import org.footballapp.databaserepository.LeagueUkRepository;
import org.footballapp.databaserepository.StandingRepository;
import org.footballapp.databaserepository.TeamRepository;
import org.footballapp.databaserepository.VenueRepository;

/**Import models*/
import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.model.fixtures.FixtureTeam;
import org.footballapp.model.league.LeagueUk;
import org.footballapp.model.standings.Standing;
import org.footballapp.model.teamdetails.TeamDetails;
import org.footballapp.model.teams.Team;
import org.footballapp.model.teams.Venue;
import org.footballapp.model.standings.LeagueTableRow;
import org.footballapp.model.league.LeagueOverview;

import java.util.List;

public class LeagueDataService {

    private final LeagueUkRepository leagueUkRepository;
    private final TeamRepository teamRepository;
    private final VenueRepository venueRepository;
    private final StandingRepository standingRepository;
    private final FixtureRepository fixtureRepository;

    /**
     * Contructors
     */
    public LeagueDataService(
            LeagueUkRepository leagueUkRepository,
            TeamRepository teamRepository,
            VenueRepository venueRepository,
            StandingRepository standingRepository,
            FixtureRepository fixtureRepository
    ) {
        this.leagueUkRepository = leagueUkRepository;
        this.teamRepository = teamRepository;
        this.venueRepository = venueRepository;
        this.standingRepository = standingRepository;
        this.fixtureRepository = fixtureRepository;
    }

    /**
     * Get Leagues
     */
    public List<LeagueUk> getLeagues()
            throws Exception {

        return leagueUkRepository
                .getLeagues();
    }

    /**
     * Get Enabled Leagues
     */
    public List<LeagueUk> getEnabledLeagues()
            throws Exception {

        return leagueUkRepository
                .getEnabledLeagues();
    }

    /**
     *  Get team by ID method
     */
    public Team getTeam(
            int teamId
    ) throws Exception {

        return teamRepository.getTeamById(
                teamId
        );
    }
    /**
     * Get league table by season
     */
    public List<LeagueTableRow> getLeagueTable(
            int leagueId,
            int season
    ) throws Exception {

        return standingRepository.getLeagueTable(
                leagueId,
                season
        );
    }
    /**
     *  Get a particular team's fixtures for that season.
     */
    public List<FixtureRow> getLeagueFixtures(
            int leagueId,
            int season
    ) throws Exception {

        return fixtureRepository.getLeagueFixtures(
                leagueId,
                season
        );
    }
    /** Get a list of all teams playing in a particular league in that season. */
    public List<Team> getTeamsForLeague(
            int leagueId,
            int season
    ) throws Exception {

        return teamRepository.getTeamsForLeague(
                leagueId,
                season
        );
    }
    /**
     * Get a list of a team's fixtures for a season.
     */
    public List<FixtureRow> getFixturesByTeam(
            int teamId
    ) throws Exception {

        return fixtureRepository.getFixturesByTeam(teamId);
    }
    /**
     * Get a list of a team's recent results.
     */
    public List<FixtureRow> getRecentResults(
            int leagueId,
            int season,
            int limit
    ) throws Exception {

        return fixtureRepository.getRecentResults(
                leagueId,
                season,
                limit
        );
    }
    /**
     * Get team's form from last 5 matches.
     */
    public String getTeamForm(
            int teamId
    ) throws Exception {

        List<FixtureRow> fixtures =
                fixtureRepository
                        .getRecentFixturesByTeam(
                                teamId,
                                5
                        );

        StringBuilder form =
                new StringBuilder();

        for (FixtureRow fixture : fixtures) {

            boolean homeTeam =
                    fixture.getHomeTeamId()
                            == teamId;

            int goalsFor =
                    homeTeam
                            ? fixture.getHomeGoals()
                            : fixture.getAwayGoals();

            int goalsAgainst =
                    homeTeam
                            ? fixture.getAwayGoals()
                            : fixture.getHomeGoals();

            if (goalsFor > goalsAgainst) {

                form.append("W");

            } else if (goalsFor < goalsAgainst) {

                form.append("L");

            } else {

                form.append("D");
            }
        }

        return form.toString();
    }

    /**
     * Returns a team's league standing
     */
    public TeamDetails getTeamDetails(
            int leagueId,
            int season,
            int teamId
    )
            throws Exception {

        TeamDetails details =
                new TeamDetails();

        Team team =
                teamRepository.getTeamById(
                        teamId
                );

        details.setTeam(team);

        Venue venue =
                venueRepository.getVenueForTeam(
                        leagueId,
                        season,
                        teamId
                );

        details.setVenue(venue);

        System.out.println(
                "leagueId=" + leagueId +
                        ", season=" + season +
                        ", teamId=" + teamId
        );

        LeagueTableRow standing =
                standingRepository
                        .getTeamStanding(
                                leagueId,
                                season,
                                teamId
                        );

        details.setLeaguePosition(
                standing.getPosition()
        );

        details.setPoints(
                standing.getPoints()
        );

        details.setForm(
                getTeamForm(teamId)
        );

        details.setRecentFixtures(
                fixtureRepository
                        .getRecentFixturesByTeam(
                                teamId,
                                5
                        )
        );

        return details;
    }

    /**
     *  Get a single fixture from league.
     */
    public FixtureRow getFixtureDetails(
            long fixtureId
    ) throws Exception {

        return fixtureRepository
                .getFixtureDetails(
                        fixtureId
                );
    } // End of getFixturesDetails

    /**
     * Get League Overview
     */
    public LeagueOverview getLeagueOverview(
            int leagueId,
            int season
    ) throws Exception {

        LeagueOverview overview =
                new LeagueOverview();

        LeagueUk league =
                leagueUkRepository
                        .getLeagueById(
                                leagueId
                        );

        overview.setLeagueId(
                leagueId
        );

        overview.setLeagueName(
                league.getName()
        );

        overview.setSeason(
                season
        );

        overview.setTeamCount(
                teamRepository
                        .getTeamsForLeague(
                                leagueId,
                                season
                        )
                        .size()
        );

        overview.setFixtureCount(
                fixtureRepository
                        .getLeagueFixtures(
                                leagueId,
                                season
                        )
                        .size()
        );

        return overview;
    } // End of getLeagueOverview()
}





















