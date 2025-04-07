package com.manish.LLD.CoupounSystem.Type2.rule;

import com.manish.LLD.CoupounSystem.Type2.context.OrderContext;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserRule extends CouponRule {
    @Override
    public boolean evaluate(OrderContext context) {
        // Evaluate user-specific conditions
        return conditions.stream().allMatch(cond -> cond.evaluate(context.getUserContext()));
    }
}
