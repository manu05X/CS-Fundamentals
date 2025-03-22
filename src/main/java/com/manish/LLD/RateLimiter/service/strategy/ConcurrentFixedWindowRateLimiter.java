package com.manish.LLD.RateLimiter.service.strategy;

import com.manish.LLD.RateLimiter.service.RateLimiter;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentFixedWindowRateLimiter implements RateLimiter {
    private int maxRequests;
    private long windowSizeInMillis;
    private ConcurrentHashMap<String, AtomicInteger> requestCounts;
    private ConcurrentHashMap<String, Long> windowStartTimes;

    public ConcurrentFixedWindowRateLimiter(int maxRequests, long windowSizeInMillis){
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        this.requestCounts = new ConcurrentHashMap<>();
        this.windowStartTimes = new ConcurrentHashMap<>();
    }

    @Override
    public boolean allowRequest(String clientId){
        long currentTime = System.currentTimeMillis();
        windowStartTimes.putIfAbsent(clientId, currentTime);
        requestCounts.putIfAbsent(clientId, new AtomicInteger(0));

        long windowStartTime = windowStartTimes.get(clientId);
        if(currentTime - windowStartTime >= windowSizeInMillis){
            windowStartTimes.put(clientId, currentTime);
            requestCounts.get(clientId).set(0);
        }

        AtomicInteger requestCount = requestCounts.get(clientId);
        if(requestCount.get() < maxRequests){
            requestCount.incrementAndGet();

            return true;
        }

        return false;
    }

    @Override
    public void updateConfig(int maxRequests, long windowSizeInMillis){
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
    }

}
