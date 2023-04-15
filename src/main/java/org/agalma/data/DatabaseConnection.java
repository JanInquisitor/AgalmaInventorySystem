package org.agalma.data;

import java.sql.*;

public class DatabaseConnection {
    private String url = "jdbc:postgresql://localhost/agalmadb";
    private String user = "postgres";
    private String password = "admin";

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

    public int getActorCount() {
        String SQL = "SELECT count(*) FROM Actor";
        int count = 0;

        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            rs.next();
            count = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return count;
    }
}
