package com.manish.LLD.CoupounSystem.Type1.model;

public class Order {
    private String orderId;
    private User user;
    private Cart cart;
    private double totalAmount;

    public Order(String orderId, User user, Cart cart, double totalAmount) {
        this.orderId = orderId;
        this.user = user;
        this.cart = cart;
        this.totalAmount = totalAmount;
    }

    public User getUser() {
        return user;
    }

    public Cart getCart() {
        return cart;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
