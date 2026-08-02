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

    private static String competitionTeamRoot(
            int leagueId,
            int teamId
    ) {
        return competitionRoot(leagueId)
                + "teams/"
                + teamId
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
        return competitionTeamRoot(
                leagueId,
                teamId
        ) + "statistics.json";
    }


    /**
     * FIXTURES SECTION
     */

    private static String competitionFixtureRoot(
            int leagueId,
            long fixtureId
    ) {
        return competitionRoot(leagueId)
                + "fixtures/"
                + fixtureId
                + "/";
    }

    public static String fixtures(
            int leagueId,
            int season
    ) {
        return competitionRoot(leagueId)
                + "fixtures.json";
    }

    public static String fixture(
            long fixtureId
    ) {
        return "fixtures/"
                + fixtureId
                + "/fixture.json";
    }

    public static String fixtureEvents(
            long fixtureId
    ) {
        return "fixtures/"
                + fixtureId
                + "/events.json";
    }

    public static String fixtureLineups(
            long fixtureId
    ) {
        return "fixtures/"
                + fixtureId
                + "/lineups.json";
    }

    public static String fixtureStatistics(
            long fixtureId
    ) {
        return "fixtures/"
                + fixtureId
                + "/statistics.json";
    }

    public static String teamFixtures(
            int teamId,
            int leagueId,
            int season
    ) {
        return competitionTeamRoot(
                leagueId,
                teamId
        ) + "fixtures.json";
    }

    /**
     * Player(s) ApiPaths
     */

    public static String teamPlayers(
            int teamId,
            int leagueId,
            int season
    ) {
        return competitionTeamRoot(
                leagueId,
                teamId
        ) + "players.json";
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