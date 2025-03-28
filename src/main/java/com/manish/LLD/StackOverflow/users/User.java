package com.manish.LLD.StackOverflow.users;

import com.manish.LLD.StackOverflow.enums.UserRole;

// Abstract User class
public abstract class User {
    protected int userId;
    protected String username;
    protected String email;
    protected UserRole role;

    public User(int userId, String username, String email, UserRole role) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.role = role;
    }

    public abstract boolean canPost();

    public abstract boolean canVote();

    public abstract boolean canComment();

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }
}
