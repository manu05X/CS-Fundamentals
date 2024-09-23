package com.manish.Codes.CoreJava.ArchitecturalPatterns.MVVMExample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

// com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main class to demonstrate MVVM pattern
public class MVVMExample {
    public static void main(String[] args) {
        // Create a UserModel
        UserModel model = new UserModel();

        // Create a UserViewModel and associate it with the UserModel
        UserViewModel viewModel = new UserViewModel(model);

        // Set user details through ViewModel
        viewModel.setUsername("jane_smith");
        viewModel.setEmail("jane.smith@example.com");

        // Display user details directly from the model
        System.out.println("Username: " + model.getUsername()); // Output: Username: jane_smith
        System.out.println("Email: " + model.getEmail()); // Output: Email: jane.smith@example.com
    }
}
