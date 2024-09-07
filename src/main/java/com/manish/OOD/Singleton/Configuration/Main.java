package com.manish.OOD.Singleton.Configuration;

public class Main {
    public static void main(String[] args) {
        Configuration config = Configuration.getInstance();

        // Retrieve properties
        String dbUrl = config.getProperty("db.url");
        String appName = config.getProperty("app.name");

        System.out.println("Database URL: " + dbUrl);
        System.out.println("Application Name: " + appName);
    }
}
