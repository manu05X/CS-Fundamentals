package com.manish.LLD.StackOverflow.users;


import com.manish.LLD.StackOverflow.database.Database;

// Moderator class
public class Moderator extends Member {
    public Moderator(int userId, String username, String email, int reputation) {
        super(userId, username, email, reputation);
    }

    public void closeQuestion(int questionId) {
        Database.closeQuestion(questionId);
    }

    public void reopenQuestion(int questionId) {
        Database.reopenQuestion(questionId);
    }

    public void undeleteQuestion(int questionId) {
        Database.undeleteQuestion(questionId);
    }
}
