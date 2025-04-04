package com.manish.LLD.AuctionSystemLLD.Type1.model;

import java.time.LocalDateTime;

public class Bid {
    private Buyer buyer;
    private Auction auction;
    private double amount;
    private LocalDateTime timestamp;
    private boolean withdrawn;

    public Bid(Buyer buyer, Auction auction, double amount) {
        this.buyer = buyer;
        this.auction = auction;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
        this.withdrawn = false;
    }

    public void updateAmount(double newAmount) {
        if (withdrawn) {
            throw new IllegalStateException("Cannot update withdrawn bid");
        }
        if (auction.isClosed()) {
            throw new IllegalStateException("Cannot update bid in closed auction");
        }
        this.amount = newAmount;
        this.timestamp = LocalDateTime.now();
    }

    public void withdraw() {
        if (withdrawn) {
            throw new IllegalStateException("Bid is already withdrawn");
        }
        if (auction.isClosed()) {
            throw new IllegalStateException("Cannot withdraw bid from closed auction");
        }
        this.withdrawn = true;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public Auction getAuction() {
        return auction;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean isWithdrawn() {
        return withdrawn;
    }
}