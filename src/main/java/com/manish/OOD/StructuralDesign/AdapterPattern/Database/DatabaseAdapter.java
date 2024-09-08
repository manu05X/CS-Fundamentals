package com.manish.OOD.StructuralDesign.AdapterPattern.Database;

// Adapter that implements the application's interface
public class DatabaseAdapter implements Database {
    private LegacyDatabase legacyDatabase;

    public DatabaseAdapter(LegacyDatabase legacyDatabase) {
        this.legacyDatabase = legacyDatabase;
    }

    @Override
    public void connect(String username, String password) {
        this.legacyDatabase.open(username, password);
    }

    @Override
    public ResultSet executeQuery(String query) {
        Object result = this.legacyDatabase.runQuery(query);
        // Convert the legacy result to a ResultSet object
        return convertLegacyResult(result);
    }

    @Override
    public void disconnect() {
        this.legacyDatabase.close();
    }

    // Helper method to convert the legacy result to a ResultSet object
    private ResultSet convertLegacyResult(Object result) {
        // Implementation omitted for brevity
        // Example conversion (pseudo-code)
        // return new ResultSet(result);
        return null;  // Placeholder
    }
}
