package org.footballapp.databaserepository;

import org.footballapp.database.DatabaseConnection;
import org.springframework.stereotype.Repository;
import org.footballapp.model.teamstatistics.CardColour;
import org.footballapp.model.teamstatistics.CardMinute;
import org.footballapp.model.teamstatistics.TeamStatistics;
import org.footballapp.model.teamstatistics.TeamStatisticsResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.apache.logging.log4j.util.Lazy.value;

@Repository
public class TeamStatisticsRepository {

    /**
     * Saves team statistics to PostgreSQL.
     */
    public void save(
            TeamStatisticsResponse stats
    ) throws Exception {

        String sql = """
                INSERT INTO team_statistics (

                    team_id,
                    league_id,
                    season,

                    played,
                    wins,
                    draws,
                    losses,

                    goals_for,
                    goals_against,

                    clean_sheets,
                    failed_to_score,

                    yellow_cards,
                    red_cards

                )
                VALUES (

                    ?, ?, ?,
                    ?, ?, ?, ?,
                    ?, ?,
                    ?, ?,
                    ?, ?

                )

                ON CONFLICT (
                    team_id,
                    league_id,
                    season
                )

                DO UPDATE SET

                    played = EXCLUDED.played,
                    wins = EXCLUDED.wins,
                    draws = EXCLUDED.draws,
                    losses = EXCLUDED.losses,

                    goals_for = EXCLUDED.goals_for,
                    goals_against = EXCLUDED.goals_against,

                    clean_sheets = EXCLUDED.clean_sheets,
                    failed_to_score = EXCLUDED.failed_to_score,

                    yellow_cards = EXCLUDED.yellow_cards,
                    red_cards = EXCLUDED.red_cards
                """;

        try (

                Connection conn =
                        DatabaseConnection.connect();

                PreparedStatement statement =
                        conn.prepareStatement(sql)

        ) {

            statement.setInt(
                    1,
                    stats.getTeam().getId()
            );

            statement.setInt(
                    2,
                    stats.getLeague().getId()
            );

            statement.setInt(
                    3,
                    stats.getLeague().getSeason()
            );

            statement.setInt(
                    4,
                    stats.getFixtures()
                            .getPlayed()
                            .getTotal()
            );

            statement.setInt(
                    5,
                    stats.getFixtures()
                            .getWins()
                            .getTotal()
            );

            statement.setInt(
                    6,
                    stats.getFixtures()
                            .getDraws()
                            .getTotal()
            );

            statement.setInt(
                    7,
                    stats.getFixtures()
                            .getLoses()
                            .getTotal()
            );

            statement.setInt(
                    8,
                    stats.getGoals()
                            .getForGoals()
                            .getTotal()
                            .getTotal()
            );

            statement.setInt(
                    9,
                    stats.getGoals()
                            .getAgainst()
                            .getTotal()
                            .getTotal()
            );

            statement.setInt(
                    10,
                    stats.getClean_sheet()
                            .getTotal()
            );

            statement.setInt(
                    11,
                    stats.getFailed_to_score()
                            .getTotal()
            );

            statement.setInt(
                    12,
                    getYellowCards(stats)
            );

            statement.setInt(
                    13,
                    getRedCards(stats)
            );

            statement.executeUpdate();
        }
    }// End of save.
    private int getYellowCards(
            TeamStatisticsResponse stats
    ) {

        return sumCards(
                stats.getCards().getYellow()
        );
    }

    private int getRedCards(
            TeamStatisticsResponse stats
    ) {

        return sumCards(
                stats.getCards().getRed()
        );
    }

    private int sumCards(
            CardColour colour
    ) {

        return value(colour.getMinute0to15())
                + value(colour.getMinute16to30())
                + value(colour.getMinute31to45())
                + value(colour.getMinute46to60())
                + value(colour.getMinute61to75())
                + value(colour.getMinute76to90())
                + value(colour.getMinute91to105())
                + value(colour.getMinute106to120());
    }

    private int value(
            CardMinute minute
    ) {

        if (minute == null) {
            return 0;
        }

        return minute.getTotal() == null
                ? 0
                : minute.getTotal();
    }

    /**
     * Returns statistics for a team in a league season.
     */
    public TeamStatistics getTeamStatistics(
            int teamId,
            int leagueId,
            int season
    ) throws Exception {

        Connection conn =
                DatabaseConnection.connect();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT *
    
                        FROM team_statistics
    
                        WHERE team_id = ?
                          AND league_id = ?
                          AND season = ?
                        """
                );

        stmt.setInt(1, teamId);
        stmt.setInt(2, leagueId);
        stmt.setInt(3, season);

        ResultSet rs =
                stmt.executeQuery();

        TeamStatistics statistics = null;

        if (rs.next()) {

            statistics =
                    new TeamStatistics();

            statistics.setTeamId(
                    rs.getInt("team_id")
            );

            statistics.setLeagueId(
                    rs.getInt("league_id")
            );

            statistics.setSeason(
                    rs.getInt("season")
            );

            statistics.setPlayed(
                    rs.getInt("played")
            );

            statistics.setWins(
                    rs.getInt("wins")
            );

            statistics.setDraws(
                    rs.getInt("draws")
            );

            statistics.setLosses(
                    rs.getInt("losses")
            );

            statistics.setGoalsFor(
                    rs.getInt("goals_for")
            );

            statistics.setGoalsAgainst(
                    rs.getInt("goals_against")
            );

            statistics.setCleanSheets(
                    rs.getInt("clean_sheets")
            );

            statistics.setFailedToScore(
                    rs.getInt("failed_to_score")
            );

            statistics.setYellowCards(
                    rs.getInt("yellow_cards")
            );

            statistics.setRedCards(
                    rs.getInt("red_cards")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return statistics;
    }
} // End of Class.