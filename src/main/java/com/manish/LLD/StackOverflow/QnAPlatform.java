package com.manish.LLD.StackOverflow;



import com.manish.LLD.StackOverflow.database.Database;
import com.manish.LLD.StackOverflow.enums.VoteType;
import com.manish.LLD.StackOverflow.models.Tag;
import com.manish.LLD.StackOverflow.posts.Answer;
import com.manish.LLD.StackOverflow.posts.Comment;
import com.manish.LLD.StackOverflow.posts.Post;
import com.manish.LLD.StackOverflow.posts.Question;
import com.manish.LLD.StackOverflow.users.Member;
import com.manish.LLD.StackOverflow.users.Moderator;
import com.manish.LLD.StackOverflow.users.User;

import java.util.*;

// Command Line Interface
public class QnAPlatform {
    private static Scanner scanner = new Scanner(System.in);
    private static User currentUser;
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Q&A Platform!");
        
        while (true) {
            if (currentUser == null) {
                showGuestMenu();
            } else {
                showUserMenu();
            }
        }
    }
    
    private static void showGuestMenu() {
        System.out.println("\nGuest Menu:");
        System.out.println("1. Search questions");
        System.out.println("2. View question");
        System.out.println("3. Register");
        System.out.println("4. Login");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        switch (choice) {
            case 1:
                searchQuestions();
                break;
            case 2:
                viewQuestion();
                break;
            case 3:
                register();
                break;
            case 4:
                login();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
    
    private static void showUserMenu() {
        System.out.println("\nUser Menu (" + currentUser.getUsername() + "):");
        System.out.println("1. Search questions");
        System.out.println("2. View question");
        System.out.println("3. Post question");
        System.out.println("4. Post answer");
        System.out.println("5. Post comment");
        System.out.println("6. Vote");
        System.out.println("7. Logout");
        
        if (currentUser instanceof Moderator) {
            System.out.println("8. Moderator options");
        }
        
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        switch (choice) {
            case 1:
                searchQuestions();
                break;
            case 2:
                viewQuestion();
                break;
            case 3:
                postQuestion();
                break;
            case 4:
                postAnswer();
                break;
            case 5:
                postComment();
                break;
            case 6:
                vote();
                break;
            case 7:
                currentUser = null;
                break;
            case 8:
                if (currentUser instanceof Moderator) {
                    showModeratorMenu();
                } else {
                    System.out.println("Invalid option!");
                }
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
    
    private static void showModeratorMenu() {
        System.out.println("\nModerator Menu:");
        System.out.println("1. Close question");
        System.out.println("2. Reopen question");
        System.out.println("3. Undelete question");
        System.out.println("4. Back to main menu");
        System.out.print("Choose an option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        switch (choice) {
            case 1:
                closeQuestion();
                break;
            case 2:
                reopenQuestion();
                break;
            case 3:
                undeleteQuestion();
                break;
            case 4:
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
    
    private static void searchQuestions() {
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();
        
        List<Question> results = Database.searchQuestions(query);
        System.out.println("\nSearch Results:");
        for (Question q : results) {
            System.out.println(q.getPostId() + ": " + q.getTitle());
        }
    }
    
    private static void viewQuestion() {
        System.out.print("Enter question ID: ");
        int questionId = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        Post post = Database.getPost(questionId);
        if (post instanceof Question) {
            Question question = (Question) post;
            System.out.println("\nQuestion: " + question.getTitle());
            System.out.println("Content: " + question.getContent());
            System.out.println("Tags: " + question.getTags());
            System.out.println("\nAnswers:");
            for (Answer a : question.getAnswers()) {
                System.out.println("- " + a.getContent());
            }
            System.out.println("\nComments:");
            for (Comment c : question.getComments()) {
                System.out.println("- " + c.getContent());
            }
        } else {
            System.out.println("Question not found!");
        }
    }
    
    private static void register() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        int userId = Database.getNextUserId();
        Member member = new Member(userId, username, email, 0);
        Database.addUser(member);
        currentUser = member;
        System.out.println("Registration successful! You are now logged in.");
    }
    
    private static void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        
        // In a real application, you would verify credentials
        // For this example, we'll just find any user with matching username
        for (User user : Database.getInstance().users) {
            if (user.getUsername().equals(username)) {
                currentUser = user;
                System.out.println("Login successful!");
                return;
            }
        }
        System.out.println("User not found!");
    }
    
    private static void postQuestion() {
        if (currentUser instanceof Member) {
            Member member = (Member) currentUser;
            System.out.print("Enter question title: ");
            String title = scanner.nextLine();
            System.out.print("Enter question content: ");
            String content = scanner.nextLine();
            System.out.print("Enter tags (comma separated): ");
            String tagsInput = scanner.nextLine();
            
            List<Tag> tags = new ArrayList<>();
            for (String tagName : tagsInput.split(",")) {
                tags.add(new Tag(Database.getNextTagId(), tagName.trim(), ""));
            }
            
            Question question = member.postQuestion(title, content, tags);
            System.out.println("Question posted with ID: " + question.getPostId());
        }
    }
    
    private static void postAnswer() {
        if (currentUser instanceof Member) {
            Member member = (Member) currentUser;
            System.out.print("Enter question ID to answer: ");
            int questionId = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter answer content: ");
            String content = scanner.nextLine();
            
            Answer answer = member.postAnswer(questionId, content);
            System.out.println("Answer posted with ID: " + answer.getPostId());
        }
    }
    
    private static void postComment() {
        if (currentUser instanceof Member) {
            Member member = (Member) currentUser;
            System.out.print("Enter post ID to comment on: ");
            int postId = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Enter comment content: ");
            String content = scanner.nextLine();
            
            Comment comment = member.postComment(postId, content);
            System.out.println("Comment posted with ID: " + comment.getPostId());
        }
    }
    
    private static void vote() {
        if (currentUser instanceof Member) {
            Member member = (Member) currentUser;
            System.out.print("Enter post ID to vote on: ");
            int postId = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.print("Vote type (1. Upvote, 2. Downvote): ");
            int voteChoice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            VoteType voteType = voteChoice == 1 ? VoteType.UPVOTE : VoteType.DOWNVOTE;
            member.vote(postId, voteType);
            System.out.println("Vote recorded!");
        }
    }
    
    private static void closeQuestion() {
        if (currentUser instanceof Moderator) {
            Moderator moderator = (Moderator) currentUser;
            System.out.print("Enter question ID to close: ");
            int questionId = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            moderator.closeQuestion(questionId);
            System.out.println("Question closed!");
        }
    }
    
    private static void reopenQuestion() {
        if (currentUser instanceof Moderator) {
            Moderator moderator = (Moderator) currentUser;
            System.out.print("Enter question ID to reopen: ");
            int questionId = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            moderator.reopenQuestion(questionId);
            System.out.println("Question reopened!");
        }
    }
    
    private static void undeleteQuestion() {
        if (currentUser instanceof Moderator) {
            Moderator moderator = (Moderator) currentUser;
            System.out.print("Enter question ID to undelete: ");
            int questionId = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            moderator.undeleteQuestion(questionId);
            System.out.println("Question undeleted!");
        }
    }
}