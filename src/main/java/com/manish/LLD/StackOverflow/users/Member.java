package com.manish.LLD.StackOverflow.users;


import com.manish.LLD.StackOverflow.database.Database;
import com.manish.LLD.StackOverflow.enums.UserRole;
import com.manish.LLD.StackOverflow.enums.VoteType;
import com.manish.LLD.StackOverflow.models.*;
import com.manish.LLD.StackOverflow.posts.Answer;
import com.manish.LLD.StackOverflow.posts.Comment;
import com.manish.LLD.StackOverflow.posts.Question;

import java.util.ArrayList;
import java.util.List;

// Member class
public class Member extends User {
    private int reputation;
    private List<Badge> badges;

    public Member(int userId, String username, String email, int reputation) {
        super(userId, username, email, UserRole.MEMBER);
        this.reputation = reputation;
        this.badges = new ArrayList<>();
    }

    @Override
    public boolean canPost() {
        return true;
    }

    @Override
    public boolean canVote() {
        return true;
    }

    @Override
    public boolean canComment() {
        return true;
    }

    public Question postQuestion(String title, String content, List<Tag> tags) {
        Question question = new Question(Database.getNextPostId(), this.userId, title, content);
        Database.addQuestion(question, tags);
        return question;
    }

    public Answer postAnswer(int questionId, String content) {
        Answer answer = new Answer(Database.getNextPostId(), this.userId, questionId, content);
        Database.addAnswer(answer);
        return answer;
    }

    public Comment postComment(int postId, String content) {
        Comment comment = new Comment(Database.getNextPostId(), this.userId, postId, content);
        Database.addComment(comment);
        return comment;
    }

    public void vote(int postId, VoteType voteType) {
        Vote vote = new Vote(Database.getNextVoteId(), postId, this.userId, voteType);
        Database.addVote(vote);
    }

    public void flagPost(int postId, String reason) {
        Flag flag = new Flag(Database.getNextFlagId(), postId, this.userId, reason);
        Database.addFlag(flag);
    }

    public void addBounty(int questionId, int amount) {
        Bounty bounty = new Bounty(Database.getNextBountyId(), questionId, this.userId, amount);
        Database.addBounty(bounty);
    }

    // Getters and setters
    public int getReputation() {
        return reputation;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public void addBadge(Badge badge) {
        badges.add(badge);
    }
}
