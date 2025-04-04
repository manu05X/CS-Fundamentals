package com.manish.LLD.PropertyPlatformLLD.services;

import com.manish.LLD.PropertyPlatformLLD.models.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UserService {
    private Map<String, User> users = new HashMap<>();
    private User currentUser = null;

    public void registerUser(Scanner scanner) {
        System.out.print("← Enter username: ");
        String username = scanner.nextLine().trim();

        if (users.containsKey(username)) {
            System.out.println("← Username already exists");
            return;
        }

        users.put(username, new User(username));
        System.out.println("← Registration successful");
    }

    public void loginUser(Scanner scanner) {
        System.out.print("← Enter username: ");
        String username = scanner.nextLine().trim();

        User user = users.get(username);
        if (user == null) {
            System.out.println("← User not found");
            return;
        }

        currentUser = user;
        System.out.println("← Welcome " + username);
    }

    public void logoutUser() {
        if (currentUser == null) {
            System.out.println("← No user logged in");
            return;
        }

        System.out.println("← Goodbye " + currentUser.getName());
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public Map<String, User> getUsers() {
        return users;
    }
}
