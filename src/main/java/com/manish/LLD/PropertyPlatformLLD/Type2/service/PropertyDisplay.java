package com.manish.LLD.PropertyPlatformLLD.Type2.service;

import com.manish.LLD.PropertyPlatformLLD.Type2.model.Property;

import java.util.List;

public class PropertyDisplay {
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