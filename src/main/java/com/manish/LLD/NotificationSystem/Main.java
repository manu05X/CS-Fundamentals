package com.manish.LLD.NotificationSystem;

public class Main {
    public static void main(String[] args) {
        NotificationManager notificationManager = new NotificationManager(10);

        MetricAlarm alarm = new MetricAlarm("CPU Usage High", notificationManager);

        alarm.addSubscriber(new EmailSubscriber("user@example.com"));
        alarm.addSubscriber(new SmsSubscriber("+1234567890"));

        alarm.setState("ALARM");

        notificationManager.shutDown();
    }
}
