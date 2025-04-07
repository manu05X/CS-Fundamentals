package com.manish.LLD.CoupounSystem.Type2.service;

import com.manish.LLD.CoupounSystem.Type2.context.OrderContext;
import com.manish.LLD.CoupounSystem.Type2.model.Coupon;
import com.manish.LLD.CoupounSystem.Type2.repository.CouponRepository;
import com.manish.LLD.CoupounSystem.Type2.repository.InMemoryCouponRepository;
import com.manish.LLD.CoupounSystem.Type2.repository.InMemoryRuleRepository;
import com.manish.LLD.CoupounSystem.Type2.repository.RuleRepository;
import com.manish.LLD.CoupounSystem.Type2.result.CouponApplicabilityResult;
import com.manish.LLD.CoupounSystem.Type2.rule.RuleEvaluator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class CouponRecommendationSystem {
    private final CouponRepository couponRepository;
    private final RuleRepository ruleRepository;
    private final RuleEvaluator ruleEvaluator;
    private final ExecutorService executorService;

    public CouponRecommendationSystem() {
        this.couponRepository = new InMemoryCouponRepository();
        this.ruleRepository = new InMemoryRuleRepository();
        this.ruleEvaluator = new RuleEvaluator();
        this.executorService = Executors.newFixedThreadPool(10);
    }

    public List<CouponApplicabilityResult> recommendCoupons(OrderContext orderContext) {
        List<Coupon> allCoupons = couponRepository.findAllActiveCoupons();
        List<Future<CouponApplicabilityResult>> futures = new ArrayList<>();

        for (Coupon coupon : allCoupons) {
            futures.add(executorService.submit(() -> {
                boolean applicable = coupon.isApplicable(orderContext, ruleEvaluator);
                return new CouponApplicabilityResult(coupon, applicable,
                        applicable ? "Applicable" : "Not applicable", 0);
            }));
        }

        List<CouponApplicabilityResult> results = new ArrayList<>();
        for (Future<CouponApplicabilityResult> future : futures) {
            try {
                results.add(future.get());
            } catch (InterruptedException | ExecutionException e) {
                // Handle exception
            }
        }

        return results.stream()
                .filter(CouponApplicabilityResult::isApplicable)
                .sorted(Comparator.comparingDouble(r -> -r.getDiscountAmount()))
                .collect(Collectors.toList());
    }

    public void shutdown() {
        executorService.shutdown();
    }
}
