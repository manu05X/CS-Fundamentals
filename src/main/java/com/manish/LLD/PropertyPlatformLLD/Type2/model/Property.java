package com.manish.LLD.PropertyPlatformLLD.Type2.model;


import java.util.List;


public class Property {
    private static int nextId = 1;

    private int id;
    private String title;
    private User owner;
    private String location;
    private List<String> nearbyLocations;
    private double price;
    private String priceDisplay;
    private ListingType listingType;
    private double size;
    private String sizeDisplay;
    private int rooms;
    private boolean isAvailable;

    public Property(String title, User owner, String location, List<String> nearbyLocations,
                    double price, String priceDisplay, ListingType listingType,
                    double size, String sizeDisplay, int rooms) {
        this.id = nextId++;
        this.title = title;
        this.owner = owner;
        this.location = location;
        this.nearbyLocations = nearbyLocations;
        this.price = price;
        this.priceDisplay = priceDisplay;
        this.listingType = listingType;
        this.size = size;
        this.sizeDisplay = sizeDisplay;
        this.rooms = rooms;
        this.isAvailable = true;
    }

    // Getters and setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public User getOwner() { return owner; }
    public String getLocation() { return location; }
    public List<String> getNearbyLocations() { return nearbyLocations; }
    public double getPrice() { return price; }
    public String getPriceDisplay() { return priceDisplay; }
    public ListingType getListingType() { return listingType; }
    public double getSize() { return size; }
    public String getSizeDisplay() { return sizeDisplay; }
    public int getRooms() { return rooms; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}