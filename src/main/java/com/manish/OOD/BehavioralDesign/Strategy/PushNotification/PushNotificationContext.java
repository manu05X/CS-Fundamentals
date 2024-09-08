package com.manish.OOD.BehavioralDesign.Strategy.PushNotification;

// Now, let's create the PushNotificationContext class that accepts a specific PushNotificationStrategy and uses it to send push notifications:
public class PushNotificationContext {
    private PushNotificationStrategy strategy;

    public PushNotificationContext(PushNotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PushNotificationStrategy strategy) {
        this.strategy = strategy;
    }

    public void sendPushNotification(String message) {
        strategy.sendPushNotification(message);
    }
}
