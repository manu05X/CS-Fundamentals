package com.manish.LLD.StackOverflow.users;

import com.manish.LLD.StackOverflow.enums.UserRole;

// Guest class
public class Guest extends User {
    public Guest(int userId, String username, String email) {
        super(userId, username, email, UserRole.GUEST);
    }

    @Override
    public boolean canPost() {
        return false;
    }

    @Override
    public boolean canVote() {
        return false;
    }

    @Override
    public boolean canComment() {
        return false;
    }

    public boolean register(String password) {
        // Implementation to register as member
        return true;
    }
}
