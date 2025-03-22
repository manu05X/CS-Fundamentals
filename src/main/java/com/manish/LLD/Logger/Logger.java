package com.manish.LLD.Logger;

import java.util.ArrayList;
import java.util.List;

public class Logger {
    private String name;
    private LogLevel level;
    private List<Appender> appenders = new ArrayList<>();

    public Logger(String name, LogLevel level){
        this.name = name;
        this.level = level;
    }

    public void log(LogLevel level, String message){
        if(level.ordinal() >= this.level.ordinal()){
            for (Appender appender : appenders){
                appender.append(formatMessage(level, message));
            }
        }
    }


    public void debug(String message){
        log(LogLevel.DEBUG, message);
    }

    public void info(String message){
        log(LogLevel.INFO, message);
    }

    public void warn(String message){
        log(LogLevel.WARN, message);
    }

    public void error(String message){
        log(LogLevel.ERROR, message);
    }

    public void fatal(String message){
        log(LogLevel.FATAL, message);
    }

    private String formatMessage(LogLevel level, String message){
        return String.format("[%s] [%s] [%s] %s", new java.util.Date(), level, Thread.currentThread().getName(), message);
    }

    public void addAppender(Appender appender){
        appenders.add(appender);
    }

}
