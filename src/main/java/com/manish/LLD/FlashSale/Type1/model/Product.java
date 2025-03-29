package com.manish.LLD.FlashSale.Type1.model;

import java.math.BigDecimal;

public class Product {
    private String productId;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;

    public Product(String productId, String name, String description, BigDecimal price, String category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }
}
