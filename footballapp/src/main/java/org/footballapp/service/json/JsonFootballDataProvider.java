package org.footballapp.service.json;

import org.footballapp.api.dto.lineups.FixtureLineupsResponse;
import org.footballapp.api.dto.events.FixtureEventsApiResponse;
import org.footballapp.config.AppConfig;
import org.footballapp.model.coaches.CoachApiResponse;
import org.footballapp.model.country.CountriesApiResponse;
import org.footballapp.model.country.CountryApiResponse;
import org.footballapp.model.fixtures.FixtureRoundsApiResponse;
import org.footballapp.model.fixtures.FixturesApiResponse;
import org.footballapp.api.dto.fixtures.FixtureStatisticsResponse;
import org.footballapp.model.league.LeagueApiResponse;
import org.footballapp.model.league.LeaguesApiResponse;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.squad.SquadApiResponse;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.model.teams.TeamsApiResponse;
import org.footballapp.model.teamstatistics.TeamStatisticsApiResponse;
import org.footballapp.service.FootballDataProvider;
import org.footballapp.service.json.JsonLoader;
import org.footballapp.service.snapshot.SnapshotNotFoundException;
import org.footballapp.util.MockApiPaths;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Profile("json")
public class JsonFootballDataProvider implements FootballDataProvider {

    private final JsonLoader jsonLoader;

    public JsonFootballDataProvider(JsonLoader jsonLoader) {
        this.jsonLoader = jsonLoader;
    }

    @Override
    public StandingsApiResponse getStandings(
            int leagueId,
            int season
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.standings(
                            leagueId,
                            season
                    ),
                    StandingsApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            return new StandingsApiResponse();
        }
    }

    /**
     * League Section
     */

    @Override
    public LeaguesApiResponse getLeague(
            int leagueId,
            int season
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.league(
                            leagueId
                    ),
                    LeaguesApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            LeaguesApiResponse response = new LeaguesApiResponse();
            response.setResponse(List.of());
            return response;
        }

    }

    @Override
    public LeaguesApiResponse getLeagues(
            String country,
            int season
    ) throws Exception {

        LeaguesApiResponse allLeagues;
        try {
            allLeagues = jsonLoader.load(
                    "leagues/all.json",
                    LeaguesApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            LeaguesApiResponse response = new LeaguesApiResponse();
            response.setResponse(List.of());
            return response;
        }

        if (allLeagues.getResponse() == null) {
            allLeagues.setResponse(List.of());
            return allLeagues;
        }

        List<LeagueApiResponse> filtered = allLeagues.getResponse().stream()
                .filter(l -> l.getCountry() != null && l.getCountry().getName().equalsIgnoreCase(country))
                .toList();

        LeaguesApiResponse response = new LeaguesApiResponse();
        response.setResponse(filtered);

        return response;
    }

    @Override
    public CountriesApiResponse getCountries()
            throws Exception {

        LeaguesApiResponse allLeagues;
        try {
            allLeagues = jsonLoader.load(
                    "leagues/all.json",
                    LeaguesApiResponse.class
            );
        } catch (Exception e) {
            return new CountriesApiResponse();
        }

        if (allLeagues.getResponse() == null) {
            return new CountriesApiResponse();
        }

        List<CountryApiResponse> countries = allLeagues.getResponse().stream()
                .map(LeagueApiResponse::getCountry)
                .filter(Objects::nonNull)
                .map(c -> {
                    CountryApiResponse resp = new CountryApiResponse();
                    resp.setName(c.getName());
                    resp.setCode(c.getCode());
                    resp.setFlag(c.getFlag());
                    return resp;
                })
                .collect(Collectors.toMap(
                        CountryApiResponse::getName,
                        c -> c,
                        (c1, c2) -> c1
                ))
                .values().stream()
                .sorted(Comparator.comparing(CountryApiResponse::getName))
                .toList();

        CountriesApiResponse response = new CountriesApiResponse();
        response.setResponse(countries);
        return response;
    }


    /**
     ********* TEAMS & COACH SECTION *********
     */

    @Override
    public CoachApiResponse getCoach(
            int teamId
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.coach(
                            teamId
                    ),
                    CoachApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            return new CoachApiResponse();
        }

    }

    @Override
    public TeamsApiResponse getTeams(
            int leagueId,
            int season
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.teams(
                            leagueId,
                            season
                    ),
                    TeamsApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            TeamsApiResponse resp = new TeamsApiResponse();
            resp.setResponse(List.of());
            return resp;
        }
    }

    @Override
    public TeamsApiResponse getTeam(
            int teamId
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.team(
                            teamId
                    ),
                    TeamsApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            TeamsApiResponse resp = new TeamsApiResponse();
            resp.setResponse(List.of());
            return resp;
        }
    }

    @Override
    public TeamStatisticsApiResponse getTeamStatistics(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.teamStatistics(
                            teamId,
                            leagueId,
                            season
                    ),
                    TeamStatisticsApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            return new TeamStatisticsApiResponse();
        }
    }

    /**
     ********* FIXTURES SECTION *********
     */

    @Override
    public FixtureRoundsApiResponse getFixtureRounds(
            int leagueId,
            int season,
            boolean current
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.fixtureRounds(
                            leagueId,
                            season
                    ),
                    FixtureRoundsApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            FixtureRoundsApiResponse resp = new FixtureRoundsApiResponse();
            resp.setResponse(List.of());
            return resp;
        }
    }

    @Override
    public FixturesApiResponse getFixtures(
            int leagueId,
            int season
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.fixtures(
                            leagueId,
                            season
                    ),
                    FixturesApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            FixturesApiResponse resp = new FixturesApiResponse();
            resp.setResponse(List.of());
            return resp;
        }
    }

    @Override
    public FixturesApiResponse getFixture(
            long fixtureId
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.fixture(
                            fixtureId
                    ),
                    FixturesApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            FixturesApiResponse resp = new FixturesApiResponse();
            resp.setResponse(List.of());
            return resp;
        }
    }

    @Override
    public FixtureLineupsResponse getFixtureLineups(
            long fixtureId
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.fixtureLineups(
                            fixtureId
                    ),
                    FixtureLineupsResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            FixtureLineupsResponse resp = new FixtureLineupsResponse();
            resp.setResponse(List.of());
            return resp;
        }
    }

    @Override
    public FixtureLineupsResponse getFixtureLineups(
            long fixtureId,
            long ttl
    ) throws Exception {
        return getFixtureLineups(fixtureId);
    }

    @Override
    public FixtureEventsApiResponse getFixtureEvents(
            long fixtureId
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.fixtureEvents(
                            fixtureId
                    ),
                    FixtureEventsApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            FixtureEventsApiResponse resp = new FixtureEventsApiResponse();
            resp.setResponse(List.of());
            return resp;
        }
    }

    @Override
    public FixtureEventsApiResponse getFixtureEvents(
            long fixtureId,
            long ttl
    ) throws Exception {
        return getFixtureEvents(fixtureId);
    }

    @Override
    public FixtureStatisticsResponse getFixtureStatistics(
            long fixtureId
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.fixtureStatistics(
                            fixtureId
                    ),
                    FixtureStatisticsResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            FixtureStatisticsResponse resp = new FixtureStatisticsResponse();
            resp.setResponse(List.of());
            return resp;
        }
    }

    @Override
    public FixtureStatisticsResponse getFixtureStatistics(
            long fixtureId,
            long ttl
    ) throws Exception {
        return getFixtureStatistics(fixtureId);
    }

    @Override
    public FixturesApiResponse getTeamFixtures(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.teamFixtures(
                            teamId,
                            leagueId,
                            season
                    ),
                    FixturesApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            FixturesApiResponse resp = new FixturesApiResponse();
            resp.setResponse(List.of());
            return resp;
        }
    }

    @Override
    public FixturesApiResponse getRecentTeamFixtures(
            int teamId,
            int last
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.teamFixtures(
                            teamId,
                            AppConfig.DEVELOPMENT_LEAGUE,
                            AppConfig.DEVELOPMENT_SEASON
                    ),
                    FixturesApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            FixturesApiResponse resp = new FixturesApiResponse();
            resp.setResponse(List.of());
            return resp;
        }
    }


    /**
     ********* PLAYERS SECTION ********
     */

    @Override
    public PlayersApiResponse getTeamPlayers(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.teamPlayers(
                            teamId,
                            leagueId,
                            season
                    ),
                    PlayersApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            PlayersApiResponse resp = new PlayersApiResponse();
            resp.setResponse(List.of());
            return resp;
        }
    }

    @Override
    public SquadApiResponse getTeamSquad(
            int teamId
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.teamSquad(
                            teamId
                    ),
                    SquadApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            SquadApiResponse resp = new SquadApiResponse();
            resp.setResponse(List.of());
            return resp;
        }

    }

    @Override
    public PlayersApiResponse getPlayer(
            int playerId,
            int leagueId,
            int season
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.player(
                            playerId,
                            season
                    ),
                    PlayersApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            PlayersApiResponse resp = new PlayersApiResponse();
            resp.setResponse(List.of());
            return resp;
        }
    }

    @Override
    public PlayersApiResponse getPlayer(
            int playerId,
            int season
    ) throws Exception {

        try {
            return jsonLoader.load(
                    MockApiPaths.player(
                            playerId,
                            season
                    ),
                    PlayersApiResponse.class
            );
        } catch (SnapshotNotFoundException e) {
            PlayersApiResponse resp = new PlayersApiResponse();
            resp.setResponse(List.of());
            return resp;
        }
    }
}
