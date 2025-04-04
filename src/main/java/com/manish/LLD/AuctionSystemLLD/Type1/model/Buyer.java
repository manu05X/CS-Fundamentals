package com.manish.LLD.AuctionSystemLLD.Type1.model;

public class Buyer extends User {
    private int auctionsParticipated;
    private boolean isPreferredBuyer;

    public Buyer(String name) {
        super(name);
        this.auctionsParticipated = 0;
        this.isPreferredBuyer = false;
    }

    public void incrementAuctionsParticipated() {
        this.auctionsParticipated++;
        if (this.auctionsParticipated > 2 && !this.isPreferredBuyer) {
            this.isPreferredBuyer = true;
        }
    }

    public int getAuctionsParticipated() {
        return auctionsParticipated;
    }

    public boolean isPreferredBuyer() {
        return isPreferredBuyer;
    }

    public void setPreferredBuyer(boolean preferredBuyer) {
        isPreferredBuyer = preferredBuyer;
    }
}