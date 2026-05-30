package org.footballapp.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://192.168.1.200:5432/footballapp_db";

    private static final String USER = "admin_dw";
    private static final String PASSWORD = "1565";

    public static Connection connect() throws Exception {

        return DriverManager.getConnection(
                URL,
                USER,
                PASSWORD
        );
    }
}