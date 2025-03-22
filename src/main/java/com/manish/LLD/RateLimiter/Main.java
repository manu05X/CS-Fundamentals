package com.manish.LLD.RateLimiter;

import com.manish.LLD.RateLimiter.config.ClientRateLimiterConfig;
import com.manish.LLD.RateLimiter.config.RateLimiterConfig;
import com.manish.LLD.RateLimiter.manager.RateLimiterManager;
import com.manish.LLD.RateLimiter.service.RateLimiter;
import com.manish.LLD.RateLimiter.service.strategy.FixedWindowRateLimiter;

/*
public class Main {
    public static void main(String[] args) {
        RateLimiterManager manager = RateLimiterManager.getInstance();

        // Initial Configuration Test
        System.out.println("Initial Configuration Test: ");
        for(int i = 0; i < 12; i++){
            System.out.println(manager.allowRequest("client1"));
        }

        //updating configuration at runtime
        System.out.println("Updating Configuration....");
        manager.updateConfig(20, 60000);

        //
        System.out.println("Post-Updating Configuration Test: ");
        for(int i = 0; i < 22; i++){
            System.out.println(manager.allowRequest("client1"));
        }

    }
}
*/


/*
public class Main {
    public static void main(String[] args) {
        // Create a ClientRateLimiterConfig instance
        ClientRateLimiterConfig clientRateLimiterConfig = new ClientRateLimiterConfig();

        // Set custom configurations for clients
        clientRateLimiterConfig.setClientConfigs("client1", 5, 10000); // 5 requests per 10 seconds
        clientRateLimiterConfig.setClientConfigs("client2", 10, 60000); // 10 requests per minute

        // Retrieve configurations for clients
        RateLimiterConfig config1 = clientRateLimiterConfig.getClientConfig("client1");
        RateLimiterConfig config2 = clientRateLimiterConfig.getClientConfig("client2");
        RateLimiterConfig defaultConfig = clientRateLimiterConfig.getClientConfig("client3"); // Uses default config

        // Create rate limiters for clients
        RateLimiter rateLimiter1 = new FixedWindowRateLimiter(config1.getMaxRequests(), config1.getWindowSizeInMillis());
        RateLimiter rateLimiter2 = new FixedWindowRateLimiter(config2.getMaxRequests(), config2.getWindowSizeInMillis());
        RateLimiter defaultRateLimiter = new FixedWindowRateLimiter(defaultConfig.getMaxRequests(), defaultConfig.getWindowSizeInMillis());

        // Test rate limiters
//        System.out.println("Client1 allowed: " + rateLimiter1.allowRequest("client1")); // true
//        System.out.println("Client2 allowed: " + rateLimiter2.allowRequest("client2")); // true
//        System.out.println("Client3 allowed: " + defaultRateLimiter.allowRequest("client3")); // true (uses default config)

        // Simulate multiple requests for client1
        for (int i = 0; i < 6; i++) {
            System.out.println("Client1 request " + (i + 1) + " allowed: " + rateLimiter1.allowRequest("client1"));
        }

        for (int i = 0; i < 12; i++) {
            System.out.println("Client2 request " + (i + 1) + " allowed: " + rateLimiter2.allowRequest("client2"));
        }

        for (int i = 0; i < 22; i++) {
            System.out.println("Client3 request " + (i + 1) + " allowed: " + defaultRateLimiter.allowRequest("client3"));
        }
    }
}

 */


public class Main {
    public static void main(String[] args) {
        // Get the RateLimiterManager instance
        RateLimiterManager manager = RateLimiterManager.getInstance();

        // Set custom configurations for clients
        manager.setClientConfig("client1", 5, 10000); // 5 requests per 10 seconds
        manager.setClientConfig("client2", 10, 60000); // 10 requests per minute

        // Get rate limiters for clients
        RateLimiter rateLimiter1 = manager.getRateLimiter("client1");
        RateLimiter rateLimiter2 = manager.getRateLimiter("client2");
        RateLimiter defaultRateLimiter = manager.getRateLimiter("client3"); // Uses default config

        // Test rate limiters
//        System.out.println("Client1 allowed: " + rateLimiter1.allowRequest("client1")); // true
//        System.out.println("Client2 allowed: " + rateLimiter2.allowRequest("client2")); // true
//        System.out.println("Client3 allowed: " + defaultRateLimiter.allowRequest("client3")); // true (uses default config)

        // Simulate multiple requests for client1
        for (int i = 0; i < 6; i++) {
            System.out.println("Client1 request " + (i + 1) + " allowed: " + rateLimiter1.allowRequest("client1"));
        }

        for (int i = 0; i < 12; i++) {
            System.out.println("Client2 request " + (i + 1) + " allowed: " + rateLimiter2.allowRequest("client2"));
        }

        for (int i = 0; i < 22; i++) {
            System.out.println("Client3 request " + (i + 1) + " allowed: " + defaultRateLimiter.allowRequest("client3"));
        }
    }
}


/*
public class Main {
    public static void main(String[] args) {
        // Create a ClientRateLimiterConfig instance
        ClientRateLimiterConfig clientRateLimiterConfig = new ClientRateLimiterConfig();

        // Set custom configurations for clients
        clientRateLimiterConfig.setClientConfigs("client1", 100, 60000); // 100 requests per minute
        clientRateLimiterConfig.setClientConfigs("client2", 50, 1000); // 50 requests per second

        // Retrieve configurations for clients
        RateLimiterConfig config1 = clientRateLimiterConfig.getClientConfig("client1");
        RateLimiterConfig config2 = clientRateLimiterConfig.getClientConfig("client2");
        RateLimiterConfig defaultConfig = clientRateLimiterConfig.getClientConfig("client3"); // Uses default config

        // Create rate limiters for clients
        RateLimiter rateLimiter1 = new RedisRateLimiter(config1.getMaxRequests(), config1.getWindowSizeInMillis());
        RateLimiter rateLimiter2 = new RedisRateLimiter(config2.getMaxRequests(), config2.getWindowSizeInMillis());
        RateLimiter defaultRateLimiter = new RedisRateLimiter(defaultConfig.getMaxRequests(), defaultConfig.getWindowSizeInMillis());

        // Test rate limiters
        System.out.println("Client1 allowed: " + rateLimiter1.allowRequest("client1")); // true
        System.out.println("Client2 allowed: " + rateLimiter2.allowRequest("client2")); // true
        System.out.println("Client3 allowed: " + defaultRateLimiter.allowRequest("client3")); // true (uses default config)
    }
}
*/