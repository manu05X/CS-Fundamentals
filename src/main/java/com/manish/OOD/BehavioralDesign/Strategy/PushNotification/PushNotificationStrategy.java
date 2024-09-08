package com.manish.OOD.BehavioralDesign.Strategy.PushNotification;

// First, let's create the interface PushNotificationStrategy that defines the common method sendPushNotification():
public interface PushNotificationStrategy {
    void sendPushNotification(String message);
}
