package com.manish.OOD.StructuralDesign.AdapterPattern.Database;

// Example legacy database implementation for demonstration
class LegacyDatabaseImpl implements LegacyDatabase {
    @Override
    public void open(String username, String password) {
        // Open connection with legacy database
    }

    @Override
    public Object runQuery(String query) {
        // Execute query on legacy database and return result
        return new Object();  // Placeholder
    }

    @Override
    public void close() {
        // Close connection with legacy database
    }
}
