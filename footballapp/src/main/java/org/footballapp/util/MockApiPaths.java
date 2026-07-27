package org.footballapp.util;

public final class MockApiPaths {

    private MockApiPaths() {
    }

    public static String league(
            int leagueId
    ) {
        return "leagues/league_"
                + leagueId
                + ".json";
    }

    public static String standings(
            int leagueId,
            int season
    ) {
        return "standings/standings_"
                + leagueId
                + "_"
                + season
                + ".json";
    }

    public static String teams(
            int leagueId,
            int season
    ) {
        return "teams/teams_"
                + leagueId
                + "_"
                + season
                + ".json";
    }

    public static String team(
            int teamId
    ) {
        return "teams/team_"
                + teamId
                + ".json";
    }

    public static String fixtures(
            int leagueId,
            int season
    ) {
        return "fixtures/fixtures_"
                + leagueId
                + "_"
                + season
                + ".json";
    }

    public static String fixture(
            long fixtureId
    ) {
        return "fixtures/fixture_"
                + fixtureId
                + ".json";
    }

    public static String teamFixtures(
            int teamId,
            int last
    ) {
        return "fixtures/teamfixtures_"
                + teamId
                + "_"
                + last
                + ".json";
    }

    public static String players(
            int teamId,
            int season
    ) {
        return "players/players_"
                + teamId
                + "_"
                + season
                + ".json";
    }

    public static String player(
            int playerId,
            int season
    ) {
        return "players/player_"
                + playerId
                + "_"
                + season
                + ".json";
    }

    public static String statistics(
            int teamId,
            int leagueId,
            int season
    ) {
        return "statistics/statistics_"
                + teamId
                + "_"
                + leagueId
                + "_"
                + season
                + ".json";
    }
}