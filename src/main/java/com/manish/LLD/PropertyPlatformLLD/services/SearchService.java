package com.manish.LLD.PropertyPlatformLLD.services;


import com.manish.LLD.PropertyPlatformLLD.models.*;
import com.manish.LLD.PropertyPlatformLLD.util.InputParser;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchService {
    private List<Property> properties;
    private InputParser inputParser;

    public SearchService(List<Property> properties, InputParser inputParser) {
        this.properties = properties;
        this.inputParser = inputParser;
    }

    public void searchProperties(Scanner scanner) {
        SearchCriteria criteria = new SearchCriteria();

        System.out.println("← Enter search parameters (comma separated, e.g., location bellandur, pricerange 30000-50000)");
        System.out.print("→ ");
        String input = scanner.nextLine().trim();

        if (!input.isEmpty()) {
            parseSearchInput(input, criteria);
        }

        List<Property> results = performSearch(criteria);
        displaySearchResults(results);
    }

    private void parseSearchInput(String input, SearchCriteria criteria) {
        String[] params = input.split(",");
        for (String param : params) {
            String[] parts = param.trim().split("\\s+", 2);
            if (parts.length != 2) continue;

            String key = parts[0].trim().toLowerCase();
            String value = parts[1].trim();

            switch (key) {
                case "location":
                    criteria.setLocations(parseCommaSeparatedValues(value));
                    break;
                case "pricerange":
                    parsePriceRange(value, criteria);
                    break;
                case "type":
                    criteria.setListingType(value.toLowerCase());
                    break;
                case "sizerange":
                    parseSizeRange(value, criteria);
                    break;
                case "rooms":
                    criteria.setRooms(parseCommaSeparatedValues(value).stream()
                            .map(String::toUpperCase)
                            .collect(Collectors.toList()));
                    break;
                case "sort":
                    criteria.setSortBy(value.toLowerCase());
                    break;
            }
        }
    }

    private List<String> parseCommaSeparatedValues(String input) {
        return List.of(input.split(",")).stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private void parsePriceRange(String input, SearchCriteria criteria) {
        String[] range = input.split("-");
        if (range.length == 2) {
            criteria.setMinPrice(inputParser.parsePrice(range[0].trim()));
            criteria.setMaxPrice(inputParser.parsePrice(range[1].trim()));
        }
    }

    private void parseSizeRange(String input, SearchCriteria criteria) {
        String[] range = input.split("-");
        if (range.length == 2) {
            criteria.setMinSize(inputParser.parseSize(range[0].trim()));
            criteria.setMaxSize(inputParser.parseSize(range[1].trim()));
        }
    }

    private List<Property> performSearch(SearchCriteria criteria) {
        return properties.stream()
                .filter(Property::isAvailable)
                .filter(p -> matchesCriteria(p, criteria))
                .sorted(getComparator(criteria.getSortBy()))
                .collect(Collectors.toList());
    }

    private boolean matchesCriteria(Property property, SearchCriteria criteria) {
        // Location match (including nearby)
        if (!criteria.getLocations().isEmpty()) {
            boolean locationMatch = criteria.getLocations().contains(property.getLocation().toLowerCase()) ||
                    property.getNearbyLocations().stream()
                            .anyMatch(nl -> criteria.getLocations().contains(nl.toLowerCase()));
            if (!locationMatch) return false;
        }

        // Price range
        if (criteria.getMinPrice() != null && property.getPrice() < criteria.getMinPrice()) return false;
        if (criteria.getMaxPrice() != null && property.getPrice() > criteria.getMaxPrice()) return false;

        // Listing type
        if (criteria.getListingType() != null &&
                !property.getListingType().equalsIgnoreCase(criteria.getListingType())) {
            return false;
        }

        // Size range
        if (criteria.getMinSize() != null && property.getSize() < criteria.getMinSize()) return false;
        if (criteria.getMaxSize() != null && property.getSize() > criteria.getMaxSize()) return false;

        // Rooms
        if (!criteria.getRooms().isEmpty() &&
                !criteria.getRooms().contains(property.getRooms().toUpperCase())) {
            return false;
        }

        return true;
    }

    private Comparator<Property> getComparator(String sortBy) {
        if (sortBy == null) return Comparator.comparing(Property::getId);

        switch (sortBy) {
            case "price":
                return Comparator.comparing(Property::getPrice);
            case "size":
                return Comparator.comparing(Property::getSize);
            default:
                return Comparator.comparing(Property::getId);
        }
    }

    private void displaySearchResults(List<Property> results) {
        if (results.isEmpty()) {
            System.out.println("← No properties found matching your criteria");
            return;
        }

        System.out.println("← Id\tTitle\t\tLocation\tPrice\tSize\tRooms\tAvailableFor");
        results.forEach(p -> System.out.println(p.toSearchResultString()));
    }
}
