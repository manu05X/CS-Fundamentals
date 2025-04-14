package com.manish.CoreJava.ArchitecturalPatterns;

public class MVCExample {
    public MVCExample() {
    }

    public static void main(String[] args) {
        User user = new User("john_doe", "john.doe@example.com");
        UserView view = new UserView();
        UserController controller = new UserController(user, view);
        controller.updateView();
    }
}
