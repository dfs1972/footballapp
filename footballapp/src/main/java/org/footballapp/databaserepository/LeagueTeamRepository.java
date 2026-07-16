package org.footballapp.databaserepository;

import javax.sql.DataSource;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;

@Repository
public class LeagueTeamRepository
        extends BaseRepository {

    public LeagueTeamRepository(
            DataSource dataSource
    ) {

        super(dataSource);

    }

    public void saveLeagueTeam(
            int leagueId,
            int season,
            int teamId
    ) throws Exception {

        Connection conn =
                getConnection();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        INSERT INTO league_teams
                        (
                            league_id,
                            season,
                            team_id
                        )
                        VALUES (?, ?, ?)

                        ON CONFLICT
                        (
                            league_id,
                            season,
                            team_id
                        )
                        DO NOTHING
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);
        stmt.setInt(3, teamId);

        stmt.executeUpdate();

        stmt.close();
        conn.close();
    }

    /**
     * Returns all team IDs for a league and season.
     */
    public List<Integer> getTeamIds(
            int leagueId,
            int season
    ) throws Exception {

        List<Integer> teamIds =
                new ArrayList<>();

        Connection conn =
                getConnection();

        PreparedStatement stmt =
                conn.prepareStatement(
                        """
                        SELECT team_id
    
                        FROM league_teams
    
                        WHERE league_id = ?
                          AND season = ?
    
                        ORDER BY team_id
                        """
                );

        stmt.setInt(1, leagueId);
        stmt.setInt(2, season);

        ResultSet rs =
                stmt.executeQuery();

        while (rs.next()) {

            teamIds.add(
                    rs.getInt("team_id")
            );
        }

        rs.close();
        stmt.close();
        conn.close();

        return teamIds;
    }
}