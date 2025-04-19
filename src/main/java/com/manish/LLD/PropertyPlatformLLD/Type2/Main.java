package com.manish.LLD.PropertyPlatformLLD.Type2;

import com.manish.LLD.PropertyPlatformLLD.Type2.model.ListingType;
import com.manish.LLD.PropertyPlatformLLD.Type2.model.SearchCriteria;
import com.manish.LLD.PropertyPlatformLLD.Type2.service.InputParser;
import com.manish.LLD.PropertyPlatformLLD.Type2.service.PropertyPlatform;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
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