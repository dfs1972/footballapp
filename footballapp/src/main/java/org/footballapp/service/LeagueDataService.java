package org.footballapp.service;

/**Import repositories*/
import org.footballapp.databaserepository.FixtureRepository;
import org.footballapp.databaserepository.StandingRepository;
import org.footballapp.databaserepository.TeamRepository;

/**Import models*/
import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.model.standings.Standing;
import org.footballapp.model.teams.Team;
import org.footballapp.model.standings.LeagueTableRow;

import java.util.List;

public class LeagueDataService {

    private final TeamRepository teamRepository;
    private final StandingRepository standingRepository;
    private final FixtureRepository fixtureRepository;

    public LeagueDataService(
            TeamRepository teamRepository,
            StandingRepository standingRepository,
            FixtureRepository fixtureRepository
    ) {
        this.teamRepository = teamRepository;
        this.standingRepository = standingRepository;
        this.fixtureRepository = fixtureRepository;
    }

    /** Get team by ID method*/
    public Team getTeam(
            int teamId
    ) throws Exception {

        return teamRepository.getTeamById(
                teamId
        );
    }
    /** Get league table by season */
    public List<LeagueTableRow> getLeagueTable(
            int leagueId,
            int season
    ) throws Exception {

        return standingRepository.getLeagueTable(
                leagueId,
                season
        );
    }
    /** Get a particular team's fixtures for that season. */
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
    /** Get a list of a team's fixtures for a season. */
    public List<FixtureRow> getFixturesByTeam(
            int teamId
    ) throws Exception {

        return fixtureRepository.getFixturesByTeam(teamId);
    }
    /** Get a list of a team's recent results. */
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
    /** Get team's form from last 5 matches. */
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
}





















