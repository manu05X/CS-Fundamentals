package com.manish.LLD.CoupounSystem.Type2;

import com.manish.LLD.BookMyShow.Part1.models.enums.PaymentMethod;
import com.manish.LLD.CoupounSystem.Type2.context.OrderContext;
import com.manish.LLD.CoupounSystem.Type2.context.ProductContext;
import com.manish.LLD.CoupounSystem.Type2.model.Product;
import com.manish.LLD.CoupounSystem.Type2.model.UserContext;
import com.manish.LLD.CoupounSystem.Type2.model.UserType;
import com.manish.LLD.CoupounSystem.Type2.result.CouponApplicabilityResult;
//import com.manish.LLD.CoupounSystem.Type2.service.CouponRecommendationSystem;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // CouponRecommendationSystem system = new CouponRecommendationSystem();
        
        // Create mock order context
//        UserContext userContext = new UserContext("user123", UserType.REGULAR, 5);
//        ProductContext productContext = new ProductContext(
//            Arrays.asList(new Product("p1", "groceries", 100), new Product("p2", "electronics", 500))
//        );
        //OrderContext orderContext = new OrderContext(userContext, productContext, 600, PaymentMethod.UPI);
        
        // Get recommendations
        //List<CouponApplicabilityResult> recommendations = system.recommendCoupons(orderContext);
        
        // Display results
        System.out.println("Recommended Coupons:");
        //recommendations.forEach(result ->
            //System.out.println(result.getCoupon().getCode() + " - " + result.getMessage()));
        
        //system.shutdown();
    }
}