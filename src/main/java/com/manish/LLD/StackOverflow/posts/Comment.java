package com.manish.LLD.StackOverflow.posts;


import com.manish.LLD.StackOverflow.enums.PostType;

// Comment class
public class Comment extends Post {
    private int parentPostId;

    public Comment(int postId, int userId, int parentPostId, String content) {
        super(postId, userId, content, PostType.COMMENT);
        this.parentPostId = parentPostId;
    }

    // Getters
    public int getParentPostId() {
        return parentPostId;
    }
}
