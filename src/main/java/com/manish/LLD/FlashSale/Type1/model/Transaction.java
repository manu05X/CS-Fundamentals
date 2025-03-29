package com.manish.LLD.FlashSale.Type1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transaction {
    private int id;
    private Order order;

    public Transaction(int id, Order order) {
        this.id = id;
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }
}
