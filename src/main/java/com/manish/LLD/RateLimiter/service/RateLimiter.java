package com.manish.LLD.RateLimiter.service;

public interface RateLimiter {
    boolean allowRequest(String clientId);
    void updateConfig(int maxRequests, long windowSizeInMills);
}
