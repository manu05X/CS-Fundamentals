package com.manish.LLD.AuctionSystemLLD.Type1;


import com.manish.LLD.AuctionSystemLLD.Type1.model.Bid;

public class Main {
    public static void main(String[] args) {
        AuctionSystem system = new AuctionSystem();

        // Test Case 1
        System.out.println("\nExecuting Test Case 1:");
        System.out.println("------------------------");

        // Add buyers and seller
        system.addBuyer("buyer1");
        system.addBuyer("buyer2");
        system.addBuyer("buyer3");
        system.addSeller("seller1");

        // Create auction
        system.createAuction("A1", 10, 50, 1, "seller1");

        // Create and update bids
        system.createBid("buyer1", "A1", 17);
        system.createBid("buyer2", "A1", 15);
        system.updateBid("buyer2", "A1", 19);
        system.createBid("buyer3", "A1", 19);

        // Close auction and get results
        Bid winningBid = system.closeAuction("A1");
        System.out.println("Winner: " + (winningBid != null ? winningBid.getBuyer().getName() : "No winner"));
        System.out.println("Profit: " + system.getProfit("seller1", "A1"));

        // Test Case 2
        System.out.println("\nExecuting Test Case 2:");
        System.out.println("------------------------");

        // Add seller and create auction
        system.addSeller("seller2");
        system.createAuction("A2", 5, 20, 2, "seller2");

        try {
            // This should fail as it's above highest bid limit
            system.createBid("buyer3", "A2", 25);
        } catch (IllegalArgumentException e) {
            System.out.println("Expected error: Bid above limit rejected");
        }

        // Create and withdraw bid
        system.createBid("buyer2", "A2", 5);
        system.withdrawBid("buyer2", "A2");

        // Close auction and get results
        winningBid = system.closeAuction("A2");
        System.out.println("Winner: " + (winningBid != null ? winningBid.getBuyer().getName() : "No winner"));
        System.out.println("Profit: " + system.getProfit("seller2", "A2"));

        // Demonstrate Preferred Buyer functionality
        System.out.println("\nDemonstrating Preferred Buyer Status:");
        System.out.println("----------------------------------");
        
        // Create a new auction to test preferred buyer status
        system.createAuction("A3", 10, 100, 2, "seller1");
        system.createBid("buyer1", "A3", 50); // This is buyer1's second auction
        system.createBid("buyer2", "A3", 50); // This is buyer2's third auction - should become preferred
        
        // Check if buyer2 is now a preferred buyer
        System.out.println("Is buyer2 preferred? " + system.isPreferredBuyer("buyer2"));
    }
}