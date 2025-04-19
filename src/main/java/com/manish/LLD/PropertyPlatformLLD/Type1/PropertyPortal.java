package com.manish.LLD.PropertyPlatformLLD.Type1;

import java.util.*;
import java.util.stream.Collectors;

enum ListingType {
    SELL, RENT
}

class User {
    private String username;
    private boolean isActive;

    public User(String username) {
        this.username = username;
        this.isActive = false;
    }

    public String getUsername() {
        return username;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

class Property {
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

    // Getters
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

class Shortlist {
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

class SearchCriteria {
    private List<String> locations;
    private Double minPrice;
    private Double maxPrice;
    private ListingType listingType;
    private Double minSize;
    private Double maxSize;
    private List<Integer> rooms;
    private String sortBy;

    // Getters and setters
    public List<String> getLocations() { return locations; }
    public void setLocations(List<String> locations) { this.locations = locations; }
    public Double getMinPrice() { return minPrice; }
    public void setMinPrice(Double minPrice) { this.minPrice = minPrice; }
    public Double getMaxPrice() { return maxPrice; }
    public void setMaxPrice(Double maxPrice) { this.maxPrice = maxPrice; }
    public ListingType getListingType() { return listingType; }
    public void setListingType(ListingType listingType) { this.listingType = listingType; }
    public Double getMinSize() { return minSize; }
    public void setMinSize(Double minSize) { this.minSize = minSize; }
    public Double getMaxSize() { return maxSize; }
    public void setMaxSize(Double maxSize) { this.maxSize = maxSize; }
    public List<Integer> getRooms() { return rooms; }
    public void setRooms(List<Integer> rooms) { this.rooms = rooms; }
    public String getSortBy() { return sortBy; }
    public void setSortBy(String sortBy) { this.sortBy = sortBy; }
}

class InputParser {
    public static double parsePrice(String priceStr) {
        priceStr = priceStr.toLowerCase();
        try {
            if (priceStr.endsWith("l")) {
                return Double.parseDouble(priceStr.substring(0, priceStr.length() - 1)) * 100000;
            } else if (priceStr.endsWith("k")) {
                return Double.parseDouble(priceStr.substring(0, priceStr.length() - 1)) * 1000;
            } else if (priceStr.endsWith("cr")) {
                return Double.parseDouble(priceStr.substring(0, priceStr.length() - 2)) * 10000000;
            } else {
                return Double.parseDouble(priceStr);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid price format: " + priceStr);
        }
    }

    public static double parseSize(String sizeStr) {
        sizeStr = sizeStr.toLowerCase();
        try {
            if (sizeStr.contains("sqft")) {
                return Double.parseDouble(sizeStr.replace("sqft", ""));
            } else if (sizeStr.contains("sqm")) {
                return Double.parseDouble(sizeStr.replace("sqm", "")) * 10.764;
            } else if (sizeStr.contains("sqyd")) {
                return Double.parseDouble(sizeStr.replace("sqyd", "")) * 9;
            } else {
                return Double.parseDouble(sizeStr);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid size format: " + sizeStr);
        }
    }

    public static List<String> parseLocations(String locationsStr) {
        return Arrays.stream(locationsStr.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static List<String> parseNearbyLocations(String nearbyStr) {
        if (nearbyStr == null || nearbyStr.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.stream(nearbyStr.split("\\|"))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public static int parseRooms(String roomsStr) {
        return Integer.parseInt(roomsStr.replace("BHK", "").trim());
    }
}


class PropertyDisplay {
    public static void displayProperties(List<Property> properties, boolean showStatus) {
        if (properties.isEmpty()) {
            System.out.println("No properties found");
            return;
        }

        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("%-4s %-30s %-15s %-10s %-10s %-6s %-12s",
                "Id", "Title", "Location", "Price", "Size", "Rooms", "Type");
        if (showStatus) {
            System.out.printf(" %-10s", "Status");
        }
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");

        for (Property property : properties) {
            System.out.printf("%-4d %-30s %-15s %-10s %-10s %-6dBHK %-12s",
                    property.getId(),
                    safeTruncate(property.getTitle(), 28),
                    safeTruncate(property.getLocation(), 13),
                    safeString(property.getPriceDisplay()),
                    safeString(property.getSizeDisplay()),
                    property.getRooms(),
                    safeString(property.getListingType().toString()));

            if (showStatus) {
                System.out.printf(" %-10s", property.isAvailable() ? "Available" : "Sold");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    private static String safeTruncate(String str, int length) {
        if (str == null) return "";
        return str.length() > length ? str.substring(0, length-3) + "..." : str;
    }

    private static String safeString(String str) {
        return str == null ? "" : str;
    }
}


class PropertyPlatform {
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

public class PropertyPortal {
    public static void main(String[] args) {
                PropertyPlatform platform = new PropertyPlatform();
                Scanner scanner = new Scanner(System.in);

                System.out.println("Welcome to Property Portal Console App");
                System.out.println("Available commands: register, login, logout, list, search, shortlist, myshortlist, mylistings, marksold, exit");
                System.out.println("Type 'help' for command usage");

                while (true) {
                    System.out.print("\n> ");
                    String input = scanner.nextLine().trim();
                    if (input.isEmpty()) continue;

                    String[] parts = input.split(" ", 2);
                    String command = parts[0].toLowerCase();
                    String params = parts.length > 1 ? parts[1].trim() : "";

            try {
                switch (command) {
                    case "register":
                        if (params.isEmpty()) {
                            System.out.println("Usage: register <username>");
                            break;
                        }
                        platform.register(params);
                        break;

                    case "login":
                        if (params.isEmpty()) {
                            System.out.println("Usage: login <username>");
                            break;
                        }
                        platform.login(params);
                        break;

                    case "logout":
                        platform.logout();
                        break;

                    case "list":
                        System.out.println("Enter property details in format:");
                        System.out.println("title:<title>, location:<location>, nearby:<loc1|loc2|...>, price:<price>, type:<sell/rent>, size:<size>, rooms:<nBHK>");
                        System.out.print("> ");
                        String details = scanner.nextLine().trim();
                        parseAndListProperty(platform, details);
                        break;

                    case "search":
                        System.out.println("Enter search criteria (any combination):");
                        System.out.println("location:<loc1,loc2,...>, pricerange:<min-max>, type:<sell/rent>, sizerange:<min-max>, rooms:<n1,n2,...>, sort:<price/size>");
                        System.out.print("> ");
                        String searchParams = scanner.nextLine().trim();
                        SearchCriteria criteria = parseSearchCriteria(searchParams);
                        platform.search(criteria);
                        break;

                    case "shortlist":
                        if (params.isEmpty()) {
                            System.out.println("Usage: shortlist <propertyId>");
                            break;
                        }
                        try {
                            int propertyId = Integer.parseInt(params);
                            platform.shortlist(propertyId);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid property ID");
                        }
                        break;

                    case "myshortlist":
                        platform.viewShortlisted();
                        break;

                    case "mylistings":
                        platform.viewListed();
                        break;

                    case "marksold":
                        if (params.isEmpty()) {
                            System.out.println("Usage: marksold <propertyId>");
                            break;
                        }
                        try {
                            int propertyId = Integer.parseInt(params);
                            platform.markSold(propertyId);
                        } catch (NumberFormatException e) {
                            System.out.println("Error: Invalid property ID");
                        }
                        break;

                    case "help":
                        printHelp();
                        break;

                    case "exit":
                        System.out.println("Exiting Property Portal. Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Error: Unknown command. Type 'help' for available commands.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void printHelp() {
        System.out.println("\nAvailable Commands:");
        System.out.println("  register <username>      - Register a new user");
        System.out.println("  login <username>        - Login as a user");
        System.out.println("  logout                  - Logout current user");
        System.out.println("  list                    - List a new property for sale/rent");
        System.out.println("  search                  - Search for properties with filters");
        System.out.println("  shortlist <propertyId>  - Shortlist a property");
        System.out.println("  myshortlist             - View your shortlisted properties");
        System.out.println("  mylistings              - View properties listed by you");
        System.out.println("  marksold <propertyId>   - Mark your property as sold");
        System.out.println("  exit                    - Exit the application");
        System.out.println("  help                    - Show this help message");
    }

    private static void parseAndListProperty(PropertyPlatform platform, String details) {
        Map<String, String> params = new HashMap<>();
        String[] parts = details.split(",");
        for (String part : parts) {
            String[] keyValue = part.trim().split(":", 2);
            if (keyValue.length == 2) {
                params.put(keyValue[0].trim().toLowerCase(), keyValue[1].trim());
            }
        }

        try {
            platform.listProperty(
                    params.get("title"),
                    params.get("location"),
                    params.get("nearby"),
                    params.get("price"),
                    params.get("type"),
                    params.get("size"),
                    params.get("rooms")
            );
        } catch (Exception e) {
            System.out.println("Error: Missing or invalid property details. Required fields: title, location, price, type, size, rooms");
        }
    }

    private static SearchCriteria parseSearchCriteria(String searchParams) {
        SearchCriteria criteria = new SearchCriteria();
        String[] parts = searchParams.split(",");

        for (String part : parts) {
            String[] keyValue = part.trim().split(":", 2);
            if (keyValue.length == 2) {
                String key = keyValue[0].trim().toLowerCase();
                String value = keyValue[1].trim();

                try {
                    switch (key) {
                        case "location":
                            criteria.setLocations(InputParser.parseLocations(value));
                            break;
                        case "pricerange":
                            String[] priceRange = value.split("-");
                            if (priceRange.length == 2) {
                                criteria.setMinPrice(InputParser.parsePrice(priceRange[0]));
                                criteria.setMaxPrice(InputParser.parsePrice(priceRange[1]));
                            }
                            break;
                        case "type":
                            criteria.setListingType(ListingType.valueOf(value.toUpperCase()));
                            break;
                        case "sizerange":
                            String[] sizeRange = value.split("-");
                            if (sizeRange.length == 2) {
                                criteria.setMinSize(InputParser.parseSize(sizeRange[0]));
                                criteria.setMaxSize(InputParser.parseSize(sizeRange[1]));
                            }
                            break;
                        case "rooms":
                            criteria.setRooms(Arrays.stream(value.split(","))
                                    .map(s -> Integer.parseInt(s.replace("BHK", "").trim()))
                                    .collect(Collectors.toList()));
                            break;
                        case "sort":
                            criteria.setSortBy(value);
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("Warning: Invalid " + key + " value - " + e.getMessage());
                }
            }
        }

        return criteria;
    }
}