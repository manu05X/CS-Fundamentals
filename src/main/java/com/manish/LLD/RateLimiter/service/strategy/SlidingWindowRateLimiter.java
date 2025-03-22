package com.manish.LLD.RateLimiter.service.strategy;

import com.manish.LLD.RateLimiter.service.AbstractRateLimiter;
import com.manish.LLD.RateLimiter.service.RateLimiter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SlidingWindowRateLimiter extends AbstractRateLimiter {
    private Map<String, Queue<Long>> requestTimeStamps; // Tracks timestamps of requests per client

    public SlidingWindowRateLimiter(int maxRequests, long windowSizeInMillis) {
        super(maxRequests, windowSizeInMillis);
        this.requestTimeStamps = new HashMap<>();
    }

    @Override
    protected boolean isRequestAllowed(String clientId) {
        long currentTime = System.currentTimeMillis();
        requestTimeStamps.putIfAbsent(clientId, new LinkedList<>());

        Queue<Long> timeStamps = requestTimeStamps.get(clientId);

        // Remove timestamps outside the current window
        while (!timeStamps.isEmpty() && currentTime - timeStamps.peek() > windowSizeInMillis) {
            timeStamps.poll();
        }

        // Check if the request count is within the limit
        if (timeStamps.size() < maxRequests) {
            timeStamps.add(currentTime);
            return true;
        } else {
            return false;
        }
    }
}