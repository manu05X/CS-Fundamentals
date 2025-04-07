package com.manish.LLD.CoupounSystem.Type1.service;

import com.manish.LLD.CoupounSystem.Type1.model.Coupon;
import com.manish.LLD.CoupounSystem.Type1.model.Order;

import java.util.List;

public interface CouponRecommendation {
    List<Coupon> getCoupons(Order order);
}