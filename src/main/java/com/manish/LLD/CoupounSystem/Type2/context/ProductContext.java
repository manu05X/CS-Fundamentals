package com.manish.LLD.CoupounSystem.Type2.context;

import com.manish.LLD.CoupounSystem.Type2.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductContext {
    private List<Product> products;
    private double totalProductValue;
    private int totalItems;
    private boolean containsPremiumProducts;
    private boolean containsDiscountedItems;

    // Constructor to initialize with products
    public ProductContext(List<Product> products) {
        this.products = products;
        this.totalProductValue = calculateTotalValue();
        this.totalItems = products.size();
        this.containsPremiumProducts = checkForPremiumProducts();
        this.containsDiscountedItems = checkForDiscountedItems();
    }

    private double calculateTotalValue() {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    private boolean checkForPremiumProducts() {
        return products.stream()
                .anyMatch(Product::isPremium);
    }

    private boolean checkForDiscountedItems() {
        return products.stream()
                .anyMatch(Product::isDiscounted);
    }

    // Additional helper methods
    public boolean containsCategory(String category) {
        return products.stream()
                .anyMatch(p -> p.getCategory().equalsIgnoreCase(category));
    }

    public int getProductCountByCategory(String category) {
        return (int) products.stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category))
                .count();
    }
}