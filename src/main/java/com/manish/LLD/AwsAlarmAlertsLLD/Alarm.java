package com.manish.LLD.AwsAlarmAlertsLLD;

public interface Alarm {
    public void addSubscriber(Subscriber subscriber);
    public void removeSubscriber(Subscriber subscriber);

    public void notifySubscribers();
}
