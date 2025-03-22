package com.manish.LLD.NotificationSystem;

public interface Alarm {
    public void addSubscriber(Subscriber subscriber);
    public void removeSubscriber(Subscriber subscriber);
    public void notifySubscriber();
}
