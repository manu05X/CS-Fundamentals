# Online Auction System Design Document

## 1. Actors

1. **Buyer**
   - Can participate in auctions
   - Can place/update/withdraw bids
   - Can be upgraded to preferred buyer

2. **Seller**
   - Can create auctions
   - Receives 20% of participation costs
   - Can view profit/loss

3. **System (FooBar)**
   - Manages auctions
   - Handles bid processing
   - Calculates profits
   - Maintains user status

## 2. Classes and Relationships

### Core Classes

1. **com.manish.LLD.PropertyPlatformLLD.Type1.User**
   - Base class for both Buyer and Seller
   - Properties: id, name

2. **Buyer (extends com.manish.LLD.PropertyPlatformLLD.Type1.User)**
   - Properties:
     - auctionsParticipated (count)
     - isPreferredBuyer
   - Methods:
     - placeBid()
     - updateBid()
     - withdrawBid()

3. **Seller (extends com.manish.LLD.PropertyPlatformLLD.Type1.User)**
   - Methods:
     - createAuction()
     - getProfit()

4. **Auction**
   - Properties:
     - id
     - lowestBidLimit
     - highestBidLimit
     - participationCost
     - seller
     - status (OPEN/CLOSED)
     - bids
   - Methods:
     - close()
     - getWinningBid()

5. **Bid**
   - Properties:
     - buyer
     - auction
     - amount
     - timestamp

6. **AuctionSystem**
   - Manages overall system operations
   - Handles user registration
   - Maintains auction state

## 3. Database Schema

### Tables and Relationships

1. **users**
   ```sql
   CREATE TABLE users (
       id BIGINT PRIMARY KEY,
       name VARCHAR(255),
       type VARCHAR(10), -- BUYER/SELLER
       created_at TIMESTAMP
   );
   ```

2. **buyers**
   ```sql
   CREATE TABLE buyers (
       user_id BIGINT PRIMARY KEY,
       auctions_participated INT DEFAULT 0,
       is_preferred_buyer BOOLEAN DEFAULT FALSE,
       FOREIGN KEY (user_id) REFERENCES users(id)
   );
   ```

3. **sellers**
   ```sql
   CREATE TABLE sellers (
       user_id BIGINT PRIMARY KEY,
       total_auctions INT DEFAULT 0,
       FOREIGN KEY (user_id) REFERENCES users(id)
   );
   ```

4. **auctions**
   ```sql
   CREATE TABLE auctions (
       id VARCHAR(50) PRIMARY KEY,
       seller_id BIGINT,
       lowest_bid_limit DECIMAL(10,2),
       highest_bid_limit DECIMAL(10,2),
       participation_cost DECIMAL(10,2),
       status VARCHAR(10), -- OPEN/CLOSED
       winner_id BIGINT,
       created_at TIMESTAMP,
       closed_at TIMESTAMP,
       FOREIGN KEY (seller_id) REFERENCES sellers(user_id),
       FOREIGN KEY (winner_id) REFERENCES buyers(user_id)
   );
   ```

5. **bids**
   ```sql
   CREATE TABLE bids (
       id BIGINT PRIMARY KEY,
       auction_id VARCHAR(50),
       buyer_id BIGINT,
       amount DECIMAL(10,2),
       status VARCHAR(10), -- ACTIVE/WITHDRAWN
       created_at TIMESTAMP,
       updated_at TIMESTAMP,
       FOREIGN KEY (auction_id) REFERENCES auctions(id),
       FOREIGN KEY (buyer_id) REFERENCES buyers(user_id)
   );
   ```

### Relationships

1. **1:1 Relationships**
   - com.manish.LLD.PropertyPlatformLLD.Type1.User to Buyer/Seller (inheritance)

2. **1:M Relationships**
   - Seller to Auctions
   - Auction to Bids

3. **M:1 Relationships**
   - Bids to Buyer
   - Bids to Auction

4. **M:M Relationships**
   - Buyers to Auctions (through Bids)

## 4. Key Features Implementation

### Preferred Buyer Logic
```java
public void updateBuyerStatus(Buyer buyer) {
    if (buyer.getAuctionsParticipated() > 2 && !buyer.isPreferredBuyer()) {
        buyer.setPreferredBuyer(true);
    }
}
```

### Winning Bid Calculation
```java
public Bid getWinningBid(List<Bid> bids) {
    // Group bids by amount
    Map<Double, List<Bid>> bidsByAmount = bids.stream()
        .collect(Collectors.groupingBy(Bid::getAmount));
    
    // Find highest unique bid
    return bidsByAmount.entrySet().stream()
        .filter(entry -> entry.getValue().size() == 1)
        .max(Map.Entry.comparingByKey())
        .map(entry -> entry.getValue().get(0))
        .orElse(null);
}
```

### Profit Calculation
```java
public double calculateProfit(Auction auction) {
    double participationRevenue = auction.getBids().size() * 
        auction.getParticipationCost() * 0.2;
    
    if (auction.getWinningBid() == null) {
        return participationRevenue;
    }
    
    double avgBidLimit = (auction.getLowestBidLimit() + 
        auction.getHighestBidLimit()) / 2;
    
    return auction.getWinningBid().getAmount() + 
        participationRevenue - avgBidLimit;
}
```

This design provides a solid foundation for implementing the Online Auction System with proper separation of concerns, extensibility, and maintainability in mind.