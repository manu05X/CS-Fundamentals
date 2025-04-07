package com.manish.LLD.CoupounSystem.Type2.rule;

import com.manish.LLD.CoupounSystem.Type2.context.OrderContext;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;

// Core engine

@Getter
@Setter
public class RuleEvaluator {
    public boolean evaluateRules(List<CouponRule> rules, OrderContext context) {
        return rules.stream()
                .sorted(Comparator.comparingInt(CouponRule::getPriority))
                .allMatch(rule -> rule.evaluate(context));
    }
}
