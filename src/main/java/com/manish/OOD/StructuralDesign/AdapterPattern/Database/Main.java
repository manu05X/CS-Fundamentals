package com.manish.OOD.StructuralDesign.AdapterPattern.Database;

// com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main class to demonstrate usage
public class Main {
    public static void main(String[] args) {
        // Create an instance of the legacy database implementation
        LegacyDatabase legacyDatabase = new LegacyDatabaseImpl();

        // Create an adapter to use the legacy database with the new interface
        Database database = new DatabaseAdapter(legacyDatabase);

        // Use the adapter to connect, execute a query, and disconnect
        database.connect("username", "password");
        ResultSet resultSet = database.executeQuery("SELECT * FROM table");
        database.disconnect();

        // Process the ResultSet as needed
    }
}

