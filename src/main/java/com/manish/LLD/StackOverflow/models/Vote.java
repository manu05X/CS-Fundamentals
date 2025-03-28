package com.manish.LLD.StackOverflow.models;

import com.manish.LLD.StackOverflow.enums.VoteType;

import java.time.LocalDateTime;

// Vote class
public class Vote {
    private int voteId;
    private int postId;
    private int userId;
    private VoteType voteType;
    private LocalDateTime createdAt;

    public Vote(int voteId, int postId, int userId, VoteType voteType) {
        this.voteId = voteId;
        this.postId = postId;
        this.userId = userId;
        this.voteType = voteType;
        this.createdAt = LocalDateTime.now();
    }

    // Getters
    public int getVoteId() {
        return voteId;
    }

    public int getPostId() {
        return postId;
    }

    public int getUserId() {
        return userId;
    }

    public VoteType getVoteType() {
        return voteType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
