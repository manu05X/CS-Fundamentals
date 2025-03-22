package com.manish.LLD.RateLimiter.service;

public abstract class AbstractRateLimiter implements RateLimiter {
    protected int maxRequests; // Maximum allowed requests in the window
    protected long windowSizeInMillis; // Size of the time window in milliseconds

    public AbstractRateLimiter(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
    }

    @Override
    public boolean allowRequest(String clientId) {
        return isRequestAllowed(clientId);
    }

    /**
     * Abstract method to be implemented by subclasses.
     * Contains the core logic for allowing or denying a request.
     *
     * @param clientId The ID of the client making the request.
     * @return true if the request is allowed, false otherwise.
     */
    protected abstract boolean isRequestAllowed(String clientId);

    @Override
    public void updateConfig(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
    }

    // Getters for configuration (optional, but useful for debugging or logging)
    public int getMaxRequests() {
        return maxRequests;
    }

    public long getWindowSizeInMillis() {
        return windowSizeInMillis;
    }
}