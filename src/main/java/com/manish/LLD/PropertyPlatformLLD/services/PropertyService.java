package com.manish.LLD.PropertyPlatformLLD.services;


import com.manish.LLD.PropertyPlatformLLD.models.Property;
import com.manish.LLD.PropertyPlatformLLD.models.User;
import com.manish.LLD.PropertyPlatformLLD.util.InputParser;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PropertyService {
    private List<Property> properties = new ArrayList<>();
    private UserService userService;
    private InputParser inputParser = new InputParser();
    private SearchService searchService;

    public PropertyService(UserService userService) {
        this.userService = userService;
        this.inputParser = new InputParser();
        this.searchService = new SearchService(properties, inputParser);
    }

    public void listProperty(Scanner scanner) {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            System.out.println("← Please login first");
            return;
        }

        System.out.println("← Enter the property details:");
        System.out.print("→ title ");
        String title = scanner.nextLine().trim();

        System.out.print("→ location ");
        String location = scanner.nextLine().trim().toLowerCase();

        System.out.print("→ price ");
        String priceText = scanner.nextLine().trim();
        long price = inputParser.parsePrice(priceText);

        System.out.print("→ type (sell/rent) ");
        String type = scanner.nextLine().trim().toLowerCase();
        if (!type.equals("sell") && !type.equals("rent")) {
            System.out.println("← Invalid type. Must be 'sell' or 'rent'");
            return;
        }

        System.out.print("→ size ");
        String sizeText = scanner.nextLine().trim();
        double size = inputParser.parseSize(sizeText);

        System.out.print("→ rooms ");
        String rooms = scanner.nextLine().trim().toUpperCase();
        if (!rooms.matches("\\d+BHK")) {
            System.out.println("← Invalid room format. Must be like '2BHK'");
            return;
        }

        System.out.print("→ nearby (optional, separated by |) ");
        String nearbyInput = scanner.nextLine().trim();
        List<String> nearbyLocations = new ArrayList<>();
        if (!nearbyInput.isEmpty()) {
            nearbyLocations = List.of(nearbyInput.split("\\|"))
                    .stream()
                    .map(String::trim)
                    .map(String::toLowerCase)
                    .collect(Collectors.toList());
        }

        Property property = new Property(
                title, location, price, priceText,
                size, sizeText, rooms, type, currentUser
        );
        property.setNearbyLocations(nearbyLocations);
        properties.add(property);

        System.out.println("← Listing created successfully. ID: " + property.getId());
    }

    // Other methods (searchProperties, shortlistProperty, etc.) would follow similar pattern
    // Implement the remaining methods following the same structure
    public void searchProperties(Scanner scanner) {
        searchService.searchProperties(scanner);
    }

    public void shortlistProperty(Scanner scanner) {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            System.out.println("← Please login first");
            return;
        }

        System.out.print("← Enter property ID to shortlist: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("← Invalid ID");
            return;
        }

        Property property = properties.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);

        if (property == null) {
            System.out.println("← Property not found");
            return;
        }

        currentUser.addToShortlist(property);
        System.out.println("← Shortlisted");
    }

    public void viewShortlisted() {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            System.out.println("← Please login first");
            return;
        }

        List<Property> shortlisted = currentUser.getShortlistedProperties();
        if (shortlisted.isEmpty()) {
            System.out.println("← No properties in your shortlist");
            return;
        }

        System.out.println("← Id\tTitle\t\tLocation\tPrice\tSize\tRooms\tAvailableFor\tStatus");
        shortlisted.forEach(p -> {
            String status = p.isAvailable() ? "Available" : "Sold";
            System.out.println(p.toSearchResultString() + "\t" + status);
        });
    }

    public void viewListed() {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            System.out.println("← Please login first");
            return;
        }

        List<Property> listed = properties.stream()
                .filter(p -> p.getOwner().equals(currentUser))
                .collect(Collectors.toList());

        if (listed.isEmpty()) {
            System.out.println("← You haven't listed any properties");
            return;
        }

        System.out.println("← Id\tTitle\t\tLocation\tPrice\tSize\tRooms\tAvailableFor\tStatus");
        listed.forEach(p -> {
            String status = p.isAvailable() ? "Available" : "Sold";
            System.out.println(p.toSearchResultString() + "\t" + status);
        });
    }

    public void markSold(Scanner scanner) {
        User currentUser = userService.getCurrentUser();
        if (currentUser == null) {
            System.out.println("← Please login first");
            return;
        }

        System.out.print("← Enter property ID to mark as sold: ");
        int id;
        try {
            id = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("← Invalid ID");
            return;
        }

        Property property = properties.stream()
                .filter(p -> p.getId() == id && p.getOwner().equals(currentUser))
                .findFirst()
                .orElse(null);

        if (property == null) {
            System.out.println("← Property not found or you don't own it");
            return;
        }

        property.setAvailable(false);
        System.out.println("← Property marked as sold");
    }
}
