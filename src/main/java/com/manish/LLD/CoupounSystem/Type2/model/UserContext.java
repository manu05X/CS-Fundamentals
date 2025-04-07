package com.manish.LLD.CoupounSystem.Type2.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserContext {
    private String userId;
    private UserType userType;
    private int orderCount;
    // Other user attributes
}
