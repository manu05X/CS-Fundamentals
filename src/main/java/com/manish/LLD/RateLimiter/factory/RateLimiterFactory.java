package com.manish.LLD.RateLimiter.factory;

import com.manish.LLD.RateLimiter.service.strategy.FixedWindowRateLimiter;
import com.manish.LLD.RateLimiter.service.RateLimiter;
import com.manish.LLD.RateLimiter.service.strategy.SlidingWindowRateLimiter;
import com.manish.LLD.RateLimiter.config.RateLimiterConfig;
import com.manish.LLD.RateLimiter.service.strategy.TokenBucketRateLimiter;

public class RateLimiterFactory {
    public static RateLimiter createRateLimiter(RateLimiterType type, RateLimiterConfig config){
    //public static RateLimiter createRateLimiter(RateLimiterType type, int maxRequests, long windowSizeInMillis, int refillRate) {
        RateLimiter rateLimiter;

        switch (type){
            case FIXED_WINDOW:
                rateLimiter = new FixedWindowRateLimiter(config.getMaxRequests(), config.getWindowSizeInMillis());
                break;

            case SLIDING_WINDOW:
                rateLimiter = new SlidingWindowRateLimiter(config.getMaxRequests(), config.getWindowSizeInMillis());
                break;

//            case TOKEN_BUCKET:
//                rateLimiter = new TokenBucketRateLimiter(config.getMaxRequests(),);
//                break;

            default:
                throw new IllegalArgumentException("Unknown rate limiter type");
        }

        config.addObserver(rateLimiter); // Registering as Observer
        return rateLimiter;
    }
}
