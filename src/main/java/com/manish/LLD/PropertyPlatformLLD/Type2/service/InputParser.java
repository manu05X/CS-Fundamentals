package com.manish.LLD.PropertyPlatformLLD.Type2.service;

import java.util.*;
import java.util.stream.Collectors;

public class InputParser {
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