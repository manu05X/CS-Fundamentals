package com.manish.LLD.CoupounSystem.Type1;

import java.util.ArrayList;
import java.util.List;

public class CouponRecommendationImpl implements CouponRecommendation{
    private List<Coupon> availableCoupon;

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
