package com.manish.LLD.NotificationSystem;

public class SmsSubscriber implements Subscriber{
    private String phoneNumber;

    public SmsSubscriber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void notify(String message) {
        System.out.println("SMS sent to "+phoneNumber+": "+ message);
    }
}
