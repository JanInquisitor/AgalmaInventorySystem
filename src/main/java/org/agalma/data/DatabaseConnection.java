package org.agalma.data;

import java.sql.*;

public class DatabaseConnection {
    private final String url = "jdbc:postgresql://localhost/agalmadb";
    private final String user = "postgres";
    private final String password = "admin";

    public DatabaseConnection() {
    }

    public static DatabaseConnection getDatabaseConnection() {
        return new DatabaseConnection();
    }

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
