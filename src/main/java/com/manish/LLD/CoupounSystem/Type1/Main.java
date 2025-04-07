package com.manish.LLD.CoupounSystem.Type1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Rule userRuleType = new UserRuleType("Premium");
        Rule productRuleType = new ProductTypeRule("Groceries");

        List<Rule> coupon1Rule = Arrays.asList(userRuleType, productRuleType);
        Coupon coupon1 = new Coupon("C1", 100, coupon1Rule, "AND(0,1)");

        List<Rule> coupon2Rule = Arrays.asList(productRuleType);
        Coupon coupon2 = new Coupon("C2", 50, coupon2Rule, "0");


        // Create data
        User user = new User("U1", "Premium", new ArrayList<>());
        CartItem item = new CartItem("P1", "Groceries", 2, 200);
        Cart cart = new Cart("C1", Arrays.asList(item));
        Order order = new Order("01", user, cart, 400);


        // Recommend coupons
        CouponRecommendation recommendation = new CouponRecommendationImpl(Arrays.asList(coupon1, coupon2));
        List<Coupon> coupons = recommendation.getCoupons (order);


        coupons.forEach(coupon -> System.out.println("Applicable Coupon "+coupon.getDiscountAmount()));

    }
}
