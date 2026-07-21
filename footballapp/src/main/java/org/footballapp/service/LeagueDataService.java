package org.footballapp.service;

/**
 * Spring Boot Service
 */
import org.footballapp.api.response.lineups.FixtureLineupMapper;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


/**Import repositories*/
import org.footballapp.repository.FixtureRepository;
import org.footballapp.repository.FixtureLineupRepository;
import org.footballapp.repository.LeagueUkRepository;
import org.footballapp.repository.StandingRepository;
import org.footballapp.repository.TeamRepository;
import org.footballapp.repository.TeamStatisticsRepository;
import org.footballapp.repository.VenueRepository;
import org.footballapp.repository.PlayerStatisticsRepository;
import org.footballapp.repository.PlayerRepository;
import org.footballapp.model.club.ClubDetails;

/**Import models*/
import org.footballapp.model.fixtures.FixtureDetails;
import org.footballapp.model.lineups.FixtureLineup;
import org.footballapp.model.lineups.FixtureLineupPlayer;
import org.footballapp.api.response.lineups.FixtureLineupResponse;
import org.footballapp.api.response.lineups.FixtureTeamLineupResponse;
import org.footballapp.api.response.lineups.PlayerLineupResponse;
import org.footballapp.model.player.Player;
import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.model.league.LeagueUk;
import org.footballapp.model.playerdetails.PlayerSummary;
import org.footballapp.model.teamdetails.TeamDetails;
import org.footballapp.model.teams.Team;
import org.footballapp.model.teams.Venue;
import org.footballapp.model.standings.LeagueTableRow;
import org.footballapp.model.league.LeagueOverview;
import org.footballapp.model.playerdetails.PlayerDetails;
import org.footballapp.model.teamstatistics.TeamStatistics;

@Service
public class LeagueDataService {

    private final LeagueUkRepository leagueUkRepository;
    private final TeamRepository teamRepository;
    private final TeamStatisticsRepository teamStatisticsRepository;
    private final VenueRepository venueRepository;
    private final StandingRepository standingRepository;
    private final FixtureRepository fixtureRepository;
    private final PlayerStatisticsRepository playerStatisticsRepository;
    private final PlayerRepository playerRepository;
    private final FixtureLineupRepository fixtureLineupRepository;
    private final FixtureLineupMapper fixtureLineupMapper;

    /**
     * Contructors
     */
    public LeagueDataService(
            LeagueUkRepository leagueUkRepository,
            TeamRepository teamRepository,
            TeamStatisticsRepository teamStatisticsRepository,
            VenueRepository venueRepository,
            StandingRepository standingRepository,
            FixtureRepository fixtureRepository,
            FixtureLineupRepository fixtureLineupRepository,
            FixtureLineupMapper fixtureLineupMapper,
            PlayerStatisticsRepository playerStatisticsRepository,
            PlayerRepository playerRepository
    ) {
        this.leagueUkRepository = leagueUkRepository;
        this.teamRepository = teamRepository;
        this.teamStatisticsRepository = teamStatisticsRepository;
        this.venueRepository = venueRepository;
        this.standingRepository = standingRepository;
        this.fixtureRepository = fixtureRepository;
        this.fixtureLineupRepository = fixtureLineupRepository;
        this.playerStatisticsRepository = playerStatisticsRepository;
        this.playerRepository = playerRepository;
        this.fixtureLineupMapper = fixtureLineupMapper;
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
     * Get team lineup from a game
     */
    public List<PlayerSummary> getPlayersForTeam(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        return playerStatisticsRepository
                .getPlayersForTeam(
                        teamId,
                        leagueId,
                        season
                );
    }

    /**
     * Returns detailed information for a player.
     */
    public PlayerDetails getPlayerDetails(
            int playerId,
            int leagueId,
            int season
    ) throws Exception {

        return playerRepository.getPlayerDetails(
                playerId,
                leagueId,
                season
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
     * Retrieves details for a single club.
     */
    public ClubDetails getClubDetails(
            int clubId
    ) throws Exception {

        return teamRepository.getClubDetails(
                clubId
        );

    }

    /**
     *  Get Fixtures for that season.
     */
    public List<FixtureRow> getFixtures(
            int leagueId,
            int season
    ) throws Exception {

        return fixtureRepository.getFixtures(
                leagueId,
                season
        );
    }

    /**
     * Get Fixture Details
     */

    public FixtureDetails getFixtureDetails(
            long fixtureId
    ) throws Exception {

        return fixtureRepository.getFixtureDetails(
                fixtureId
        );

    }

    /**
     * Retrieves the lineups for a fixture.
     */
    public List<FixtureLineup> getFixtureLineups(

            long fixtureId

    ) throws Exception {

        return fixtureLineupRepository.getFixtureLineups(
                fixtureId
        );

    }

    /**
     * Retrieves the players for a team's lineup.
     */
    public List<FixtureLineupPlayer> getFixtureLineupPlayers(

            long fixtureId,

            int teamId

    ) throws Exception {

        return fixtureLineupRepository.getFixtureLineupPlayers(

                fixtureId,

                teamId

        );

    }

    /**
     * Retrieves the complete lineup for a fixture.
     */
    public FixtureLineupResponse getFixtureLineupResponse(

            long fixtureId

    ) throws Exception {

        FixtureLineupResponse response =
                fixtureLineupMapper.createResponse(
                        fixtureId
                );

        List<FixtureLineup> lineups =
                fixtureLineupRepository.getFixtureLineups(
                        fixtureId
                );

        for (FixtureLineup lineup : lineups) {

            Team team =
                    teamRepository.getTeamById(
                            lineup.getTeamId()
                    );

            List<FixtureLineupPlayer> lineupPlayers =
                    fixtureLineupRepository.getFixtureLineupPlayers(

                            fixtureId,

                            lineup.getTeamId()

                    );

            List<PlayerLineupResponse> playerResponses =
                    new ArrayList<>();

            for (FixtureLineupPlayer lineupPlayer : lineupPlayers) {

                Player player =
                        playerRepository.getPlayerById(

                                lineupPlayer.getPlayerId()

                        );

                String playerName = "";
                String photo = "";

                if (player != null) {

                    playerName =
                            player.getName();

                    photo =
                            player.getPhotoUrl();

                }

                PlayerLineupResponse playerResponse =
                        fixtureLineupMapper.mapPlayer(

                                lineupPlayer,

                                playerName

                        );

                playerResponse.setPhoto(
                        photo
                );

                playerResponses.add(
                        playerResponse
                );

            }

            FixtureTeamLineupResponse teamResponse =
                    fixtureLineupMapper.mapTeamLineup(

                            lineup,

                            team,

                            playerResponses

                    );

            response.getTeams().add(
                    teamResponse
            );

        }

        return response;

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
     * Get a team's stats
     */
    public TeamStatistics getTeamStatistics(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        return teamStatisticsRepository
                .getTeamStatistics(
                        teamId,
                        leagueId,
                        season
                );
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





















