package com.manish.LLD.PropertyPlatformLLD.util;

public class UnitConverter {
    // Conversion constants
    public static final double SQFT_TO_SQM = 0.092903;
    public static final double SQFT_TO_SQYARD = 0.111111;
    public static final double SQM_TO_SQFT = 10.7639;
    public static final double SQYARD_TO_SQFT = 9.0;

    // Price conversion constants
    public static final long LAKH = 100000;
    public static final long CRORE = 10000000;
    public static final long THOUSAND = 1000;

    /**
     * Converts area from one unit to another
     * @param value The value to convert
     * @param fromUnit Original unit ("sqft", "sqm", "sqy")
     * @param toUnit Target unit ("sqft", "sqm", "sqy")
     * @return Converted value
     */
    public static double convertArea(double value, String fromUnit, String toUnit) {
        // Convert to square feet first
        double inSqft;
        switch (fromUnit.toLowerCase()) {
            case "sqm":
            case "sq.m":
            case "square meter":
                inSqft = value * SQM_TO_SQFT;
                break;
            case "sqy":
            case "sq.y":
            case "square yard":
                inSqft = value * SQYARD_TO_SQFT;
                break;
            case "sqft":
            case "sq.ft":
            case "square foot":
            default:
                inSqft = value;
                break;
        }

        // Convert to target unit
        switch (toUnit.toLowerCase()) {
            case "sqm":
            case "sq.m":
            case "square meter":
                return inSqft * SQFT_TO_SQM;
            case "sqy":
            case "sq.y":
            case "square yard":
                return inSqft * SQFT_TO_SQYARD;
            case "sqft":
            case "sq.ft":
            case "square foot":
            default:
                return inSqft;
        }
    }

    /**
     * Normalizes price text to long value (e.g., "40L" → 4000000)
     * @param priceText Price text input
     * @return Numeric value in base units
     */
    public static long normalizePrice(String priceText) {
        priceText = priceText.trim().toLowerCase();

        try {
            if (priceText.endsWith("l")) {
                return (long)(Double.parseDouble(priceText.replace("l", "")) * LAKH);
            } else if (priceText.endsWith("cr")) {
                return (long)(Double.parseDouble(priceText.replace("cr", "")) * CRORE);
            } else if (priceText.endsWith("k")) {
                return (long)(Double.parseDouble(priceText.replace("k", "")) * THOUSAND);
            } else {
                return Long.parseLong(priceText.replaceAll("[^0-9]", ""));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid price format: " + priceText);
        }
    }

    /**
     * Formats a numeric price to human-readable form
     * @param price Numeric price
     * @return Formatted string (e.g., 4000000 → "40L")
     */
    public static String formatPrice(long price) {
        if (price >= CRORE) {
            return (price / CRORE) + "Cr";
        } else if (price >= LAKH) {
            return (price / LAKH) + "L";
        } else if (price >= THOUSAND) {
            return (price / THOUSAND) + "K";
        } else {
            return String.valueOf(price);
        }
    }
}
