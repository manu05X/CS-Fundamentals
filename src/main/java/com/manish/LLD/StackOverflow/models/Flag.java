package com.manish.LLD.StackOverflow.models;




import com.manish.LLD.StackOverflow.enums.FlagStatus;

import java.time.LocalDateTime;

// Flag class
public class Flag {
    private int flagId;
    private int postId;
    private int userId;
    private String reason;
    private FlagStatus status;
    private LocalDateTime createdAt;

    public Flag(int flagId, int postId, int userId, String reason) {
        this.flagId = flagId;
        this.postId = postId;
        this.userId = userId;
        this.reason = reason;
        this.status = FlagStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }

    // Getters
    public int getFlagId() {
        return flagId;
    }

    public int getPostId() {
        return postId;
    }

    public int getUserId() {
        return userId;
    }

    public String getReason() {
        return reason;
    }

    public FlagStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    // Setters
    public void setStatus(FlagStatus status) {
        this.status = status;
    }
}
