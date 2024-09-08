package com.manish.OOD.CreationalDesign.Singleton.Logger;

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
