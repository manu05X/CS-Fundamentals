package com.manish.LLD.PropertyPlatformLLD.Type2.model;

public class User {
    private String username;
    private boolean isActive;

    public User(String username) {
        this.username = username;
        this.isActive = false;
    }

    // Getters and setters
    public String getUsername() { return username; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}