package com.manish.LLD.PropertyPlatformLLD.Type2.service;

import com.manish.LLD.PropertyPlatformLLD.Type2.model.*;
import java.util.*;
import java.util.stream.Collectors;

public class PropertyPlatform {
    private Map<String, User> users = new HashMap<>();
    private List<Property> properties = new ArrayList<>();
    private List<Shortlist> shortlists = new ArrayList<>();
    private User currentUser = null;

    public void register(String username) {
        if (users.containsKey(username)) {
            System.out.println("Error: Username already exists");
            return;
        }
        users.put(username, new User(username));
        System.out.println("Success: User registered successfully");
    }

    public void login(String username) {
        User user = users.get(username);
        if (user == null) {
            System.out.println("Error: User not found");
            return;
        }
        if (currentUser != null) {
            currentUser.setActive(false);
        }
        currentUser = user;
        currentUser.setActive(true);
        System.out.println("Success: Welcome " + username);
    }

    public void logout() {
        if (currentUser == null) {
            System.out.println("Error: No user is logged in");
            return;
        }
        System.out.println("Success: Logged out " + currentUser.getUsername());
        currentUser.setActive(false);
        currentUser = null;
    }

    public void listProperty(String title, String location, String nearbyLocationsStr,
                           String priceStr, String typeStr, String sizeStr, String roomsStr) {
        if (currentUser == null) {
            System.out.println("Error: You need to login first");
            return;
        }

        try {
            List<String> nearbyLocations = InputParser.parseNearbyLocations(nearbyLocationsStr);
            double price = InputParser.parsePrice(priceStr);
            ListingType type = ListingType.valueOf(typeStr.toUpperCase());
            double size = InputParser.parseSize(sizeStr);
            int rooms = InputParser.parseRooms(roomsStr);

            Property property = new Property(title, currentUser, location, nearbyLocations,
                                           price, priceStr, type, size, sizeStr, rooms);
            properties.add(property);
            System.out.println("Success: Listing created with ID " + property.getId());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void search(SearchCriteria criteria) {
        List<Property> results = properties.stream()
            .filter(Property::isAvailable)
            .filter(p -> criteria.getLocations() == null || criteria.getLocations().isEmpty() || 
                         criteria.getLocations().contains(p.getLocation().toLowerCase()) ||
                         p.getNearbyLocations().stream()
                          .anyMatch(loc -> criteria.getLocations().contains(loc.toLowerCase())))
            .filter(p -> criteria.getMinPrice() == null || p.getPrice() >= criteria.getMinPrice())
            .filter(p -> criteria.getMaxPrice() == null || p.getPrice() <= criteria.getMaxPrice())
            .filter(p -> criteria.getListingType() == null || p.getListingType() == criteria.getListingType())
            .filter(p -> criteria.getMinSize() == null || p.getSize() >= criteria.getMinSize())
            .filter(p -> criteria.getMaxSize() == null || p.getSize() <= criteria.getMaxSize())
            .filter(p -> criteria.getRooms() == null || criteria.getRooms().isEmpty() || 
                         criteria.getRooms().contains(p.getRooms()))
            .collect(Collectors.toList());

        if (criteria.getSortBy() != null) {
            if ("price".equalsIgnoreCase(criteria.getSortBy())) {
                results.sort(Comparator.comparingDouble(Property::getPrice));
            } else if ("size".equalsIgnoreCase(criteria.getSortBy())) {
                results.sort(Comparator.comparingDouble(Property::getSize));
            }
        }

        System.out.println("Search Results (" + results.size() + " properties found):");
        PropertyDisplay.displayProperties(results, false);
    }

    public void shortlist(int propertyId) {
        if (currentUser == null) {
            System.out.println("Error: You need to login first");
            return;
        }

        Property property = properties.stream()
            .filter(p -> p.getId() == propertyId)
            .findFirst()
            .orElse(null);

        if (property == null) {
            System.out.println("Error: Property not found");
            return;
        }

        boolean alreadyShortlisted = shortlists.stream()
            .anyMatch(s -> s.getUser().equals(currentUser) && s.getProperty().equals(property));

        if (alreadyShortlisted) {
            System.out.println("Error: Property already shortlisted");
            return;
        }

        shortlists.add(new Shortlist(currentUser, property));
        System.out.println("Success: Property " + propertyId + " shortlisted");
    }

    public void viewShortlisted() {
        if (currentUser == null) {
            System.out.println("Error: You need to login first");
            return;
        }

        List<Property> shortlistedProperties = shortlists.stream()
            .filter(s -> s.getUser().equals(currentUser))
            .map(Shortlist::getProperty)
            .collect(Collectors.toList());

        System.out.println("Your Shortlisted Properties (" + shortlistedProperties.size() + "):");
        PropertyDisplay.displayProperties(shortlistedProperties, true);
    }

    public void viewListed() {
        if (currentUser == null) {
            System.out.println("Error: You need to login first");
            return;
        }

        List<Property> listedProperties = properties.stream()
            .filter(p -> p.getOwner().equals(currentUser))
            .collect(Collectors.toList());

        System.out.println("Your Listed Properties (" + listedProperties.size() + "):");
        PropertyDisplay.displayProperties(listedProperties, true);
    }

    public void markSold(int propertyId) {
        if (currentUser == null) {
            System.out.println("Error: You need to login first");
            return;
        }

        Property property = properties.stream()
            .filter(p -> p.getId() == propertyId && p.getOwner().equals(currentUser))
            .findFirst()
            .orElse(null);

        if (property == null) {
            System.out.println("Error: Property not found or you don't own it");
            return;
        }

        if (!property.isAvailable()) {
            System.out.println("Error: Property is already marked as sold");
            return;
        }

        property.setAvailable(false);
        System.out.println("Success: Property " + propertyId + " marked as sold");
    }
}