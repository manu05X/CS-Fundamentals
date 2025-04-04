package com.manish.LLD.PropertyPlatformLLD.models;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Property {
    private static int nextId = 1;
    private int id;
    private String title;
    private String location;
    private long price;
    private String originalPriceText;
    private double size;
    private String originalSizeText;
    private String rooms;
    private String listingType;
    private boolean isAvailable = true;
    private User owner;
    private List<String> nearbyLocations = new ArrayList<>();

    public Property(String title, String location, long price, String originalPriceText,
                    double size, String originalSizeText, String rooms,
                    String listingType, User owner) {
        this.id = nextId++;
        this.title = title;
        this.location = location;
        this.price = price;
        this.originalPriceText = originalPriceText;
        this.size = size;
        this.originalSizeText = originalSizeText;
        this.rooms = rooms;
        this.listingType = listingType;
        this.owner = owner;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getLocation() { return location; }
    public long getPrice() { return price; }
    public String getOriginalPriceText() { return originalPriceText; }
    public double getSize() { return size; }
    public String getOriginalSizeText() { return originalSizeText; }
    public String getRooms() { return rooms; }
    public String getListingType() { return listingType; }
    public boolean isAvailable() { return isAvailable; }
    public User getOwner() { return owner; }
    public List<String> getNearbyLocations() { return new ArrayList<>(nearbyLocations); }

    public void setAvailable(boolean available) { isAvailable = available; }
    public void setNearbyLocations(List<String> locations) { nearbyLocations = new ArrayList<>(locations); }

    public String toSearchResultString() {
        return String.format("%d\t%s\t%s\t%s\t%.0fsqft\t%s\t%s",
                id, title, location, originalPriceText, size, rooms,
                listingType.equals("sell") ? "Sale" : "Rent");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return id == property.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
