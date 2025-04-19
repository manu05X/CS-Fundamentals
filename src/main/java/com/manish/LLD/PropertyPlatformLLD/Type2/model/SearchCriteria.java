package com.manish.LLD.PropertyPlatformLLD.Type2.model;

import java.util.List;

public class SearchCriteria {
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