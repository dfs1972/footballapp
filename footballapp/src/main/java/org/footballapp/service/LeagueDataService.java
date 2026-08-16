package org.footballapp.service;

/**
 * Spring Boot Service
 */
import org.footballapp.api.response.lineups.FixtureLineupMapper;
import org.footballapp.model.standings.LeagueTableFormat;
import org.footballapp.service.LeagueTableFormatResolver;
import org.footballapp.mapper.*;
import org.footballapp.model.coaches.Coach;
import org.footballapp.model.fixtures.FixturesApiResponse;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.squad.SquadApiResponse;
import org.footballapp.model.standings.*;
import org.footballapp.model.teams.TeamResponse;
import org.footballapp.model.teams.TeamsApiResponse;
import org.springframework.stereotype.Service;

import java.util.*;


/**Import repositories*/
//import org.footballapp.repository.PlayerStatisticsRepository;
import org.footballapp.model.club.ClubDetails;

/**Import models*/
import org.footballapp.model.fixtures.FixtureDetails;
import org.footballapp.api.response.lineups.FixtureLineupResponse;
import org.footballapp.api.response.lineups.FixtureTeamLineupResponse;
import org.footballapp.api.response.lineups.PlayerLineupResponse;
import org.footballapp.model.fixtures.FixtureRow;
import org.footballapp.model.playerdetails.PlayerSummary;
import org.footballapp.model.teams.Team;
import org.footballapp.model.league.LeagueOverview;
import org.footballapp.model.playerdetails.PlayerDetails;
import org.footballapp.model.standings.LeagueTableGroup;

@Service
public class LeagueDataService {

    private final FixtureMapper fixtureMapper;
    private final LeagueTableFormatResolver leagueTableFormatResolver;
    private final FixtureLineupMapper fixtureLineupMapper;
    private final FootballDataProvider  fixtureService;
    private final FootballDataProvider  footballDataProvider;
    private final SupportedCompetitionsService supportedCompetitionsService;
    private final StandingService standingService;
    private final TeamService teamService;
    private final TeamMapper teamMapper;
    private final CoachMapper coachMapper;
    private final PlayerMapper playerMapper;
    private final PlayerDetailsMapper playerDetailsMapper;

    /**
     * Contructors
     */
    public LeagueDataService(
            TeamMapper teamMapper,
            CoachMapper coachMapper,
            TeamService teamService,
            StandingService standingService,
            LeagueTableFormatResolver leagueTableFormatResolver,
            FixtureMapper fixtureMapper,
            FixtureLineupMapper fixtureLineupMapper,
            FootballDataProvider  fixtureService,
            SupportedCompetitionsService supportedCompetitionsService,
            FootballDataProvider footballDataProvider,
            PlayerMapper playerMapper,
            PlayerDetailsMapper playerDetailsMapper
    ) {
        this.teamMapper = teamMapper;
        this.teamService = teamService;
        this.coachMapper = coachMapper;
        this.standingService = standingService;
        this.leagueTableFormatResolver = leagueTableFormatResolver;
        this.fixtureMapper = fixtureMapper;
        this.fixtureService  = fixtureService;
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

        PlayersApiResponse players =
                footballDataProvider.getTeamPlayers(
                        teamId,
                        leagueId,
                        season
                );

        SquadApiResponse squad =
                footballDataProvider.getTeamSquad(
                        teamId
                );

        return playerMapper.toPlayerSummaries(
                players,
                squad
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
                "Loaded player: "
                        + response.getResponse()
                        .get(0)
                        .getPlayer()
                        .getFirstname()
                        + " "
                        + response.getResponse()
                        .get(0)
                        .getPlayer()
                        .getLastname()
        );

        return playerDetailsMapper.toPlayerDetails(

                response,

                leagueId,

                season

        );

    }

    /**
     * Get league table by season
     */

    /**
     * Get league table by season.
     *
     * The API-Football standings response may contain:
     *
     * - one ordinary table
     * - multiple independent groups
     * - multiple phases of the same competition
     *
     * LeagueTableFormatResolver determines how those groups
     * should be presented to the application.
     */
    public List<LeagueTableGroup> getLeagueTable(
            int leagueId,
            int season
    ) throws Exception {

        LeagueTableFormat format =
                leagueTableFormatResolver.resolve(
                        leagueId,
                        season
                );

        List<List<Standing>> groups =
                standingService.getLeagueStandingGroups(
                        leagueId,
                        season
                );

        if (groups == null
                || groups.isEmpty()) {

            return List.of();
        }

        /*
         * GROUPED_TABLE
         *
         * Preserve the groups returned by API-Football.
         *
         * Example:
         *
         * FAW Championship
         *     North
         *     South
         */
        if (format ==
                LeagueTableFormat.GROUPED_TABLE) {

            return createLeagueTableGroups(
                    groups
            );
        }

        /*
         * SINGLE_TABLE
         *
         * The competition should be presented as one
         * continuous table.
         *
         * For a normal competition this is simply the
         * first/only standings group.
         *
         * For competitions with split phases, the final
         * phase groups need to be combined.
         */
        List<Standing> standings =
                getSingleTableStandings(
                        leagueId,
                        groups
                );

        if (standings.isEmpty()) {

            return List.of();

        }

        /*
         * A single LeagueTableGroup represents the
         * complete competition table.
         */
        LeagueTableGroup group =
                createLeagueTableGroup(
                        standings,
                        "League Table"
                );

        return List.of(group);
    }

    private List<LeagueTableGroup> createLeagueTableGroups(
            List<List<Standing>> groups
    ) {

        List<LeagueTableGroup> result =
                new ArrayList<>();

        for (List<Standing> standings : groups) {

            if (standings == null
                    || standings.isEmpty()) {

                continue;
            }

            String groupName =
                    standings.getFirst().getGroup();

            if (groupName == null
                    || groupName.isBlank()) {

                groupName = "League Table";

            }

            result.add(
                    createLeagueTableGroup(
                            standings,
                            groupName
                    )
            );
        }

        return result;
    }

    /**
     * Creates a single LeagueTableGroup from a list of standings.
     */
    private LeagueTableGroup createLeagueTableGroup(
            List<Standing> standings,
            String groupName
    ) {

        LeagueTableGroup group =
                new LeagueTableGroup();

        group.setGroup(
                groupName
        );

        List<LeagueTableRow> rows =
                new ArrayList<>();

        for (Standing standing : standings) {

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

            rows.add(row);
        }

        group.setStandings(
                rows
        );

        return group;
    }

    /**
     * Determines the standings that represent the complete
     * single-table competition.
     */
    private List<Standing> getSingleTableStandings(
            int leagueId,
            List<List<Standing>> groups
    ) {

        /*
         * Ordinary single-table competition.
         */
        if (groups.size() == 1) {

            return groups.getFirst();

        }

        /*
         * Scottish Premiership.
         *
         * API-Football returns:
         *
         *   Phase 1
         *   Championship Round
         *   Relegation Round
         *
         * The application wants the final 12-team table,
         * so combine the two post-split groups.
         */
        if (leagueId == 179
                && groups.size() >= 3) {

            List<Standing> combined =
                    new ArrayList<>();

            combined.addAll(
                    groups.get(1)
            );

            combined.addAll(
                    groups.get(2)
            );

            return sortAndReRank(
                    combined
            );
        }

        /*
         * For any other multi-group SINGLE_TABLE
         * competition, use all groups as one table.
         *
         * This gives us a sensible generic fallback
         * while we build a more complete competition
         * format configuration.
         */
        List<Standing> combined =
                new ArrayList<>();

        for (List<Standing> group : groups) {

            if (group != null) {

                combined.addAll(group);

            }
        }

        return sortAndReRank(
                combined
        );
    }

    /**
     * Sorts a combined table and assigns continuous
     * league positions.
     */
    private List<Standing> sortAndReRank(
            List<Standing> standings
    ) {

        standings.sort(
                Comparator
                        .comparing(
                                Standing::getPoints,
                                Comparator.reverseOrder()
                        )
                        .thenComparing(
                                Standing::getGoalsDiff,
                                Comparator.reverseOrder()
                        )
                        .thenComparing(
                                standing ->
                                        standing.getTeam()
                                                .getName(),
                                String.CASE_INSENSITIVE_ORDER
                        )
        );

        for (int i = 0; i < standings.size(); i++) {

            standings
                    .get(i)
                    .setRank(i + 1);

        }

        return standings;
    }

    /**
     * Retrieves details for a single club.
     */
    public ClubDetails getClubDetails(
            int clubId
    ) throws Exception {

        TeamsApiResponse response =
                footballDataProvider.getTeam(
                        clubId
                );

        if (response.getResponse().isEmpty()) {
            return null;
        }

        TeamResponse teamResponse =
                response.getResponse().getFirst();

        ClubDetails club =
                new ClubDetails();

        club.setClubId(
                teamResponse.getTeam().getId()
        );

        club.setName(
                teamResponse.getTeam().getName()
        );

        club.setCountry(
                teamResponse.getTeam().getCountry()
        );

        club.setFounded(
                teamResponse.getTeam().getFounded()
        );

        club.setStadium(
                teamResponse.getVenue().getName()
        );

        club.setCity(
                teamResponse.getVenue().getCity()
        );

        club.setCapacity(
                teamResponse.getVenue().getCapacity()
        );

        Coach coach =
                coachMapper.getCurrentCoach(

                        footballDataProvider.getCoach(
                                clubId
                        ),

                        clubId

                );

        if (coach != null) {

            String coachName;

            if (coach.getFirstname() != null
                    && !coach.getFirstname().isBlank()
                    && coach.getLastname() != null
                    && !coach.getLastname().isBlank()) {

                coachName =
                        coach.getFirstname()
                                + " "
                                + coach.getLastname();

            } else {

                coachName =
                        coach.getName();

            }

            club.setCoach(coachName);
        }

        return club;
    }


    /**************** FIXTURES SECTION ***************************/


    /**
     *  Get Fixtures for that season.
     */

    public List<FixtureRow> getFixtures(
            int leagueId,
            int season
    ) throws Exception {

        return fixtureMapper.toFixtureRows(

                footballDataProvider.getFixtures(

                        leagueId,
                        season

                )

        );

    }

    /**
     * Get Fixture Details
     */

    public FixtureDetails getFixtureDetails(
            long fixtureId
    ) throws Exception {

        FixturesApiResponse response =
                footballDataProvider.getFixture(
                        fixtureId
                );

        return fixtureMapper.toFixtureDetails(
                response
        );

    }

    /**
     * Retrieves the complete lineup for a fixture.
     *
     * Uses the API-Football snapshot/provider rather than
     * the development database.
     */
    public FixtureLineupResponse getFixtureLineupResponse(

            long fixtureId

    ) throws Exception {

        FixtureLineupResponse response =
                fixtureLineupMapper.createResponse(
                        fixtureId
                );

        org.footballapp.api.dto.lineups.FixtureLineupsResponse apiResponse =
                footballDataProvider.getFixtureLineups(
                        fixtureId
                );

        if (apiResponse == null
                || apiResponse.getResponse() == null) {

            return response;

        }

        for (
                org.footballapp.api.dto.lineups.FixtureLineupResponse lineup
                : apiResponse.getResponse()
        ) {

            List<PlayerLineupResponse> players =
                    new ArrayList<>();

            int displayOrder = 0;

            /*
             * Starting XI
             */
            if (lineup.getStartXI() != null) {

                for (
                        org.footballapp.api.dto.lineups.FixturePlayerWrapper player
                        : lineup.getStartXI()
                ) {

                    players.add(
                            fixtureLineupMapper.mapApiPlayer(
                                    player,
                                    true,
                                    displayOrder++
                            )
                    );

                }

            }

            /*
             * Substitutes
             */
            if (lineup.getSubstitutes() != null) {

                for (
                        org.footballapp.api.dto.lineups.FixturePlayerWrapper player
                        : lineup.getSubstitutes()
                ) {

                    players.add(
                            fixtureLineupMapper.mapApiPlayer(
                                    player,
                                    false,
                                    displayOrder++
                            )
                    );

                }

            }

            FixtureTeamLineupResponse teamResponse =
                    fixtureLineupMapper.mapApiTeamLineup(
                            lineup,
                            players
                    );

            response.getTeams().add(
                    teamResponse
            );

        }

        return response;

    }

    /** Get a list of all teams playing in a particular league in that season. */

    public List<Team> getTeamsForLeague(
            int leagueId,
            int season
    ) throws Exception {

        StandingsApiResponse standings =
                footballDataProvider.getStandings(
                        leagueId,
                        season
                );

        List<Standing> primaryStandings =
                getPrimaryStandings(
                        standings
                );

        Set<Integer> teamIds =
                new HashSet<>();

        for (Standing standing
                : primaryStandings) {

            teamIds.add(
                    standing.getTeam().getId()
            );

        }

        List<Team> teams =
                teamMapper.toTeams(
                        footballDataProvider.getTeams(
                                leagueId,
                                season
                        )
                );

        teams.removeIf(team ->
                !teamIds.contains(
                        team.getId()
                )
        );

        teams.sort(
                Comparator.comparing(
                        Team::getName,
                        String.CASE_INSENSITIVE_ORDER
                )
        );

        return teams;

    }

    /********** HELPER FOR ABOVE METHOD, ALSO USED IN SnapshotService - TO BE MOVED INTO A SHARED UTILITY FILE ***************************************/

    private List<Standing> getPrimaryStandings(
            StandingsApiResponse standings
    ) {

        if (standings.getResponse().isEmpty()) {
            return List.of();
        }

        StandingLeague league =
                standings.getResponse().getFirst().getLeague();

        if (league.getStandings().isEmpty()) {
            return List.of();
        }

        return league.getStandings().getFirst();

    }

    /**
     * Returns fixtures for a single team.
     */
    public List<FixtureRow> getTeamFixtures(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        FixturesApiResponse response =
                footballDataProvider.getTeamFixtures(
                        teamId,
                        leagueId,
                        season
                );

        return fixtureMapper.toFixtureRows(
                response
        );
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
                footballDataProvider
                        .getTeams(
                                leagueId,
                                season
                        )
                        .getResponse()
                        .size()
        );

        overview.setFixtureCount(

                footballDataProvider
                        .getFixtures(
                                leagueId,
                                season
                        )
                        .getResponse()
                        .size()

        );

        return overview;

    } // End of getLeagueOverview()

}





















