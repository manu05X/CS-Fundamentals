package com.manish.CoreJava.ArchitecturalPatterns;

class UserController {
    private User model;
    private UserView view;

    public UserController(User model, UserView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        this.view.displayUserDetails(this.model.getUsername(), this.model.getEmail());
    }
}