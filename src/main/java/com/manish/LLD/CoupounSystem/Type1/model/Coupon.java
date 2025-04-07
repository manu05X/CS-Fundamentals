package com.manish.LLD.CoupounSystem.Type1.model;

import com.manish.LLD.CoupounSystem.Type1.rules.Rule;

import java.util.List;

public class Coupon {
    private String couponId;
    private double discountAmount;
    private List<Rule> rules;
    private String ruleFormula;

    public Coupon(String couponId, double discountAmount, List<Rule> rules, String ruleFormula) {
        this.couponId = couponId;
        this.discountAmount = discountAmount;
        this.rules = rules;
        this.ruleFormula = ruleFormula;
    }


    public double getDiscountAmount(){
        return discountAmount;
    }

    /*
    public boolean isApplicable(Order order){
        for (Rule rule : rules){
            if(!rule.check(order)){
                return false;
            }
        }

        return true;
    }

     */

    public boolean isApplicable(Order order){
        return rules.parallelStream().allMatch(rule -> rule.check(order));
    }
}

