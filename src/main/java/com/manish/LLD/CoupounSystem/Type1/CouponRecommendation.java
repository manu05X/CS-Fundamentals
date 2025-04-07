package com.manish.LLD.CoupounSystem.Type1;

import java.util.List;

public interface CouponRecommendation {
    List<Coupon> getCoupons(Order order);
}