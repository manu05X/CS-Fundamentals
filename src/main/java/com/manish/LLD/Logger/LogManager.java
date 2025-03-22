package com.manish.LLD.Logger;

import java.util.HashMap;
import java.util.Map;

public class LogManager {
    private static LogManager instance;
    private Map<String, Logger> loggers = new HashMap<>();

    private LogManager(){

    }

    public static synchronized LogManager getInstance(){
        if(instance == null){
            instance = new LogManager();
        }
        return instance;
    }

    public Logger getLogger(String name){
        return loggers.computeIfAbsent(name, key-> new Logger(name, LogLevel.INFO));
    }
}
