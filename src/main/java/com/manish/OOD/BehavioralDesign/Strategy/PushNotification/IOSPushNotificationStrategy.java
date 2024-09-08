package com.manish.OOD.BehavioralDesign.Strategy.PushNotification;

// Next, let's create the concrete classes that implement this interface for each platform:
public class IOSPushNotificationStrategy implements PushNotificationStrategy {
    @Override
    public void sendPushNotification(String message) {
        // Send push notification using iOS push notification service
        System.out.println("Sending push notification to iOS devices: " + message);
    }
}
