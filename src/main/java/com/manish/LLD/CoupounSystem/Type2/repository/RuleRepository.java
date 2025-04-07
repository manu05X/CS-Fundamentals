package com.manish.LLD.CoupounSystem.Type2.repository;

import com.manish.LLD.CoupounSystem.Type2.rule.CouponRule;

import java.util.List;

public interface RuleRepository {
    List<CouponRule> findRulesByCouponId(String couponId);
}
