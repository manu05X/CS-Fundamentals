package com.manish.LLD.PropertyPlatformLLD.Type2.model;

import java.util.Date;

public class Shortlist {
    private User user;
    private Property property;
    private Date dateAdded;

    public Shortlist(User user, Property property) {
        this.user = user;
        this.property = property;
        this.dateAdded = new Date();
    }

    // Getters
    public User getUser() { return user; }
    public Property getProperty() { return property; }
    public Date getDateAdded() { return dateAdded; }
}