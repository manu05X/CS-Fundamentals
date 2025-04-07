package com.manish.LLD.CoupounSystem.Type1.model;

public class CartItem {
    private String productId;
    private String productType;
    private int quantity;
    private double price;

    public CartItem(String productId, String productType, int quantity, double price) {
        this.productId = productId;
        this.productType = productType;
        this.quantity = quantity;
        this.price = price;
    }


    public String getProductType() {
        return productType;
    }

    public double getPrice() {
        return price;
    }
}
