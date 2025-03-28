package com.manish.LLD.StackOverflow.database;

import com.manish.LLD.StackOverflow.models.*;
import com.manish.LLD.StackOverflow.posts.Answer;
import com.manish.LLD.StackOverflow.posts.Comment;
import com.manish.LLD.StackOverflow.posts.Post;
import com.manish.LLD.StackOverflow.posts.Question;
import com.manish.LLD.StackOverflow.users.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Database Singleton
public class Database {
    private static Database instance;
    public List<User> users;
    private List<Post> posts;
    private List<Vote> votes;
    private List<Flag> flags;
    private List<Badge> badges;
    private List<Tag> tags;
    private List<Bounty> bounties;
    private List<Notification> notifications;
    private Map<Integer, List<Tag>> questionTags;

    private int nextUserId = 1;
    private int nextPostId = 1;
    private int nextVoteId = 1;
    private int nextFlagId = 1;
    private int nextBadgeId = 1;
    private int nextTagId = 1;
    private int nextBountyId = 1;
    private int nextNotificationId = 1;

    public Database() {
        users = new ArrayList<>();
        posts = new ArrayList<>();
        votes = new ArrayList<>();
        flags = new ArrayList<>();
        badges = new ArrayList<>();
        tags = new ArrayList<>();
        bounties = new ArrayList<>();
        notifications = new ArrayList<>();
        questionTags = new HashMap<>();
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    // User methods
    public static int getNextUserId() {
        return getInstance().nextUserId++;
    }

    public static void addUser(User user) {
        getInstance().users.add(user);
    }

    public static User getUser(int userId) {
        return getInstance().users.stream()
                .filter(u -> u.getUserId() == userId)
                .findFirst()
                .orElse(null);
    }

    // Post methods
    public static int getNextPostId() {
        return getInstance().nextPostId++;
    }

    public static void addQuestion(Question question, List<Tag> tags) {
        getInstance().posts.add(question);
        getInstance().questionTags.put(question.getPostId(), new ArrayList<>(tags));
    }

    public static void addAnswer(Answer answer) {
        getInstance().posts.add(answer);
    }

    public static void addComment(Comment comment) {
        getInstance().posts.add(comment);
    }

    public static Post getPost(int postId) {
        return getInstance().posts.stream()
                .filter(p -> p.getPostId() == postId)
                .findFirst()
                .orElse(null);
    }

    public static void closeQuestion(int questionId) {
        Post post = getPost(questionId);
        if (post instanceof Question) {
            ((Question) post).setClosed(true);
        }
    }

    public static void reopenQuestion(int questionId) {
        Post post = getPost(questionId);
        if (post instanceof Question) {
            ((Question) post).setClosed(false);
        }
    }

    public static void undeleteQuestion(int questionId) {
        Post post = getPost(questionId);
        if (post != null) {
            post.setDeleted(false);
        }
    }

    public static int getNextTagId() {
        return getInstance().nextTagId++;
    }

    public static void addTag(Tag tag) {
        getInstance().tags.add(tag);
    }

    public static Tag getTagByName(String name) {
        return getInstance().tags.stream()
                .filter(t -> t.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    // Vote methods
    public static int getNextVoteId() {
        return getInstance().nextVoteId++;
    }

    public static void addVote(Vote vote) {
        getInstance().votes.add(vote);
    }

    // Flag methods
    public static int getNextFlagId() {
        return getInstance().nextFlagId++;
    }

    public static void addFlag(Flag flag) {
        getInstance().flags.add(flag);
    }

    // Bounty methods
    public static int getNextBountyId() {
        return getInstance().nextBountyId++;
    }

    public static void addBounty(Bounty bounty) {
        getInstance().bounties.add(bounty);
    }

    // Other utility methods
    public static List<Question> searchQuestions(String query) {
        List<Question> results = new ArrayList<>();
        for (Post post : getInstance().posts) {
            if (post instanceof Question) {
                Question question = (Question) post;
                if (question.getTitle().contains(query) || question.getContent().contains(query)) {
                    results.add(question);
                }
            }
        }
        return results;
    }

    public static List<Tag> getPopularTags(int count) {
        // 1. Create frequency map of tags
        Map<Tag, Integer> tagFrequency = new HashMap<>();

        // 2. Count tag occurrences across all questions
        for (Map.Entry<Integer, List<Tag>> entry : getInstance().questionTags.entrySet()) {
            for (Tag tag : entry.getValue()) {
                tagFrequency.put(tag, tagFrequency.getOrDefault(tag, 0) + 1);
            }
        }

        // 3. Sort tags by frequency (descending)
        List<Map.Entry<Tag, Integer>> sortedTags = new ArrayList<>(tagFrequency.entrySet());
        sortedTags.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // 4. Return top 'count' tags
        return sortedTags.stream()
                .limit(count)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }



}
