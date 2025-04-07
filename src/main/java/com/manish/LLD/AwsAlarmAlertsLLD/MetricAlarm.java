package com.manish.LLD.AwsAlarmAlertsLLD;

import java.util.ArrayList;
import java.util.List;

public class MetricAlarm implements Alarm{
    private List<Subscriber> subscribers = new ArrayList<>();
    private String state;
    private String alarmMessage;

    public MetricAlarm(String initialMessage){
        this.alarmMessage = initialMessage;
        this.state = "OK";
    }

    public void setState(String newState){
        this.state = newState;
        notifySubscribers();
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
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers){
            subscriber.notify(alarmMessage + " - Current State: " + state);
        }
    }
}
