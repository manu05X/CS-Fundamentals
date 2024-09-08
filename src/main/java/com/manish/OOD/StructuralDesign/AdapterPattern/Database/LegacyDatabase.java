package com.manish.OOD.StructuralDesign.AdapterPattern.Database;

// Legacy database interface
public interface LegacyDatabase {
    void open(String username, String password);

    Object runQuery(String query);

    void close();
}
