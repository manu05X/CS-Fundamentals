package com.manish.LLD.PropertyPlatformLLD.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private static int nextId = 1;
    private int id;
    private String name;
    private List<Property> shortlistedProperties = new ArrayList<>();

    public User(String name) {
        this.id = nextId++;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public void addToShortlist(Property property) {
        if (!shortlistedProperties.contains(property)) {
            shortlistedProperties.add(property);
        }
    }

    public List<Property> getShortlistedProperties() {
        return new ArrayList<>(shortlistedProperties);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
