package org.footballapp.service;

import org.footballapp.api.dto.lineups.FixtureLineupsResponse;
import org.footballapp.model.coaches.CoachApiResponse;
import org.footballapp.model.country.CountriesApiResponse;
import org.footballapp.model.fixtures.FixtureRoundsApiResponse;
import org.footballapp.model.fixtures.FixturesApiResponse;
import org.footballapp.model.league.LeaguesApiResponse;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.squad.SquadApiResponse;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.model.teamstatistics.TeamStatisticsApiResponse;
import org.footballapp.model.teams.TeamsApiResponse;

public interface FootballDataProvider {

    CountriesApiResponse getCountries()
            throws Exception;

    LeaguesApiResponse getLeague(
            int leagueId,
            int season
    ) throws Exception;

    LeaguesApiResponse getLeagues(
            String country,
            int season
    ) throws Exception;

    TeamsApiResponse getTeams(
            int leagueId,
            int season
    ) throws Exception;

    TeamsApiResponse getTeam(
            int teamId
    ) throws Exception;

    CoachApiResponse getCoach(
            int teamId
    ) throws Exception;

    StandingsApiResponse getStandings(
            int leagueId,
            int season
    ) throws Exception;

    FixturesApiResponse getFixtures(
            int leagueId,
            int season
    ) throws Exception;

    FixturesApiResponse getFixture(
            long fixtureId
    ) throws Exception;

    FixtureRoundsApiResponse getFixtureRounds(
            int leagueId,
            int season,
            boolean current
    ) throws Exception;

    FixtureLineupsResponse getFixtureLineups(
            long fixtureId
    ) throws Exception;



    FixturesApiResponse getTeamFixtures(
            int teamId,
            int leagueId,
            int season
    ) throws Exception;

    FixturesApiResponse getRecentTeamFixtures(
            int teamId,
            int last
    ) throws Exception;

    PlayersApiResponse getTeamPlayers(
            int teamId,
            int leagueId,
            int season
    ) throws Exception;

    SquadApiResponse getTeamSquad(
            int teamId
    ) throws Exception;

    PlayersApiResponse getPlayer(
            int playerId,
            int leagueId,
            int season
    ) throws Exception;

    PlayersApiResponse getPlayer(
            int playerId,
            int season
    ) throws Exception;

    TeamStatisticsApiResponse getTeamStatistics(
            int teamId,
            int leagueId,
            int season
    ) throws Exception;
}