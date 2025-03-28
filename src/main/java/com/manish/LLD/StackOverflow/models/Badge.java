package com.manish.LLD.StackOverflow.models;

// Badge class
public class Badge {
    private int badgeId;
    private String name;
    private String description;

    public Badge(int badgeId, String name, String description) {
        this.badgeId = badgeId;
        this.name = name;
        this.description = description;
    }

    // Getters
    public int getBadgeId() {
        return badgeId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
