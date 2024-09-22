package com.manish.Codes.CoreJava.ArchitecturalPatterns.MVVMExample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// Model class representing a simple User entity
class UserModel {
    private StringProperty username = new SimpleStringProperty();
    private StringProperty email = new SimpleStringProperty();

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
}
