//package com.manish.LLD.RateLimiter.service;
//
//public class RedisRateLimiter implements RateLimiter{
//    private int maxRequests; // Maximum allowed requests in the window
//    private long windowSizeInMillis; // Size of the time window in milliseconds
//
//    private Jedis jedis;
//
//    public RedisRateLimiter(int maxRequests, long windowSizeInMillis){
//        this.maxRequests = maxRequests;
//        this.windowSizeInMillis = windowSizeInMillis;
//        this.jedis = new Jedis("localhost");
//    }
//
//
//    @Override
//    public boolean allowRequest(String clientId) {
//        long currentTime = System.currentTimeMillis();
//        String key = "rate_limiter"+clientId;
//
//        String lastRequestedTimeStr = jedis.hget(key, "lastRequestTime");
//        String requestCountStr = jedis.hget(key, "requestCount");
//
//        long lastRequestTime = lastRequestedTimeStr == null ? 0 : Long.parseLong(lastRequestedTimeStr);
//        int requestCount = requestCountStr == null ? 0 : Integer.parseInt(requestCountStr);
//
//        if(currentTime - lastRequestTime >= windowSizeInMillis){
//            requestCount = 0;
//            lastRequestTime = currentTime;
//        }
//
//        if(requestCount < maxRequests) {
//            jedis.hset(key, "lastRequestTime", String.valueOf(currentTime));
//            jedis.hset(key, "requestCount", String.valueOf(requestCount + 1));
//
//            return true;
//        }
//
//        return false;
//    }
//
//    @Override
//    public void updateConfig(int maxRequests, long windowSizeInMills) {
//        this.maxRequests = maxRequests;
//        this.windowSizeInMillis = windowSizeInMills;
//    }
//}
