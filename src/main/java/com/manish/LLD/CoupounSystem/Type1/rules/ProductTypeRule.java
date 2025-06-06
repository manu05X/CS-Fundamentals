package com.manish.LLD.CoupounSystem.Type1.rules;

import com.manish.LLD.CoupounSystem.Type1.model.CartItem;
import com.manish.LLD.CoupounSystem.Type1.model.Order;

public class ProductTypeRule implements Rule {
    private String requiredTypeProduct;

    public ProductTypeRule(String requiredTypeProduct){
        this.requiredTypeProduct = requiredTypeProduct;
    }

    @Override
    public boolean check(Order order){
        for (CartItem cartItem : order.getCart().getItems()){
            if(cartItem.getProductType().equals(requiredTypeProduct)){
                return true;
            }
        }

        return false;
    }
}
