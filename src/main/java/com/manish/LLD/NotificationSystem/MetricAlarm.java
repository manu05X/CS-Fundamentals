package com.manish.LLD.NotificationSystem;

import java.util.ArrayList;
import java.util.List;

public class MetricAlarm implements Alarm{
    private final List<Subscriber> subscribers = new ArrayList<>();
    private final NotificationManager notificationManager;
    private String state;
    private String alarmMessage;

    public MetricAlarm(String initialMessage, NotificationManager notificationManager){
        this.alarmMessage = initialMessage;
        this.state = "OK";
        this.notificationManager = notificationManager;
    }

    public void setState(String newState){
        this.state = newState;
        notifySubscriber();
    }

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscriber() {
        for (Subscriber subscriber : subscribers){
            notificationManager.notifySubscriber(subscriber, alarmMessage + " - Current State: " + state);
        }
    }
}
