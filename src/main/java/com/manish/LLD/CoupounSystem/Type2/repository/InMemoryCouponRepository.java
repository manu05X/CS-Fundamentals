package com.manish.LLD.CoupounSystem.Type2.repository;

import com.manish.LLD.CoupounSystem.Type2.model.Coupon;
import com.manish.LLD.CoupounSystem.Type2.model.DiscountType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// In-memory implementations for demo
public class InMemoryCouponRepository implements CouponRepository {
    private Map<String, Coupon> couponStore = new ConcurrentHashMap<>();

    public InMemoryCouponRepository() {
        // Initialize with some test coupons
        Coupon c1 = new Coupon();
        c1.setCouponId("c1");
        c1.setCode("WELCOME10");
        c1.setDiscountType(DiscountType.PERCENTAGE);
        c1.setDiscountValue(10);
        c1.setActive(true);

        couponStore.put("c1", c1);
    }

    @Override
    public List<Coupon> findAllActiveCoupons() {
        return new ArrayList<>(couponStore.values());
    }

    @Override
    public Coupon findById(String couponId) {
        return couponStore.get(couponId);
    }
}
