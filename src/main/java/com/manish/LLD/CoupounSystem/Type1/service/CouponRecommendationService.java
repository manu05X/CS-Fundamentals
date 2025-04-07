package com.manish.LLD.CoupounSystem.Type1.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CouponRecommendationService {
    private static final int THREAD_POOL_SIZE = 10;

    private static final ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static ExecutorService getThreadPool(){
        return threadPool;
    }
}
