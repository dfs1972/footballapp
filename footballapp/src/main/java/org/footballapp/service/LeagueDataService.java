package org.footballapp.service;

/**
 * Spring Boot Service
 */
import org.footballapp.api.dto.fixtures.MatchDetailDto;
import org.footballapp.api.dto.events.FixtureEventsApiResponse;
import org.footballapp.api.dto.events.FixtureEventDto;
import org.footballapp.api.response.lineups.FixtureLineupMapper;
import org.footballapp.model.fixtures.*;
import org.footballapp.model.league.LeagueApiResponse;
import org.footballapp.model.league.LeagueListItem;
import org.footballapp.model.league.LeaguesApiResponse;
import org.footballapp.mapper.*;
import org.footballapp.model.coaches.Coach;
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
import org.footballapp.api.response.lineups.FixtureLineupResponse;
import org.footballapp.api.response.lineups.FixtureTeamLineupResponse;
import org.footballapp.api.response.lineups.PlayerLineupResponse;
import org.footballapp.model.playerdetails.PlayerSummary;
import org.footballapp.model.teams.Team;
import org.footballapp.model.league.LeagueOverview;
import org.footballapp.model.playerdetails.PlayerDetails;
import org.footballapp.model.standings.LeagueTableGroup;

@Service
public class LeagueDataService {

    private final FixtureMapper fixtureMapper;
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

        return playerMapper.toPlayerSummaries(
                players
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
                        leagueId,
                        season
                );

        if (response.getResponse() == null ||
                response.getResponse().isEmpty()) {

            System.out.println(
                    "No player details found for playerId="
                            + playerId
                            + ", leagueId="
                            + leagueId
                            + ", season="
                            + season
            );

            if (response.getResponse() == null ||
                    response.getResponse().isEmpty()) {

                System.out.println(
                        "No league-specific player details found."
                                + " Trying player-only lookup for playerId="
                                + playerId
                                + ", season="
                                + season
                );

                response =
                        footballDataProvider.getPlayer(
                                playerId,
                                season
                        );

                if (response.getResponse() == null ||
                        response.getResponse().isEmpty()) {

                    System.out.println(
                            "No player details found for playerId="
                                    + playerId
                                    + ", season="
                                    + season
                    );

                    return null;
                }
            }
        }

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

    public List<LeagueApiResponse> getLeagues(
            String country,
            int season
    ) throws Exception {

        LeaguesApiResponse response =
                footballDataProvider.getLeagues(
                        country,
                        season
                );

        if (response == null
                || response.getResponse() == null) {

            return List.of();
        }

        return response.getResponse();
    }


    /************************ LEAGUE SECTION *****************************/

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

        LeaguesApiResponse leagueResponse =
                footballDataProvider.getLeague(
                        leagueId,
                        season
                );

        overview.setLeagueName(
                leagueResponse
                        .getResponse()
                        .getFirst()
                        .getLeague()
                        .getName()
        );

        overview.setCountryName(
                leagueResponse
                        .getResponse()
                        .getFirst()
                        .getCountry()
                        .getName()
        );

        overview.setCountryFlag(
                leagueResponse
                        .getResponse()
                        .getFirst()
                        .getCountry()
                        .getFlag()
        );

        overview.setSeason(
                season
        );

        return overview;
    } // End of getLeagueOverview()

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

        List<List<Standing>> groups =
                standingService.getLeagueStandingGroups(
                        leagueId,
                        season
                );

        if (groups == null
                || groups.isEmpty()) {

            return List.of();
        }

        return createLeagueTableGroups(
                leagueId,
                groups
        );
    }

    /**
     * Create groups for League Table Screen
     */

    private List<LeagueTableGroup> createLeagueTableGroups(
            int leagueId,
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

        if (leagueId == 111) {
            Collections.reverse(result);
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

            return preserveApiRanking(
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

        return preserveApiRanking(
                combined
        );
    }

    /**
     * Sorts a combined table and assigns continuous
     * league positions.
     */
    private List<Standing> preserveApiRanking(
            List<Standing> standings
    ) {

        standings.sort(
                Comparator.comparingInt(
                        Standing::getRank
                )
        );

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
     * Returns consolidated details for a match (fixture, lineup, events).
     */
    public MatchDetailDto getMatchDetails(long fixtureId) throws Exception {
        MatchDetailDto dto = new MatchDetailDto();

        // 1. Fixture & Score
        dto.setFixture(getFixtureDetails(fixtureId));

        // 2. Lineups
        dto.setLineup(getFixtureLineupResponse(fixtureId));

        // 3. Events
        dto.setEvents(getFixtureEvents(fixtureId));

        return dto;
    }

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
     * Retrieves the events for a fixture.
     */
    public List<FixtureEventDto> getFixtureEvents(
            long fixtureId
    ) throws Exception {

        FixtureEventsApiResponse apiResponse =
                footballDataProvider.getFixtureEvents(
                        fixtureId
                );

        if (apiResponse == null
                || apiResponse.getResponse() == null) {

            return List.of();

        }

        return apiResponse.getResponse();

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

        Set<Integer> teamIds =
                new HashSet<>();

        if (standings != null
                && standings.getResponse() != null
                && !standings.getResponse().isEmpty()) {

            StandingLeague league =
                    standings.getResponse()
                            .getFirst()
                            .getLeague();

            if (league != null
                    && league.getStandings() != null) {

                for (List<Standing> group
                        : league.getStandings()) {

                    if (group == null) {
                        continue;
                    }

                    for (Standing standing : group) {

                        if (standing != null
                                && standing.getTeam() != null) {

                            teamIds.add(
                                    standing.getTeam().getId()
                            );
                        }
                    }
                }
            }
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

//    private List<Standing> getPrimaryStandings(
//            StandingsApiResponse standings
//    ) {
//
//        if (standings.getResponse().isEmpty()) {
//            return List.of();
//        }
//
//        StandingLeague league =
//                standings.getResponse().getFirst().getLeague();
//
//        if (league.getStandings().isEmpty()) {
//            return List.of();
//        }
//
//        return league.getStandings().getFirst();
//
//    }

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
}





















