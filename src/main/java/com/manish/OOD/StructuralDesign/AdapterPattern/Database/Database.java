package com.manish.OOD.StructuralDesign.AdapterPattern.Database;

// Interface used by the application
public interface Database {
    void connect(String username, String password);

    ResultSet executeQuery(String query);

    void disconnect();
}
