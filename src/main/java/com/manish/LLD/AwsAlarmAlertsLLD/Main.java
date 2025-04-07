package com.manish.LLD.AwsAlarmAlertsLLD;

public class Main {
    public static void main(String[] args) {
        MetricAlarm alarm = new AlarmBuilder("CPU", 80, "GreaterThan")
                .setAlarmMessage("CPU usage exceeded threshold!")
                .addSubscriber(new EmailSubscriber("example123@gxmail.com"))
                .addSubscriber(new SmsSubscriber("+123456789"))
                .build();

        alarm.setState("ALARM");
    }
}
