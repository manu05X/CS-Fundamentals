package com.manish.OOD.BehavioralDesign.Strategy.PushNotification;

public class AndroidPushNotificationStrategy implements PushNotificationStrategy {
    @Override
    public void sendPushNotification(String message) {
        // Send push notification using Android push notification service
        System.out.println("Sending push notification to Android devices: " + message);
    }
}
