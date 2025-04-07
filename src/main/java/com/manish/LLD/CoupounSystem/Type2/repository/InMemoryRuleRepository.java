package com.manish.LLD.CoupounSystem.Type2.repository;

import com.manish.LLD.CoupounSystem.Type2.model.ConditionOperator;
import com.manish.LLD.CoupounSystem.Type2.model.RuleOperator;
import com.manish.LLD.CoupounSystem.Type2.model.UserType;
import com.manish.LLD.CoupounSystem.Type2.rule.CouponRule;
import com.manish.LLD.CoupounSystem.Type2.rule.RuleCondition;
import com.manish.LLD.CoupounSystem.Type2.rule.UserRule;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryRuleRepository implements RuleRepository {
    private Map<String, List<CouponRule>> ruleStore = new ConcurrentHashMap<>();

    public InMemoryRuleRepository() {
        // Add some test rules
        List<CouponRule> rulesForC1 = new ArrayList<>();

        UserRule userRule = new UserRule();
        userRule.setRuleId("r1");
        userRule.setOperator(RuleOperator.AND);
        userRule.setPriority(1);

        RuleCondition condition = new RuleCondition();
        condition.setFieldName("userType");
        condition.setOperator(ConditionOperator.EQUALS);
        condition.setValue(UserType.NEW);
        userRule.setConditions(Arrays.asList(condition));

        rulesForC1.add(userRule);
        ruleStore.put("c1", rulesForC1);
    }

    @Override
    public List<CouponRule> findRulesByCouponId(String couponId) {
        return ruleStore.getOrDefault(couponId, Collections.emptyList());
    }
}
