package org.footballapp.util;

public final class MockApiPaths {

    public static final String ROOT = "mockapi/";

    private MockApiPaths() {
    }

    private static String competitionRoot(
            int leagueId
    ) {
        return "competitions/"
                + leagueId
                + "/";
    }

    public static String league(
            int leagueId
    ) {
        return competitionRoot(leagueId)
                + "league.json";
    }

    public static String standings(
            int leagueId,
            int season
    ) {
        return competitionRoot(leagueId)
                + "standings.json";
    }

    public static String teams(
            int leagueId,
            int season
    ) {
        return competitionRoot(leagueId)
                + "teams.json";
    }

    public static String team(
            int teamId
    ) {
        return "teams/"
                + teamId
                + "/team.json";
    }

    public static String teamStatistics(
            int teamId,
            int leagueId,
            int season
    ) {
        return "teams/"
                + teamId
                + "/statistics.json";
    }

    public static String fixtures(
            int leagueId,
            int season
    ) {
        return competitionRoot(leagueId)
                + "fixtures.json";
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
        return "teams/"
                + teamId
                + "/fixtures.json";
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

    public static String teamPlayers(
            int teamId,
            int season
    ) {
        return "teams/"
                + teamId
                + "/players.json";
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