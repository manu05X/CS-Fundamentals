package com.manish.LLD.StackOverflow.models;

// Tag class
public class Tag {
    private int tagId;
    private String name;
    private String description;

    public Tag(int tagId, String name, String description) {
        this.tagId = tagId;
        this.name = name;
        this.description = description;
    }

    // Getters
    public int getTagId() {
        return tagId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
