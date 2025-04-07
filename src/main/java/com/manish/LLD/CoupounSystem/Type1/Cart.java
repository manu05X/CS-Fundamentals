package com.manish.LLD.CoupounSystem.Type1;

import java.util.List;

public class Cart {
    private String cartId;
    private List<CartItem> items;

    public Cart(String cartId, List<CartItem> items) {
        this.cartId = cartId;
        this.items = items;
    }

    public List<CartItem> getItems() {
        return items;
    }
}
