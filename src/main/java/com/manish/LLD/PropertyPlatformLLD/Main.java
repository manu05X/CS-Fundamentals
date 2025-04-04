package com.manish.LLD.PropertyPlatformLLD;

import com.manish.LLD.PropertyPlatformLLD.services.PropertyService;
import com.manish.LLD.PropertyPlatformLLD.services.SearchService;
import com.manish.LLD.PropertyPlatformLLD.services.UserService;
import java.util.Scanner;

public class Main {
    private UserService userService;
    private PropertyService propertyService;
    private SearchService searchProperties;
    private Scanner scanner;

    public Main() {
        this.userService = new UserService();
        this.propertyService = new PropertyService(userService);
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    public void start() {
        System.out.println("Welcome to Property Platform");
        System.out.println("Available commands: register, login, logout, listproperty, search, shortlist, viewshortlisted, viewlisted, marksold");

        while (true) {
            System.out.print("→ ");
            String command = scanner.nextLine().trim().toLowerCase();

            try {
                switch (command) {
                    case "register":
                        userService.registerUser(scanner);
                        break;
                    case "login":
                        userService.loginUser(scanner);
                        break;
                    case "logout":
                        userService.logoutUser();
                        break;
                    case "listproperty":
                        propertyService.listProperty(scanner);
                        break;
                    case "search":
                        searchProperties.searchProperties(scanner);
                        break;
                    case "shortlist":
                        propertyService.shortlistProperty(scanner);
                        break;
                    case "viewshortlisted":
                        propertyService.viewShortlisted();
                        break;
                    case "viewlisted":
                        propertyService.viewListed();
                        break;
                    case "marksold":
                        propertyService.markSold(scanner);
                        break;
                    case "exit":
                        System.exit(0);
                    default:
                        System.out.println("← Invalid command");
                }
            } catch (Exception e) {
                System.out.println("← Error: " + e.getMessage());
            }
        }
    }
}