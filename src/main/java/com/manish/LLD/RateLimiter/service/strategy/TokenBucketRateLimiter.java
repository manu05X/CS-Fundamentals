package com.manish.LLD.RateLimiter.service.strategy;

import com.manish.LLD.RateLimiter.service.RateLimiter;

public class TokenBucketRateLimiter implements RateLimiter {
    private int maxRequests;
    private long windowSizeInMillis;

    private int maxTokens;
    private int refillRate;
    private int currentTokens;
    private long lastRifillTimestamp;

    public TokenBucketRateLimiter(int maxTokens, int refillRate){
        this.maxTokens = maxTokens;
        this.refillRate = refillRate;
        this.currentTokens = maxTokens;
        this.lastRifillTimestamp = System.currentTimeMillis();
    }

    @Override
    public boolean allowRequest(String clientId){
        long currentTime = System.currentTimeMillis();
        refillTokens(currentTime);

        if(currentTokens > 0){
            currentTokens--;
            return true;
        }

        return false;
    }

    private void refillTokens(long currentTime){
        long timeElapsed = currentTime - lastRifillTimestamp;
        int tokensToAdd = (int)(timeElapsed/1000*refillRate);

        currentTokens = Math.min(maxTokens, currentTokens+tokensToAdd);
        lastRifillTimestamp = currentTime;
    }


        @Override
    public void updateConfig(int maxRequests, long windowSizeInMillis){
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
    }
}
