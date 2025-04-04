package com.manish.LLD.AuctionSystemLLD.Type1;

import com.manish.LLD.AuctionSystemLLD.Type1.model.*;

import java.util.*;

public class AuctionSystem {
    private Map<String, User> users;
    private Map<String, Auction> auctions;
    private long nextUserId;

    public AuctionSystem() {
        this.users = new HashMap<>();
        this.auctions = new HashMap<>();
        this.nextUserId = 1;
    }

    public Buyer addBuyer(String name) {
        Buyer buyer = new Buyer(name);
        buyer.setId(nextUserId++);
        users.put(name, buyer);
        return buyer;
    }

    public Seller addSeller(String name) {
        Seller seller = new Seller(name);
        seller.setId(nextUserId++);
        users.put(name, seller);
        return seller;
    }

    public Auction createAuction(String id, double lowestBidLimit, double highestBidLimit,
                                double participationCost, String sellerName) {
        Seller seller = (Seller) users.get(sellerName);
        if (seller == null) {
            throw new IllegalArgumentException("Seller not found: " + sellerName);
        }

        Auction auction = new Auction(id, lowestBidLimit, highestBidLimit, participationCost, seller);
        auctions.put(id, auction);
        seller.incrementTotalAuctions();
        return auction;
    }

    public void createBid(String buyerName, String auctionId, double amount) {
        Buyer buyer = (Buyer) users.get(buyerName);
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer not found: " + buyerName);
        }

        Auction auction = auctions.get(auctionId);
        if (auction == null) {
            throw new IllegalArgumentException("Auction not found: " + auctionId);
        }

        Bid bid = new Bid(buyer, auction, amount);
        auction.addBid(bid);
        buyer.incrementAuctionsParticipated();
    }

    public void updateBid(String buyerName, String auctionId, double newAmount) {
        Buyer buyer = (Buyer) users.get(buyerName);
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer not found: " + buyerName);
        }

        Auction auction = auctions.get(auctionId);
        if (auction == null) {
            throw new IllegalArgumentException("Auction not found: " + auctionId);
        }

        auction.updateBid(buyer, newAmount);
    }

    public void withdrawBid(String buyerName, String auctionId) {
        Buyer buyer = (Buyer) users.get(buyerName);
        if (buyer == null) {
            throw new IllegalArgumentException("Buyer not found: " + buyerName);
        }

        Auction auction = auctions.get(auctionId);
        if (auction == null) {
            throw new IllegalArgumentException("Auction not found: " + auctionId);
        }

        auction.withdrawBid(buyer);
    }

    public Bid closeAuction(String auctionId) {
        Auction auction = auctions.get(auctionId);
        if (auction == null) {
            throw new IllegalArgumentException("Auction not found: " + auctionId);
        }

        auction.close();
        return auction.getWinningBid();
    }

    public double getProfit(String sellerName, String auctionId) {
        Seller seller = (Seller) users.get(sellerName);
        if (seller == null) {
            throw new IllegalArgumentException("Seller not found: " + sellerName);
        }

        Auction auction = auctions.get(auctionId);
        if (auction == null) {
            throw new IllegalArgumentException("Auction not found: " + auctionId);
        }

        if (!auction.getSeller().equals(seller)) {
            throw new IllegalArgumentException("Auction does not belong to seller: " + sellerName);
        }

        return seller.calculateProfit(auction);
    }

    public boolean isPreferredBuyer(String buyerName) {
        User user = users.get(buyerName);
        if (user == null || !(user instanceof Buyer)) {
            throw new IllegalArgumentException("Buyer not found: " + buyerName);
        }
        return ((Buyer) user).isPreferredBuyer();
    }
}