package com.manish.LLD.ECommerceLoyalty.cli;


import com.manish.LLD.ECommerceLoyalty.service.GamificationService;

public class CommandProcessor {
    private GamificationService gamificationService;

    public CommandProcessor(GamificationService gamificationService) {
        this.gamificationService = gamificationService;
    }

    public String processCommand(String commandLine) {
        String[] parts = commandLine.split(" ");
        String command = parts[0].toLowerCase();
        
        try {
            switch (command) {
                case "onboard":
                    String userName = parts[1];
                    gamificationService.onboardUser(userName);
                    return String.format("User %s onboarded successfully.", userName);
                    
                case "purchase":
                    String purchaseUser = parts[1];
                    double orderAmount = Double.parseDouble(parts[2]);
                    double pointsToRedeem = Double.parseDouble(parts[3]);
                    return gamificationService.purchase(purchaseUser, orderAmount, pointsToRedeem);
                    
                case "getuserstats":
                    String statsUser = parts[1];
                    return gamificationService.getUserStats(statsUser);
                    
                default:
                    return "Invalid command.";
            }
        } catch (Exception e) {
            return "Error processing command: " + e.getMessage();
        }
    }
}