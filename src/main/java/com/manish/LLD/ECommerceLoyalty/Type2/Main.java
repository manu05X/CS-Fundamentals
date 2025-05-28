package com.manish.LLD.ECommerceLoyalty.Type2;


import com.manish.LLD.ECommerceLoyalty.Type2.cli.CommandProcessor;
import com.manish.LLD.ECommerceLoyalty.Type2.repository.InMemoryUserRepository;
import com.manish.LLD.ECommerceLoyalty.Type2.repository.UserRepository;
import com.manish.LLD.ECommerceLoyalty.Type2.service.DiscountCalculator;
import com.manish.LLD.ECommerceLoyalty.Type2.service.GamificationService;
import com.manish.LLD.ECommerceLoyalty.Type2.service.PointsCalculator;
import com.manish.LLD.ECommerceLoyalty.Type2.service.RedemptionValidator;


public class Main {
    public static void main(String[] args) {
        // Initialize components
        UserRepository userRepository = new InMemoryUserRepository();
        PointsCalculator pointsCalculator = new PointsCalculator();
        RedemptionValidator redemptionValidator = new RedemptionValidator();
        DiscountCalculator discountCalculator = new DiscountCalculator();
        
        GamificationService gamificationService = new GamificationService(
            userRepository, pointsCalculator, redemptionValidator, discountCalculator);
            
        CommandProcessor commandProcessor = new CommandProcessor(gamificationService);
        
        // Test cases from the problem statement
        String[] testCommands = {
            "onboard user1",
            "purchase user1 800.00 0",
            "purchase user1 4200.00 100",
            "purchase user1 4200.00 0",
            "purchase user1 3000.00 300",
            "purchase user1 5000.00 0",
            "purchase user1 12000.00 800",
            "getUserStats user1"
        };
        
        for (String cmd : testCommands) {
            System.out.println("-> " + cmd);
            System.out.println(commandProcessor.processCommand(cmd));
            System.out.println();
        }

                // In the test commands array:
        String[] testCommands2 = {
                "onboard user2",
                "purchase user2 800.00 0",    // Order 1
                "purchase user2 4200.00 100",    // Order 2
                "purchase user2 4200.00 0",    // Order 3
                "purchase user2 3000.00 300",    // Order 4
                "purchase user2 5000.00 0",    // Order 5 (>3 orders)
                "purchase user2 12000.00 800",  // Should now qualify for discount
                "getUserStats user2"
        };

        for (String cmd : testCommands2) {
            System.out.println("-> " + cmd);
            System.out.println(commandProcessor.processCommand(cmd));
            System.out.println();
        }
    }
}




/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialize components
        UserRepository userRepository = new InMemoryUserRepository();
        PointsCalculator pointsCalculator = new PointsCalculator();
        RedemptionValidator redemptionValidator = new RedemptionValidator();
        DiscountCalculator discountCalculator = new DiscountCalculator();

        GamificationService gamificationService = new GamificationService(
                userRepository, pointsCalculator, redemptionValidator, discountCalculator);

        CommandProcessor commandProcessor = new CommandProcessor(gamificationService);

        if (args.length > 0) {
            // Batch mode - execute commands from arguments
            executeBatchMode(args, commandProcessor);
        } else {
            // Interactive mode
            executeInteractiveMode(commandProcessor);
        }
    }

    private static void executeBatchMode(String[] args, CommandProcessor processor) {
        System.out.println("Executing in batch mode...\n");
        for (String cmd : args) {
            processCommand(cmd, processor);
        }
    }

    private static void executeInteractiveMode(CommandProcessor processor) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nE-Commerce Gamification System");
        System.out.println("==============================");
        printHelp();

        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            } else if (input.equalsIgnoreCase("help")) {
                printHelp();
            } else if (input.equalsIgnoreCase("test")) {
                runTestCases(processor);
            } else if (!input.isEmpty()) {
                processCommand(input, processor);
            }
        }

        scanner.close();
        System.out.println("System shutdown");
    }

    private static void processCommand(String command, CommandProcessor processor) {
        try {
            System.out.println(processor.processCommand(command));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void runTestCases(CommandProcessor processor) {
        System.out.println("\nRunning test cases...");
        String[] testCommands1 = {
                "onboard user1",
                "purchase user1 800.00 0",
                "purchase user1 4200.00 100",
                "purchase user1 4200.00 0",
                "purchase user1 3000.00 300",
                "purchase user1 5000.00 0",
                "purchase user1 12000.00 800",
                "getUserStats user1"
        };



        for (String cmd : testCommands1) {
            System.out.println("\n-> " + cmd);
            processCommand(cmd, processor);
        }

        for (String cmd : testCommands2) {
            System.out.println("\n-> " + cmd);
            processCommand(cmd, processor);
        }
    }

    private static void printHelp() {
        System.out.println("\nAvailable commands:");
        System.out.println("  onboard <username>        - Register new user");
        System.out.println("  purchase <user> <amount> <points> - Make purchase");
        System.out.println("  getUserStats <user>      - View user status");
        System.out.println("  test                     - Run test cases");
        System.out.println("  help                     - Show this help");
        System.out.println("  exit                     - Quit program");
        System.out.println("\nExample:");
        System.out.println("  purchase john_doe 5000.00 200");
    }
}

 */




/*
@SpringBootApplication
public class ECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(CommandProcessor commandProcessor) {
        return args -> {
            if (args.length > 0) {
                // Process single command from command line arguments
                System.out.println(commandProcessor.processCommand(String.join(" ", args)));
            } else {
                // Interactive mode
                System.out.println("E-Commerce Gamification System");
                System.out.println("Available commands:");
                System.out.println("  onboard <username>");
                System.out.println("  purchase <username> <amount> <points_to_redeem>");
                System.out.println("  getUserStats <username>");
                System.out.println("Type 'exit' to quit");

                Scanner scanner = new Scanner(System.in);
                while (true) {
                    System.out.print("> ");
                    String input = scanner.nextLine().trim();
                    if (input.equalsIgnoreCase("exit")) {
                        break;
                    }
                    if (!input.isEmpty()) {
                        System.out.println(commandProcessor.processCommand(input));
                    }
                }
                scanner.close();
            }
        };
    }

    @Bean
    public UserRepository userRepository() {
        return new InMemoryUserRepository();
    }

    @Bean
    public PointsCalculator pointsCalculator() {
        return new PointsCalculator();
    }

    @Bean
    public RedemptionValidator redemptionValidator() {
        return new RedemptionValidator();
    }

    @Bean
    public DiscountCalculator discountCalculator() {
        return new DiscountCalculator();
    }

    @Bean
    public GamificationService gamificationService(UserRepository userRepository,
                                                 PointsCalculator pointsCalculator,
                                                 RedemptionValidator redemptionValidator,
                                                 DiscountCalculator discountCalculator) {
        return new GamificationService(userRepository, pointsCalculator,
                                      redemptionValidator, discountCalculator);
    }

    @Bean
    public CommandProcessor commandProcessor(GamificationService gamificationService) {
        return new CommandProcessor(gamificationService);
    }
}

 */