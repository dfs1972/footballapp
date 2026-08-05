package org.footballapp.service;

/**
 * Spring Boot Service
 */
import org.footballapp.api.response.lineups.FixtureLineupMapper;
import org.footballapp.mapper.PlayerDetailsMapper;
import org.footballapp.mapper.PlayerMapper;
import org.footballapp.model.fixtures.FixtureResponse;
import org.footballapp.model.fixtures.FixturesApiResponse;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.standings.Standing;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.model.teams.TeamResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


/**Import repositories*/
import org.footballapp.repository.FixtureRepository;
import org.footballapp.repository.FixtureLineupRepository;
import org.footballapp.repository.StandingRepository;
import org.footballapp.repository.TeamRepository;
import org.footballapp.repository.TeamStatisticsRepository;
import org.footballapp.repository.VenueRepository;
//import org.footballapp.repository.PlayerStatisticsRepository;
import org.footballapp.repository.PlayerRepository;
import org.footballapp.model.club.ClubDetails;

/**Import models*/
import org.footballapp.model.fixtures.FixtureDetails;
import org.footballapp.model.lineups.FixtureLineup;
import org.footballapp.model.lineups.FixtureLineupPlayer;
import org.footballapp.api.response.lineups.FixtureLineupResponse;
import org.footballapp.api.response.lineups.FixtureTeamLineupResponse;
import org.footballapp.service.FixtureService;
import org.footballapp.api.response.lineups.PlayerLineupResponse;
import org.footballapp.model.player.Player;
import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.model.playerdetails.PlayerSummary;
import org.footballapp.model.teamdetails.TeamDetails;
import org.footballapp.model.teams.Team;
import org.footballapp.model.standings.LeagueTableRow;
import org.footballapp.model.league.LeagueOverview;
import org.footballapp.model.playerdetails.PlayerDetails;
import org.footballapp.model.teamstatistics.TeamStatistics;

@Service
public class LeagueDataService {

    private final TeamRepository teamRepository;
    private final TeamStatisticsRepository teamStatisticsRepository;
    private final VenueRepository venueRepository;
    private final StandingRepository standingRepository;
    private final FixtureRepository fixtureRepository;
    //private final PlayerStatisticsRepository playerStatisticsRepository;
    private final PlayerRepository playerRepository;
    private final FixtureLineupRepository fixtureLineupRepository;
    private final FixtureLineupMapper fixtureLineupMapper;
    private final FootballDataProvider  fixtureService;
    private final FootballDataProvider  footballDataProvider;
    private final SupportedCompetitionsService supportedCompetitionsService;
    private final StandingService standingService;
    private final TeamService teamService;
    private final PlayerMapper playerMapper;
    private final PlayerDetailsMapper playerDetailsMapper;

    /**
     * Contructors
     */
    public LeagueDataService(
            TeamRepository teamRepository,
            TeamService teamService,
            TeamStatisticsRepository teamStatisticsRepository,
            VenueRepository venueRepository,
            StandingRepository standingRepository,
            StandingService standingService,
            FixtureRepository fixtureRepository,
            FixtureLineupRepository fixtureLineupRepository,
            FixtureLineupMapper fixtureLineupMapper,
            FootballDataProvider  fixtureService,
            //PlayerStatisticsRepository playerStatisticsRepository,
            PlayerRepository playerRepository,
            SupportedCompetitionsService supportedCompetitionsService,
            FootballDataProvider footballDataProvider,
            PlayerMapper playerMapper,
            PlayerDetailsMapper playerDetailsMapper
    ) {
        this.teamRepository = teamRepository;
        this.teamService = teamService;
        this.teamStatisticsRepository = teamStatisticsRepository;
        this.venueRepository = venueRepository;
        this.standingRepository = standingRepository;
        this.standingService = standingService;
        this.fixtureRepository = fixtureRepository;
        this.fixtureService  = fixtureService;
        this.fixtureLineupRepository = fixtureLineupRepository;
        //this.playerStatisticsRepository = playerStatisticsRepository;
        this.playerRepository = playerRepository;
        this.fixtureLineupMapper = fixtureLineupMapper;
        this.supportedCompetitionsService = supportedCompetitionsService;
        this.footballDataProvider = footballDataProvider;
        this.playerMapper = playerMapper;
        this.playerDetailsMapper = playerDetailsMapper;
    }

    /**
     *  Get team by ID method
     */

    public Team getTeam(
            int teamId
    ) throws Exception {

        return teamService
                .getTeam(teamId)
                .getTeam();
    }

    /**
     * Get team lineup from a game
     */

    public List<PlayerSummary> getPlayersForTeam(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        return playerMapper.toPlayerSummaries(

                footballDataProvider.getTeamPlayers(

                        teamId,
                        leagueId,
                        season

                )

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

        PlayersApiResponse response =
                footballDataProvider.getPlayer(
                        playerId,
                        season
                );

        System.out.println(
                response.getResponse().size()
        );

        return playerDetailsMapper.toPlayerDetails(
                response
        );

//        return playerDetailsMapper.toPlayerDetails(
//
//                footballDataProvider.getPlayer(
//
//                        playerId,
//                        season
//
//                )
//
//        );

    }

    /**
     * Get league table by season
     */

    public List<LeagueTableRow> getLeagueTable(
            int leagueId,
            int season
    ) throws Exception {

        List<LeagueTableRow> table =
                new ArrayList<>();

        for (Standing standing :
                standingService.getLeagueStandings(
                        leagueId,
                        season
                )) {

            LeagueTableRow row =
                    new LeagueTableRow();

            row.setPosition(
                    standing.getRank()
            );

            row.setTeamId(
                    standing.getTeam().getId()
            );

            row.setTeamName(
                    standing.getTeam().getName()
            );

            row.setPlayed(
                    standing.getAll().getPlayed()
            );

            row.setWins(
                    standing.getAll().getWin()
            );

            row.setDraws(
                    standing.getAll().getDraw()
            );

            row.setLosses(
                    standing.getAll().getLose()
            );

            row.setGoalDifference(
                    standing.getGoalsDiff()
            );

            row.setPoints(
                    standing.getPoints()
            );

            table.add(row);

        }

        return table;
    }

    /**
     * Retrieves details for a single club.
     */
    public ClubDetails getClubDetails(
            int clubId
    ) throws Exception {

        TeamResponse response =
                teamService.getTeam(clubId);

        ClubDetails club =
                new ClubDetails();

        club.setClubId(
                response.getTeam().getId()
        );

        club.setName(
                response.getTeam().getName()
        );

        club.setCountry(
                response.getTeam().getCountry()
        );

        club.setFounded(
                response.getTeam().getFounded()
        );

        club.setStadium(
                response.getVenue().getName()
        );

        club.setCity(
                response.getVenue().getCity()
        );

        club.setCapacity(
                response.getVenue().getCapacity()
        );

        return club;
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

        FixturesApiResponse fixtures =
                fixtureService.getRecentTeamFixtures(
                        teamId,
                        5
                );

        StringBuilder form =
                new StringBuilder();

        for (FixtureResponse fixture : fixtures.getResponse()) {

            boolean homeTeam =
                    fixture.getTeams()
                            .getHome()
                            .getId() == teamId;

            Integer homeGoals =
                    fixture.getGoals().getHome();

            Integer awayGoals =
                    fixture.getGoals().getAway();

            if (homeGoals == null || awayGoals == null) {
                continue;
            }

            int goalsFor =
                    homeTeam
                            ? homeGoals
                            : awayGoals;

            int goalsAgainst =
                    homeTeam
                            ? awayGoals
                            : homeGoals;

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

        TeamResponse teamResponse =
                teamService.getTeam(
                        teamId
                );

        details.setTeam(
                teamResponse.getTeam()
        );

        details.setVenue(
                teamResponse.getVenue()
        );

        Standing standing =
                standingService.getTeamStanding(
                        leagueId,
                        season,
                        teamId
                );

        if (standing != null) {

            details.setLeaguePosition(
                    standing.getRank()
            );

            details.setPoints(
                    standing.getPoints()
            );

        }

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

        overview.setLeagueId(
                leagueId
        );

        overview.setLeagueName(
                supportedCompetitionsService
                        .getCompetitionById(leagueId)
                        .getName()
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





















