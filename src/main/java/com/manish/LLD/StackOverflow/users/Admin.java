package com.manish.LLD.StackOverflow.users;



// Admin class
public class Admin extends Moderator {
    public Admin(int userId, String username, String email, int reputation) {
        super(userId, username, email, reputation);
    }

    public void promoteToModerator(Member member) {
        // Implementation to promote member to moderator
    }
}
