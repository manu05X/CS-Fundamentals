package com.manish.LLD.CoupounSystem.Type2.repository;

import com.manish.LLD.CoupounSystem.Type2.model.Coupon;

import java.util.List;

// Repository interfaces
public interface CouponRepository {
    List<Coupon> findAllActiveCoupons();

    Coupon findById(String couponId);
}
