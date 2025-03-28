package com.manish.LLD.StackOverflow.models;

import java.time.LocalDateTime;

// Bounty class
public class Bounty {
    private int bountyId;
    private int questionId;
    private int userId;
    private int amount;
    private LocalDateTime createdAt;
    private LocalDateTime expiresAt;

    public Bounty(int bountyId, int questionId, int userId, int amount) {
        this.bountyId = bountyId;
        this.questionId = questionId;
        this.userId = userId;
        this.amount = amount;
        this.createdAt = LocalDateTime.now();
        this.expiresAt = LocalDateTime.now().plusDays(7); // 7 days bounty
    }

    // Getters
    public int getBountyId() {
        return bountyId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getUserId() {
        return userId;
    }

    public int getAmount() {
        return amount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpiresAt() {
        return expiresAt;
    }
}
