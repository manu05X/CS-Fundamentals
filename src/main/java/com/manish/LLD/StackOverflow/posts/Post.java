package com.manish.LLD.StackOverflow.posts;

import com.manish.LLD.StackOverflow.enums.PostType;

import java.time.LocalDateTime;

// Abstract Post class
public abstract class Post {
    protected int postId;
    protected int userId;
    protected String content;
    protected PostType postType;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
    protected boolean isDeleted;

    public Post(int postId, int userId, String content, PostType postType) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.postType = postType;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.isDeleted = false;
    }

    // Getters
    public int getPostId() {
        return postId;
    }

    public int getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }

    public PostType getPostType() {
        return postType;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    // Setters
    public void setContent(String content) {
        this.content = content;
        this.updatedAt = LocalDateTime.now();
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
