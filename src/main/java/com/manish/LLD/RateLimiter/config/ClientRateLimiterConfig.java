package com.manish.LLD.RateLimiter.config;

import com.manish.LLD.RateLimiter.service.RateLimiter;

import java.util.HashMap;
import java.util.Map;

public class ClientRateLimiterConfig {
    private Map<String, RateLimiterConfig> clientConfigs = new HashMap<>();

    public void setClientConfigs(String clientId, int maxRequests, long windowSizeInMillis){
        RateLimiterConfig config = new RateLimiterConfig(maxRequests, windowSizeInMillis);
        clientConfigs.put(clientId, config);
    }

    public RateLimiterConfig getClientConfig(String clientId){
        return clientConfigs.getOrDefault(clientId, new RateLimiterConfig(100, 60000));
    }
}
