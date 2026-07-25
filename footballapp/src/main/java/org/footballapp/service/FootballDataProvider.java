package org.footballapp.service;

import org.footballapp.model.fixtures.FixturesApiResponse;
import org.footballapp.model.league.LeaguesApiResponse;
import org.footballapp.model.player.PlayersApiResponse;
import org.footballapp.model.standings.StandingsApiResponse;
import org.footballapp.model.teamstatistics.TeamStatisticsApiResponse;
import org.footballapp.model.teams.TeamsApiResponse;

public interface FootballDataProvider {

    LeaguesApiResponse getLeagues() throws Exception;

    TeamsApiResponse getTeams(
            int leagueId,
            int season
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

    PlayersApiResponse getPlayers(
            int teamId,
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