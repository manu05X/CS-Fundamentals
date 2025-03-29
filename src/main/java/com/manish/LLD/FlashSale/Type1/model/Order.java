package com.manish.LLD.FlashSale.Type1.model;

import com.manish.LLD.FlashSale.Type1.model.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private String orderId;
    private String userId;
    private String flashSaleId;
    private LocalDateTime orderTime;
    private OrderStatus status;
    private BigDecimal totalAmount;
    private List<OrderItem> items;

    public Order(String orderId, String userId, String flashSaleId, LocalDateTime orderTime, OrderStatus status, BigDecimal totalAmount) {
        this.orderId = orderId;
        this.userId = userId;
        this.flashSaleId = flashSaleId;
        this.orderTime = orderTime;
        this.status = status;
        this.totalAmount = totalAmount;
    }

    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
