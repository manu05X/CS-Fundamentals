package com.manish.OOD.CreationalDesign.BuilderDesign.Example2;

import java.util.ArrayList;
import java.util.List;

// Product Class: This is the complex object that is being constructed.
// It contains various fields, such as products, billing address, shipping address, discount, and tax.
public class Order {
    private List<Product> products;         // List of products in the order
    private Address billingAddress;         // Billing address for the order
    private Address shippingAddress;        // Shipping address for the order
    private double discount;                // Discount applied to the order
    private double tax;                     // Tax applied to the order

    // Private constructor for creating an Order object using the Builder.
    // This enforces the use of the Builder to create an Order.
    private Order(List<Product> products, Address billingAddress, Address shippingAddress,
                  double discount, double tax) {
        this.products = products;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.discount = discount;
        this.tax = tax;
    }

    // Getters for accessing the private fields of the order.
    public List<Product> getProducts() {
        return products;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTax() {
        return tax;
    }

    // Builder Class: This nested static class helps to construct an Order object step by step.
    // It has methods for setting each property of the Order.
    public static class OrderBuilder {
        private List<Product> products;
        private Address billingAddress;
        private Address shippingAddress;
        private double discount;
        private double tax;

        // Constructor initializes default values for the order fields.
        public OrderBuilder() {
            products = new ArrayList<>();
            discount = 0.0;
            tax = 0.0;
        }

        // Method to add a product to the order.
        public OrderBuilder addProduct(Product product) {
            products.add(product);
            return this;
        }

        // Method to set the billing address for the order.
        public OrderBuilder setBillingAddress(Address billingAddress) {
            this.billingAddress = billingAddress;
            return this;
        }

        // Method to set the shipping address for the order.
        public OrderBuilder setShippingAddress(Address shippingAddress) {
            this.shippingAddress = shippingAddress;
            return this;
        }

        // Method to apply a discount to the order.
        public OrderBuilder setDiscount(double discount) {
            this.discount = discount;
            return this;
        }

        // Method to apply tax to the order.
        public OrderBuilder setTax(double tax) {
            this.tax = tax;
            return this;
        }

        // Method to build the final Order object after all steps have been performed.
        public Order build() {
            return new Order(products, billingAddress, shippingAddress, discount, tax);
        }
    }
}


