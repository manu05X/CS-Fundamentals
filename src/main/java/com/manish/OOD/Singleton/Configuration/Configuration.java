package com.manish.OOD.Singleton.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class Configuration {
    private static volatile Configuration instance;
    private Properties properties;

    // Private constructor to prevent instantiation
    private Configuration() {
        properties = new Properties();
        loadProperties();
    }

    // Method to load properties from a configuration file
    private void loadProperties() {
        String configFilePath = "config.properties"; // Change to your configuration file path
        try (InputStream input = new FileInputStream(configFilePath)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration properties", e);
        }
    }

    // Singleton instance retrieval
    public static Configuration getInstance() {
        if (instance == null) {
            synchronized (Configuration.class) {
                if (instance == null) {
                    instance = new Configuration();
                }
            }
        }
        return instance;
    }

    // Method to get a property value by key
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}

/*
//In many applications, there is a need for a single source of configuration information that can be accessed from various parts of the application. A Singleton can be used to store this configuration data.
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
* */