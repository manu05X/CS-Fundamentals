package com.manish.LLD.RideSharingSystem;

import com.manish.LLD.RideSharingSystem.manager.RideManager;
import com.manish.LLD.RideSharingSystem.models.User;

public class Main {
    public static void main(String[] args) {
        RideManager rideManager = new RideManager();
        User user = new User("U1", "John Doe", "Male", 30, "john@example.com", "1234567890");
        rideManager.addUser(user);

        System.out.println("User added: " + user.getName());
    }
}
