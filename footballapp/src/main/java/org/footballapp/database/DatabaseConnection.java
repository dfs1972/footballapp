package org.footballapp.database;

import java.sql.*;

/*
 * Creates JDBC connections to the PostgreSQL database.
 *
 * Connection details are supplied through environment variables.
 */
public class DatabaseConnection {

    private static final String URL =
            System.getenv("FOOTBALLAPP_DB_URL");

    private static final String USER =
            System.getenv("FOOTBALLAPP_DB_USER");

    private static final String PASSWORD =
            System.getenv("FOOTBALLAPP_DB_PASSWORD");

    /*
     * Opens a connection to the configured PostgreSQL database.
     */
    public static Connection connect() throws SQLException {

        if (URL == null || USER == null || PASSWORD == null) {

            throw new IllegalStateException(
                    "FootballApp database environment variables are not configured."
            );

        }

        Connection connection = DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );

        return connection;
    }
}