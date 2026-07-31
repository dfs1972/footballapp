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

    public static String teamStatistics(
            int teamId,
            int leagueId,
            int season
    ) {
        return "statistics/teamStatistics_"
                + teamId
                + "_"
                + leagueId
                + "_"
                + season
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

    public static String fixture(long fixtureId) {

        return "fixtures/"
                + fixtureId
                + "/fixture.json";
    }

    public static String teamFixtures(
            int teamId,
            int leagueId,
            int season
    ) {
        return "fixtures/team_fixtures_"
                + teamId
                + "_"
                + leagueId
                + "_"
                + season
                + ".json";
    }

    public static String fixtureEvents(long fixtureId) {

        return "fixtures/"
                + fixtureId
                + "/events.json";
    }

    public static String fixtureLineups(long fixtureId) {

        return "fixtures/"
                + fixtureId
                + "/lineups.json";
    }

    public static String fixtureStatistics(long fixtureId) {

        return "fixtures/"
                + fixtureId
                + "/statistics.json";
    }

    /**
     * Player(s) ApiPaths
     */

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
        return "players/"
                + playerId
                + "/details.json";
    }

    public static String playerStatistics(
            int playerId,
            int season
    ) {
        return "players/"
                + playerId
                + "/statistics.json";
    }

    public static String playerTransfers(
            int playerId
    ) {
        return "players/"
                + playerId
                + "/transfers.json";
    }

}