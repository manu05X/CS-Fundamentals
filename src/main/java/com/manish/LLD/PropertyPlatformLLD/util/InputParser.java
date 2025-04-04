package com.manish.LLD.PropertyPlatformLLD.util;


public class InputParser {
    public long parsePrice(String priceText) {
        priceText = priceText.trim().toLowerCase();

        try {
            if (priceText.endsWith("l")) {
                return (long)(Double.parseDouble(priceText.replace("l", "")) * 100000);
            } else if (priceText.endsWith("cr")) {
                return (long)(Double.parseDouble(priceText.replace("cr", "")) * 10000000);
            } else if (priceText.endsWith("k")) {
                return (long)(Double.parseDouble(priceText.replace("k", "")) * 1000);
            } else {
                return Long.parseLong(priceText);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid price format");
        }
    }

    public double parseSize(String sizeText) {
        sizeText = sizeText.trim().toLowerCase();

        try {
            if (sizeText.endsWith("sqm") || sizeText.endsWith("sq.m") || sizeText.endsWith("sq meter")) {
                double value = Double.parseDouble(sizeText.replaceAll("[^0-9.]", ""));
                return value * 10.764; // Convert sqm to sqft
            } else if (sizeText.endsWith("sqy") || sizeText.endsWith("sq.y") || sizeText.endsWith("sq yard")) {
                double value = Double.parseDouble(sizeText.replaceAll("[^0-9.]", ""));
                return value * 9; // Convert sq yard to sqft
            } else if (sizeText.endsWith("sqft") || sizeText.endsWith("sq.ft") || sizeText.endsWith("sq ft")) {
                return Double.parseDouble(sizeText.replaceAll("[^0-9.]", ""));
            } else {
                // Assume sqft if no unit specified
                return Double.parseDouble(sizeText.replaceAll("[^0-9.]", ""));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid size format");
        }
    }
}
