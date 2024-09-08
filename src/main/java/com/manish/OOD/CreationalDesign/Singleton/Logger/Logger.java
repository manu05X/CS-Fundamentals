package com.manish.OOD.CreationalDesign.Singleton.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static volatile Logger instance;
    private PrintWriter writer;

    // Private constructor to prevent instantiation
    private Logger() {
        try {
            // Initialize log file
            FileWriter fileWriter = new FileWriter("application.log", true); // Append mode
            writer = new PrintWriter(fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize logger", e);
        }
    }

    // Singleton instance retrieval
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Method to log a message
    public void log(String message) {
        writer.println(message);
        writer.flush(); // Ensure the message is written immediately
    }

    // Method to close the writer
    public void close() {
        if (writer != null) {
            writer.close();
        }
    }
}
/*
A Singleton can be used to implement a logging system that writes log messages to a file or database. This ensures that all log messages are written to the same location and that there is only one instance of the logging system.

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        // Log messages
        logger.log("Application started.");
        logger.log("Performing some operations...");
        logger.log("Application finished.");

        // Close the logger when done
        logger.close();
    }
}
 */
