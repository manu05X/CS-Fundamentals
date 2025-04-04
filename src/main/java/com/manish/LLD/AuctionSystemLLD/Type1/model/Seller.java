package com.manish.LLD.AuctionSystemLLD.Type1.model;

public class Seller extends User {
    private int totalAuctions;

    public Seller(String name) {
        super(name);
        this.totalAuctions = 0;
    }

    public void incrementTotalAuctions() {
        this.totalAuctions++;
    }

    public int getTotalAuctions() {
        return totalAuctions;
    }

    public double calculateProfit(Auction auction) {
        if (auction == null) {
            throw new IllegalArgumentException("Auction cannot be null");
        }

        double participationRevenue = auction.getBids().size() * 
            auction.getParticipationCost() * 0.2; // 20% of participation costs

        if (!auction.isClosed() || auction.getWinningBid() == null) {
            return participationRevenue;
        }

        double avgBidLimit = (auction.getLowestBidLimit() + auction.getHighestBidLimit()) / 2;
        return auction.getWinningBid().getAmount() + participationRevenue - avgBidLimit;
    }
}