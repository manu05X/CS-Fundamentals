package com.manish.LLD.CoupounSystem.Type1;

import java.util.List;

public class User {
    private String userId;
    private String userType;
    private List<String> pastPurchases;

    public User(String userId, String userType, List<String> pastPurchases) {
        this.userId = userId;
        this.userType = userType;
        this.pastPurchases = pastPurchases;
    }

    public String getUserType() {
        return userType;
    }

    public List<String> getPastPurchases() {
        return pastPurchases;
    }
}
