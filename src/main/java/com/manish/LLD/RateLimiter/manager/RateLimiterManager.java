package com.manish.LLD.RateLimiter.manager;

import com.manish.LLD.RateLimiter.config.ClientRateLimiterConfig;
import com.manish.LLD.RateLimiter.factory.RateLimiterType;
import com.manish.LLD.RateLimiter.service.RateLimiter;
import com.manish.LLD.RateLimiter.config.RateLimiterConfig;
import com.manish.LLD.RateLimiter.factory.RateLimiterFactory;
import com.manish.LLD.RateLimiter.service.strategy.FixedWindowRateLimiter;

/*
public class RateLimiterManager {
    private static RateLimiterManager instance;
    private RateLimiter rateLimiter;
    private RateLimiterConfig config;

    private RateLimiterManager() {
        this.config = new RateLimiterConfig(5, 60000); // Default config: 10 requests per 60 seconds
        this.rateLimiter = RateLimiterFactory.createRateLimiter("fixed", config);
    }

    public static RateLimiterManager getInstance() {
        if (instance == null) {
            synchronized (RateLimiterManager.class) {
                if (instance == null) {
                    instance = new RateLimiterManager();
                }
            }
        }
        return instance;
    }

    public boolean allowRequest(String clientId) {
        return rateLimiter.allowRequest(clientId);
    }

    public void updateConfig(int maxRequests, long windowSizeInMillis) {
        config.setMaxRequests(maxRequests);
        config.setWindowSizeInMillis(windowSizeInMillis);
    }
}
 */



public class RateLimiterManager {
    private static RateLimiterManager instance;
    private ClientRateLimiterConfig clientRateLimiterConfig;

    private RateLimiterManager() {
        this.clientRateLimiterConfig = new ClientRateLimiterConfig();
    }

    public static RateLimiterManager getInstance() {
        if (instance == null) {
            synchronized (RateLimiterManager.class) {
                if (instance == null) {
                    instance = new RateLimiterManager();
                }
            }
        }
        return instance;
    }

    public void setClientConfig(String clientId, int maxRequests, long windowSizeInMillis) {
        clientRateLimiterConfig.setClientConfigs(clientId, maxRequests, windowSizeInMillis);
    }

//    public void setClientConfig(String clientId, RateLimiterType type, int maxRequests, long windowSizeInMillis, int refillRate) {
//        RateLimiter rateLimiter = RateLimiterFactory.createRateLimiter(type, maxRequests, windowSizeInMillis, refillRate);
//        clientRateLimiters.put(clientId, rateLimiter);
//    }

    public RateLimiter getRateLimiter(String clientId) {
        RateLimiterConfig config = clientRateLimiterConfig.getClientConfig(clientId);
        return new FixedWindowRateLimiter(config.getMaxRequests(), config.getWindowSizeInMillis());
    }
}