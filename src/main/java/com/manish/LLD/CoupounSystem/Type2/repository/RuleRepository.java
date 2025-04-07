package com.manish.LLD.CoupounSystem.Type2.repository;

import java.util.List;

public interface RuleRepository {
    List<CouponRule> findRulesByCouponId(String couponId);
}
