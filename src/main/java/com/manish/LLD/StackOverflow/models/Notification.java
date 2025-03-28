package com.manish.LLD.StackOverflow.models;

import java.time.LocalDateTime;

// Notification class
public class Notification {
    private int notificationId;
    private int userId;
    private String content;
    private boolean isRead;
    private LocalDateTime createdAt;

    public Notification(int notificationId, int userId, String content) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.content = content;
        this.isRead = false;
        this.createdAt = LocalDateTime.now();
    }

    // Getters
    public int getNotificationId() {
        return notificationId;
    }

    public int getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public boolean isRead() {
        return isRead;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void markAsRead() {
        this.isRead = true;
    }
}
