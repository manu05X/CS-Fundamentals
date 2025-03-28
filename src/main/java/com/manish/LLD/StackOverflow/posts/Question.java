package com.manish.LLD.StackOverflow.posts;

import com.manish.LLD.StackOverflow.enums.PostType;
import com.manish.LLD.StackOverflow.models.Tag;


import java.util.ArrayList;
import java.util.List;

// Question class
public class Question extends Post {
    private String title;
    private boolean isClosed;
    private List<Answer> answers;
    private List<Comment> comments;
    private List<Tag> tags;

    public Question(int postId, int userId, String title, String content) {
        super(postId, userId, content, PostType.QUESTION);
        this.title = title;
        this.isClosed = false;
        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.tags = new ArrayList<>();
    }



    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public List<Tag> getTags() {
        return tags;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }
}
