package com.manish.LLD.PropertyPlatformLLD.models;


import java.util.ArrayList;
import java.util.List;

public class SearchCriteria {
    private List<String> locations = new ArrayList<>();
    private Long minPrice;
    private Long maxPrice;
    private String listingType;
    private Double minSize;
    private Double maxSize;
    private List<String> rooms = new ArrayList<>();
    private String sortBy;

    // Getters and setters
    public List<String> getLocations() { return locations; }
    public void setLocations(List<String> locations) { this.locations = locations; }
    public Long getMinPrice() { return minPrice; }
    public void setMinPrice(Long minPrice) { this.minPrice = minPrice; }
    public Long getMaxPrice() { return maxPrice; }
    public void setMaxPrice(Long maxPrice) { this.maxPrice = maxPrice; }
    public String getListingType() { return listingType; }
    public void setListingType(String listingType) { this.listingType = listingType; }
    public Double getMinSize() { return minSize; }
    public void setMinSize(Double minSize) { this.minSize = minSize; }
    public Double getMaxSize() { return maxSize; }
    public void setMaxSize(Double maxSize) { this.maxSize = maxSize; }
    public List<String> getRooms() { return rooms; }
    public void setRooms(List<String> rooms) { this.rooms = rooms; }
    public String getSortBy() { return sortBy; }
    public void setSortBy(String sortBy) { this.sortBy = sortBy; }
}
