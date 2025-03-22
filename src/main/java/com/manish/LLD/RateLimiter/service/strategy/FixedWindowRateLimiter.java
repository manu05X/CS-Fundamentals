package com.manish.LLD.RateLimiter.service.strategy;

import com.manish.LLD.RateLimiter.service.AbstractRateLimiter;

import java.util.HashMap;
import java.util.Map;

public class FixedWindowRateLimiter extends AbstractRateLimiter {
    private Map<String, Integer> requestCounts; // Tracks request counts per client
    private Map<String, Long> windowStartTime; // Tracks the start time of the current window per client

    public FixedWindowRateLimiter(int maxRequests, long windowSizeInMillis) {
        super(maxRequests, windowSizeInMillis);
        this.requestCounts = new HashMap<>();
        this.windowStartTime = new HashMap<>();
    }

    @Override
    protected boolean isRequestAllowed(String clientId) {
        long currentTime = System.currentTimeMillis();

        // Initialize or reset the window for the client
        if (!windowStartTime.containsKey(clientId)) {
            windowStartTime.put(clientId, currentTime);
            requestCounts.put(clientId, 0);
        }

        long windowStart = windowStartTime.get(clientId);

        // Check if the current window has expired
        if (currentTime - windowStart > windowSizeInMillis) {
            // Reset the window
            windowStartTime.put(clientId, currentTime);
            requestCounts.put(clientId, 0);
        }

        int requestCount = requestCounts.get(clientId);
        // Check if the request count is within the limit
        if (requestCount < maxRequests) {
            requestCounts.put(clientId, requestCount + 1);
            return true;
        } else {
            return false;
        }
    }
}
