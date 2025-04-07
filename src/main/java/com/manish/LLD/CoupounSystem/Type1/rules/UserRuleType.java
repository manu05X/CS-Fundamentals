package com.manish.LLD.CoupounSystem.Type1.rules;

import com.manish.LLD.CoupounSystem.Type1.model.Order;

public class UserRuleType implements Rule {
    // private String allowedUserType;
    private final String allowedUserType;

    public UserRuleType(String allowedUserType){
        this.allowedUserType = allowedUserType;
    }

    @Override
    public boolean check(Order order){
        return order.getUser().getUserType().equals(allowedUserType);
    }
}
