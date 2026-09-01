package org.footballapp.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.footballapp.api.ApiFootballClient;
import org.footballapp.model.coaches.CoachApiResponse;
import org.footballapp.model.country.CountriesApiResponse;
import org.footballapp.model.fixtures.FixtureRoundsApiResponse;
import org.footballapp.model.player.PlayerResponse;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.league.LeaguesApiResponse;
import org.footballapp.model.teams.TeamsApiResponse;
import org.footballapp.model.squad.SquadApiResponse;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.model.fixtures.FixturesApiResponse;
import org.footballapp.model.teamstatistics.TeamStatisticsApiResponse;
import org.footballapp.api.dto.events.FixtureEventsApiResponse;
import org.footballapp.api.dto.lineups.FixtureLineupsResponse;
//import org.footballapp.api.dto.events.FixtureEventsResponse;
import org.footballapp.api.dto.fixtures.FixtureStatisticsResponse;
import org.footballapp.service.FootballDataProvider;
import org.footballapp.service.SmartCacheService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.footballapp.config.CacheConfig.*;

@Service
@Profile("live")
public class ApiFootballService implements FootballDataProvider {

    private final ApiFootballClient apiClient;
    private final ObjectMapper mapper;
    private final SmartCacheService smartCache;

    public ApiFootballService(
            ApiFootballClient apiClient,
            ObjectMapper mapper,
            SmartCacheService smartCache
    ) {
        this.apiClient = apiClient;
        this.mapper = mapper;
        this.smartCache = smartCache;
    }


    @Override
    @Cacheable(CACHE_COUNTRIES)
    public CountriesApiResponse getCountries()
            throws Exception {

        String url =
                "https://v3.football.api-sports.io/countries";

        System.out.printf("[NETWORK] %s%n", url);

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                CountriesApiResponse.class
        );
    }


    /**************************************************+************************************************
     LEAGUES SECTION
     *************************************************************************************************
     */

    /**
     * Get league details
     */

    @Override
    @Cacheable(CACHE_LEAGUES)
    public LeaguesApiResponse getLeague(
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/leagues?id="
                        + leagueId
                        + "&season="
                        + season;

        System.out.printf("[NETWORK] %s%n", url);

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                LeaguesApiResponse.class
        );
    }

    /**
     * Get Leagues Details
     */

    @Override
    @Cacheable(CACHE_LEAGUES)
    public LeaguesApiResponse getLeagues(
            String country,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/leagues?country="
                        + URLEncoder.encode(
                        country,
                        StandardCharsets.UTF_8
                )
                        + "&season="
                        + season;

        System.out.printf("[NETWORK] %s%n", url);

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                LeaguesApiResponse.class
        );
    }

    /**
     * gets league standings from a specified season
     */
    @Override
    @Cacheable(CACHE_STANDINGS)
    public StandingsApiResponse getStandings(
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/standings?league="
                        + leagueId
                        + "&season="
                        + season;

        System.out.printf("[NETWORK] %s%n", url);

        String json = apiClient.get(url);

        System.out.println(json);

        return mapper.readValue(
                json,
                StandingsApiResponse.class
        );
    }


    /**************************************************+************************************************

     TEAMS SECTION
     *************************************************************************************************
     */


    /**
     * Get Teams & Coaches from a league & season
     */

    @Override
    @Cacheable(CACHE_COACHES)
    public CoachApiResponse getCoach(
            int teamId
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/coachs?team="
                        + teamId;

        System.out.printf("[NETWORK] %s%n", url);

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                CoachApiResponse.class
        );

    }

    @Override
    @Cacheable(CACHE_TEAMS)
    public TeamsApiResponse getTeams(
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/teams?league="
                        + leagueId
                        + "&season="
                        + season;

        System.out.printf("[NETWORK] %s%n", url);

        String json = apiClient.get(url);

        return mapper.readValue(
                json,
                TeamsApiResponse.class
        );
    }

    /**
     * Gets a single team by its API-Football team id.
     */

    @Override
    @Cacheable(CACHE_TEAMS)
    public TeamsApiResponse getTeam(
            int teamId
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/teams?id="
                        + teamId;

        System.out.printf("[NETWORK] %s%n", url);

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                TeamsApiResponse.class
        );
    }

    /**
     * Gets team statistics for a league and season.
     */

    @Override
    @Cacheable(CACHE_STATS)
    public TeamStatisticsApiResponse getTeamStatistics(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/teams/statistics?league="
                        + leagueId
                        + "&season="
                        + season
                        + "&team="
                        + teamId;

        System.out.printf("[NETWORK] %s%n", url);

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                TeamStatisticsApiResponse.class
        );
    }


    /**************************************************+************************************************

     PLAYERS SECTION
     *************************************************************************************************
     */


    /**
     * Retrieves all players for a team in a season.
     */
    @Cacheable(CACHE_PLAYERS)
    public PlayersApiResponse getPlayers(
            int teamId,
            int season,
            int page
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/players?team="
                        + teamId
                        + "&season="
                        + season
                        + "&page="
                        + page;

        System.out.printf("[NETWORK] %s%n", url);

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                PlayersApiResponse.class
        );
    }

    @Override
    @Cacheable(CACHE_SQUADS)
    public SquadApiResponse getTeamSquad(
            int teamId
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/players/squads?team="
                        + teamId;

        System.out.printf("[NETWORK] %s%n", url);

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                SquadApiResponse.class
        );
    }

    @Override
    @Cacheable(CACHE_PLAYERS)
    public PlayersApiResponse getTeamPlayers(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        PlayersApiResponse firstPage =
                mapper.readValue(
                        getPlayersJson(teamId, season, 1),
                        PlayersApiResponse.class
                );

        if (firstPage.getPaging() == null
                || firstPage.getPaging().getTotal() <= 1) {

            return firstPage;
        }

        List<PlayerResponse> allPlayers =
                new ArrayList<>(firstPage.getResponse());

        int totalPages = firstPage.getPaging().getTotal();

        for (int page = 2; page <= totalPages; page++) {

            PlayersApiResponse nextPage =
                    mapper.readValue(
                            getPlayersJson(teamId, season, page),
                            PlayersApiResponse.class
                    );

            if (nextPage.getResponse() != null) {
                allPlayers.addAll(nextPage.getResponse());
            }
        }

        firstPage.setResponse(allPlayers);

        return firstPage;
    }

    @Override
    @Cacheable(CACHE_PLAYERS)
    public PlayersApiResponse getPlayer(
            int playerId,
            int leagueId,
            int season
    ) throws Exception {

        String json =
                getPlayerJson(
                        playerId,
                        leagueId,
                        season
                );

        return mapper.readValue(
                json,
                PlayersApiResponse.class
        );
    }

    @Override
    @Cacheable(CACHE_PLAYERS)
    public PlayersApiResponse getPlayer(
            int playerId,
            int season
    ) throws Exception {

        String json =
                getPlayerJson(
                        playerId,
                        season
                );

        return mapper.readValue(
                json,
                PlayersApiResponse.class
        );
    }

    /**
     * Gets raw data for a league in specified season
     */
    public String getLeagueInfoRaw(
            int leagueId,
            String country
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/leagues?id="
                        + leagueId
                        + "&country="
                        + country;

        return apiClient.get(url);
    }

    public String getPlayersJson(
            int teamId,
            int season,
            int page
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/players?team="
                        + teamId
                        + "&season="
                        + season
                        + "&page="
                        + page;

        System.out.printf("[NETWORK] %s%n", url);

        return apiClient.get(url);
    }


    /**
     * Gets the raw JSON for a single player in a league and season.
     */
    public String getPlayerJson(
            int playerId,
            int leagueId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/players?id="
                        + playerId
                        + "&league="
                        + leagueId
                        + "&season="
                        + season;

        System.out.printf("[NETWORK] %s%n", url);

        return apiClient.get(url);
    }

    public String getPlayerJson(
            int playerId,
            int season
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/players?id="
                        + playerId
                        + "&season="
                        + season;

        System.out.printf("[NETWORK] %s%n", url);

        return apiClient.get(url);
    }


    /**************************************************************************************************

     FIXTURES SECTION
     *************************************************************************************************
     */


    /**
     * Gets all fixtures from a league in specified season
     */

    @Override
    @Cacheable(CACHE_ROUNDS)
    public FixtureRoundsApiResponse getFixtureRounds(
            int leagueId,
            int season,
            boolean current
    ) throws Exception {

        String url =
                "https://v3.football.api-sports.io/fixtures/rounds"
                        + "?league=" + leagueId
                        + "&season=" + season
                        + "&current=" + current;

        System.out.printf("[NETWORK] %s%n", url);

        String json =
                apiClient.get(url);

        return mapper.readValue(
                json,
                FixtureRoundsApiResponse.class
        );
    }


    @Override
    public FixturesApiResponse getFixtures(
            int leagueId,
            int season
    ) throws Exception {

        String key = "fixtures-" + leagueId + "-" + season;
        FixturesApiResponse cached = smartCache.get(key, FixturesApiResponse.class);
        if (cached != null) return cached;

        String url =
                "https://v3.football.api-sports.io/fixtures?league="
                        + leagueId
                        + "&season="
                        + season;

        System.out.printf("[NETWORK] %s%n", url);

        String json = apiClient.get(url);

        FixturesApiResponse response = mapper.readValue(
                json,
                FixturesApiResponse.class
        );

        smartCache.put(key, response);

        return response;
    }

    @Override
    public FixturesApiResponse getFixture(
            long fixtureId
    ) throws Exception {

        String key = "fixture-" + fixtureId;
        FixturesApiResponse cached = smartCache.get(key, FixturesApiResponse.class);
        if (cached != null) return cached;

        String url =
                "https://v3.football.api-sports.io/fixtures?id="
                        + fixtureId;

        System.out.printf("[NETWORK] %s%n", url);

        String json =
                apiClient.get(url);

        FixturesApiResponse response = mapper.readValue(
                json,
                FixturesApiResponse.class
        );

        smartCache.put(key, response);

        return response;
    }

    /**
     * Get a team's fixtures
     */

    @Override
    public FixturesApiResponse getTeamFixtures(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        String key = "team-fixtures-" + teamId + "-" + leagueId + "-" + season;
        FixturesApiResponse cached = smartCache.get(key, FixturesApiResponse.class);
        if (cached != null) return cached;

        String url =
                "https://v3.football.api-sports.io/fixtures?team="
                        + teamId
                        + "&league="
                        + leagueId
                        + "&season="
                        + season;

        System.out.printf("[NETWORK] %s%n", url);

        String json =
                apiClient.get(url);

        FixturesApiResponse response = mapper.readValue(
                json,
                FixturesApiResponse.class
        );

        smartCache.put(key, response);

        return response;
    }

    /**
     * Get team's last N fixtures
     */

    @Override
    public FixturesApiResponse getRecentTeamFixtures(
            int teamId,
            int last
    ) throws Exception {

        String key = "recent-fixtures-" + teamId + "-" + last;
        FixturesApiResponse cached = smartCache.get(key, FixturesApiResponse.class);
        if (cached != null) return cached;

        String url =
                "https://v3.football.api-sports.io/fixtures?team="
                        + teamId
                        + "&last="
                        + last;

        System.out.printf("[NETWORK] %s%n", url);

        String json =
                apiClient.get(url);

        FixturesApiResponse response = mapper.readValue(
                json,
                FixturesApiResponse.class
        );

        smartCache.put(key, response);

        return response;
    }

    /**
     * Retrieves the lineups for a fixture.
     */
    @Override
    public FixtureLineupsResponse getFixtureLineups(
            long fixtureId
    ) throws Exception {
        return getFixtureLineups(fixtureId, 15);
    }

    @Override
    public FixtureLineupsResponse getFixtureLineups(
            long fixtureId,
            long ttl
    ) throws Exception {

        String key = "lineups-" + fixtureId;
        FixtureLineupsResponse cached = smartCache.get(key, FixtureLineupsResponse.class);
        if (cached != null) {
            System.out.printf("[CACHE HIT] %s%n", key);
            return cached;
        }

        String url =
                "https://v3.football.api-sports.io/fixtures/lineups?fixture="
                        + fixtureId;

        System.out.printf("[NETWORK] %s%n", url);

        String json =
                apiClient.get(url);

        FixtureLineupsResponse response = mapper.readValue(
                json,
                FixtureLineupsResponse.class
        );

        smartCache.put(key, response, ttl);

        return response;
    }

    @Override
    public FixtureEventsApiResponse getFixtureEvents(
            long fixtureId
    ) throws Exception {
        return getFixtureEvents(fixtureId, 15);
    }

    @Override
    public FixtureEventsApiResponse getFixtureEvents(
            long fixtureId,
            long ttl
    ) throws Exception {

        String key = "events-" + fixtureId;
        FixtureEventsApiResponse cached = smartCache.get(key, FixtureEventsApiResponse.class);
        if (cached != null) {
            System.out.printf("[CACHE HIT] %s%n", key);
            return cached;
        }

        String url =
                "https://v3.football.api-sports.io/fixtures/events?fixture="
                        + fixtureId;

        System.out.printf("[NETWORK] %s%n", url);

        String json =
                apiClient.get(url);

        FixtureEventsApiResponse response = mapper.readValue(
                json,
                FixtureEventsApiResponse.class
        );

        smartCache.put(key, response, ttl);

        return response;
    }
}

