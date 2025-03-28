package com.manish.LLD.StackOverflow.posts;


import com.manish.LLD.StackOverflow.enums.PostType;

import java.util.ArrayList;
import java.util.List;

// Answer class
public class Answer extends Post {
    private int questionId;
    private List<Comment> comments;
    private boolean isAccepted;

    public Answer(int postId, int userId, int questionId, String content) {
        super(postId, userId, content, PostType.ANSWER);
        this.questionId = questionId;
        this.comments = new ArrayList<>();
        this.isAccepted = false;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    // Getters
    public int getQuestionId() {
        return questionId;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    // Setters
    public void setAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }
}
