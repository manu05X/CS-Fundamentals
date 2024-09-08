package com.manish.OOD.BehavioralDesign.Strategy.PushNotification;

// Here's how you can use these classes to send push notifications to users on different platforms:
public class Main {
    public static void main(String[] args) {
        // Create a mobile app instance with the default push notification strategy (iOS)
        MobileApp app = new MobileApp(new IOSPushNotificationStrategy());

        // Send push notification to all users using the default strategy (iOS)
        app.sendPushNotification("New update available!");

        // Change the push notification strategy to Android
        app.setPushNotificationStrategy(new AndroidPushNotificationStrategy());

        // Send push notification to all users using the Android strategy
        app.sendPushNotification("New update available!");

        // Change the push notification strategy to Windows
        app.setPushNotificationStrategy(new WindowsPushNotificationStrategy());

        // Send push notification to all users using the Windows strategy
        app.sendPushNotification("New update available!");
    }
}
