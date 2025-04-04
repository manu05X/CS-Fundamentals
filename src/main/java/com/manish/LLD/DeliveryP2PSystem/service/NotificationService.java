package com.manish.LLD.DeliveryP2PSystem.service;

import com.manish.LLD.DeliveryP2PSystem.enums.NotificationType;

public class NotificationService {
    public void sendNotification(String email, String phone,
                                 NotificationType type, String message) {
        System.out.printf("[Notification] To: %s/%s | Type: %s | Message: %s%n",
                email, phone, type, message);
    }
}
