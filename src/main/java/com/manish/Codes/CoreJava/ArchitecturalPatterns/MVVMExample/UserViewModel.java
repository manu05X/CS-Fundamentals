package com.manish.Codes.CoreJava.ArchitecturalPatterns.MVVMExample;

// ViewModel class that bridges between Model and View
class UserViewModel {
    private UserModel model;

    public UserViewModel(UserModel model) {
        this.model = model;
    }

    public String getUsername() {
        return model.getUsername();
    }

    public void setUsername(String username) {
        model.setUsername(username);
    }

    public String getEmail() {
        return model.getEmail();
    }

    public void setEmail(String email) {
        model.setEmail(email);
    }
}
