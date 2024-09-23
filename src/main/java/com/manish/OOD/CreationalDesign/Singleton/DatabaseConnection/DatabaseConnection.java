package com.manish.OOD.CreationalDesign.Singleton.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static volatile DatabaseConnection instance;
    private Connection connection;
    private final String url = "jdbc:mysql://localhost:3306/yourDatabase"; // Change to your database URL
    private final String user = "yourUsername"; // Change to your database username
    private final String password = "yourPassword"; // Change to your database password

    // Private constructor to prevent instantiation
    private DatabaseConnection() {
        try {
            // Initialize database connection
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database", e);
        }
    }

    // Singleton instance retrieval
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    // Method to get the database connection
    public Connection getConnection() {
        return connection;
    }

    // Method to close the connection
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to close the database connection", e);
            }
        }
    }
}

/*
//When an application needs to connect to a database, it's often useful to use a Singleton to ensure that there is only one connection to the database throughout the application's lifetime.

public class com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main {
    public static void main(String[] args) {
        DatabaseConnection dbConnection = DatabaseConnection.getInstance();
        Connection connection = dbConnection.getConnection();

        // Use the connection to interact with the database...

        // Close the connection when done
        dbConnection.closeConnection();
    }
}

*/
