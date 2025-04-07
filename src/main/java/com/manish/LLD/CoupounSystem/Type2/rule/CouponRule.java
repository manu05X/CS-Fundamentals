package com.manish.LLD.CoupounSystem.Type2.rule;



import com.manish.LLD.CoupounSystem.Type2.context.OrderContext;
import com.manish.LLD.CoupounSystem.Type2.model.RuleOperator;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class CouponRule {
    protected String ruleId;
    protected RuleOperator operator;
    protected int priority;
    protected List<RuleCondition> conditions;

    public abstract boolean evaluate(OrderContext context);
}
