package com.manish.LLD.AwsAlarmAlertsLLD;

public class EmailSubscriber implements Subscriber{
    private String email;

    public EmailSubscriber(String email){
        this.email = email;
    }

    @Override
    public void notify(String message){
        System.out.println("Email sent to "+email + ": "+message);
    }
}
