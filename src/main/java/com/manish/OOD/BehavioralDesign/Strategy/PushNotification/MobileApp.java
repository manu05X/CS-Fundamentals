package com.manish.OOD.BehavioralDesign.Strategy.PushNotification;

// Finally, let's create the MobileApp class that uses the PushNotificationContext to send push notifications to its users on different platforms:
public class MobileApp {
    private PushNotificationContext context;

    public MobileApp(PushNotificationStrategy strategy) {
        this.context = new PushNotificationContext(strategy);
    }

    public void setPushNotificationStrategy(PushNotificationStrategy strategy) {
        this.context.setStrategy(strategy);
    }

    public void sendPushNotification(String message) {
        context.sendPushNotification(message);
    }
}
