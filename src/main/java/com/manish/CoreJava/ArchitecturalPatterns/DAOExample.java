package com.manish.CoreJava.ArchitecturalPatterns;

public class DAOExample {
    public DAOExample() {
    }

    public static void main(String[] args) {
        UserDAO userDao = new UserDAOImpl();
        User1 newUser = new User1();
        newUser.setUsername("new_user");
        newUser.setEmail("new.user@example.com");
        userDao.insert(newUser);
        User1 retrievedUser = userDao.getById(1);
        if (retrievedUser != null) {
            System.out.println("Retrieved User: " + retrievedUser.getUsername());
        }

    }
}