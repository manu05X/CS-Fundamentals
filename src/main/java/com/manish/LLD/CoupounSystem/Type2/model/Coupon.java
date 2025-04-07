package com.manish.LLD.CoupounSystem.Type2.model;


import com.manish.LLD.CoupounSystem.Type2.context.OrderContext;
import com.manish.LLD.CoupounSystem.Type2.rule.CouponRule;
import com.manish.LLD.CoupounSystem.Type2.rule.RuleEvaluator;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class Coupon {
    private String couponId;
    private String code;
    private String description;
    private DiscountType discountType;
    private double discountValue;
    private Double maxDiscount;
    private Date startDate;
    private Date expiryDate;
    private boolean isActive;
    private List<CouponRule> rules;

    // Constructor, getters, setters
    public boolean isApplicable(OrderContext orderContext, RuleEvaluator evaluator) {
        if (!isActive || new Date().before(startDate) || new Date().after(expiryDate)) {
            return false;
        }
        return evaluator.evaluateRules(rules, orderContext);
    }
}
