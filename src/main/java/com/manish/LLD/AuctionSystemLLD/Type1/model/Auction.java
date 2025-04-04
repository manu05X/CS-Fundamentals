package com.manish.LLD.AuctionSystemLLD.Type1.model;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class Auction {
    private String id;
    private double lowestBidLimit;
    private double highestBidLimit;
    private double participationCost;
    private boolean closed;
    private Seller seller;
    private List<Bid> bids;
    private Bid winningBid;
    private LocalDateTime createdAt;
    private LocalDateTime closedAt;

    public Auction(String id, double lowestBidLimit, double highestBidLimit, 
                  double participationCost, Seller seller) {
        this.id = id;
        this.lowestBidLimit = lowestBidLimit;
        this.highestBidLimit = highestBidLimit;
        this.participationCost = participationCost;
        this.seller = seller;
        this.bids = new ArrayList<>();
        this.closed = false;
        this.createdAt = LocalDateTime.now();
    }

    public void addBid(Bid bid) {
        if (closed) {
            throw new IllegalStateException("Cannot add bid to closed auction");
        }
        if (bid.getAmount() < lowestBidLimit || bid.getAmount() > highestBidLimit) {
            throw new IllegalArgumentException("Bid amount outside allowed limits");
        }
        bids.add(bid);
    }

    public void updateBid(Buyer buyer, double newAmount) {
        if (closed) {
            throw new IllegalStateException("Cannot update bid in closed auction");
        }
        if (newAmount < lowestBidLimit || newAmount > highestBidLimit) {
            throw new IllegalArgumentException("New bid amount outside allowed limits");
        }

        bids.stream()
            .filter(bid -> bid.getBuyer().equals(buyer))
            .findFirst()
            .ifPresent(bid -> bid.updateAmount(newAmount));
    }

    public void withdrawBid(Buyer buyer) {
        if (closed) {
            throw new IllegalStateException("Cannot withdraw bid from closed auction");
        }

        bids.stream()
            .filter(bid -> bid.getBuyer().equals(buyer))
            .findFirst()
            .ifPresent(Bid::withdraw);
    }

    public void close() {
        if (closed) {
            throw new IllegalStateException("Auction is already closed");
        }
        this.closed = true;
        this.closedAt = LocalDateTime.now();
        calculateWinningBid();
    }

    private void calculateWinningBid() {
        // Get active bids only
        List<Bid> activeBids = bids.stream()
            .filter(bid -> !bid.isWithdrawn())
            .collect(Collectors.toList());

        // Group bids by amount
        Map<Double, List<Bid>> bidsByAmount = activeBids.stream()
            .collect(Collectors.groupingBy(Bid::getAmount));

        // Find highest unique bid
        Optional<Bid> highestUniqueBid = bidsByAmount.entrySet().stream()
            .filter(entry -> entry.getValue().size() == 1) // unique bids only
            .max(Map.Entry.comparingByKey()) // get highest
            .map(entry -> entry.getValue().get(0));

        // If there's a tie between preferred buyers, find next highest unique bid
        if (!highestUniqueBid.isPresent()) {
            List<Bid> preferredBuyerBids = activeBids.stream()
                .filter(bid -> bid.getBuyer().isPreferredBuyer())
                .collect(Collectors.toList());

            if (!preferredBuyerBids.isEmpty()) {
                Map<Double, List<Bid>> preferredBidsByAmount = preferredBuyerBids.stream()
                    .collect(Collectors.groupingBy(Bid::getAmount));

                highestUniqueBid = preferredBidsByAmount.entrySet().stream()
                    .filter(entry -> entry.getValue().size() == 1)
                    .max(Map.Entry.comparingByKey())
                    .map(entry -> entry.getValue().get(0));
            }
        }

        this.winningBid = highestUniqueBid.orElse(null);
    }

    public String getId() {
        return id;
    }

    public double getLowestBidLimit() {
        return lowestBidLimit;
    }

    public double getHighestBidLimit() {
        return highestBidLimit;
    }

    public double getParticipationCost() {
        return participationCost;
    }

    public boolean isClosed() {
        return closed;
    }

    public Seller getSeller() {
        return seller;
    }

    public List<Bid> getBids() {
        return Collections.unmodifiableList(bids);
    }

    public Bid getWinningBid() {
        return winningBid;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getClosedAt() {
        return closedAt;
    }
}