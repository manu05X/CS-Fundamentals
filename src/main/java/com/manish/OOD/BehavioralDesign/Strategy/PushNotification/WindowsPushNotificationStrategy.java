package com.manish.OOD.BehavioralDesign.Strategy.PushNotification;

public class WindowsPushNotificationStrategy implements PushNotificationStrategy {
    @Override
    public void sendPushNotification(String message) {
        // Send push notification using Windows push notification service
        System.out.println("Sending push notification to Windows devices: " + message);
    }
}
