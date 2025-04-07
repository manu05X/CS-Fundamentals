package com.manish.LLD.AwsAlarmAlertsLLD;

public class AlarmBuilder {
    private String metricName;
    private double threshold;
    private String condition;
    private MetricAlarm alarm;

    public AlarmBuilder(String metricName, double threshold, String condition) {
        this.metricName = metricName;
        this.threshold = threshold;
        this.condition = condition;
    }

    public AlarmBuilder setAlarmMessage(String alarmMessage){
        this.alarm = new MetricAlarm(alarmMessage);
        return this;
    }


    public AlarmBuilder addSubscriber(Subscriber subscriber){
        if(alarm != null){
            alarm.addSubscriber(subscriber);
        }

        return this;
    }

    public MetricAlarm build(){
        if(alarm == null){
            throw new IllegalArgumentException("Alarm message must be Set");
        }
        return alarm;
    }
}
