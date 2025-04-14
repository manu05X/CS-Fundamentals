package com.manish.CoreJava.ArchitecturalPatterns;

class UserView {
    UserView() {
    }

    public void displayUserDetails(String username, String email) {
        System.out.println("Username: " + username);
        System.out.println("Email: " + email);
    }
}
