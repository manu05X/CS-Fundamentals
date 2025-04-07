package com.manish.LLD.CoupounSystem.Type1.rules;

import com.manish.LLD.CoupounSystem.Type1.model.Order;

public interface Rule {
    boolean check(Order order);
}
