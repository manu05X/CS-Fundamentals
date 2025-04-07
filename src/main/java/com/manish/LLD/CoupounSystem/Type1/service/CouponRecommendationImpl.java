package com.manish.LLD.CoupounSystem.Type1.service;

import com.manish.LLD.CoupounSystem.Type1.model.Coupon;
import com.manish.LLD.CoupounSystem.Type1.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
public class CouponRecommendationImpl implements CouponRecommendation {
    private List<Coupon> availableCoupon;
    //

    public CouponRecommendationImpl(List<Coupon> availableCoupon){
        this.availableCoupon = availableCoupon;
    }


    @Override
    public List<Coupon> getCoupons(Order order) {
        List<Coupon> applicableCoupon = new ArrayList<>();
        for (Coupon coupon : availableCoupon){
            if(coupon.isApplicable(order)){
                applicableCoupon.add(coupon);
            }
        }

        return applicableCoupon;
    }
}

 */

public class CouponRecommendationImpl implements CouponRecommendation {
    private final List<Coupon> availableCoupon;
    //
    private final ExecutorService executorService;

    public CouponRecommendationImpl(List<Coupon> availableCoupon){
        this.availableCoupon = availableCoupon;
        this.executorService = Executors.newFixedThreadPool(10);
    }


    @Override
    public List<Coupon> getCoupons(Order order) {
        List<Future<Coupon>> futures = new ArrayList<>();

        for(Coupon coupon : availableCoupon){
            futures.add(executorService.submit(()-> coupon.isApplicable(order) ? coupon : null));
        }

        List<Coupon> applicableCoupon = new ArrayList<>();
        for (Future<Coupon> future : futures){
            try{
                Coupon coupon = future.get();
                if(coupon != null){
                    applicableCoupon.add(coupon);
                }
            } catch (InterruptedException | ExecutionException e){
                e.printStackTrace();
            }
        }

        return applicableCoupon;
    }

    public void shutdown(){
        executorService.shutdown();
    }
}


