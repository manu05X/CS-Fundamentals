package com.manish.LLD.FlashSale.Type1.model;

import com.manish.LLD.FlashSale.Type1.model.FlashSaleStatus;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlashSale {
    private String flashSaleId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private FlashSaleStatus status;
    private List<FlashSaleProduct> productList = new ArrayList<>();

    public FlashSale(String flashSaleId, LocalDateTime startTime, LocalDateTime endTime, FlashSaleStatus status) {
        this.flashSaleId = flashSaleId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
    }

    public String getFlashSaleId() {
        return flashSaleId;
    }

    public FlashSaleStatus getStatus() {
        return status;
    }

    public void setStatus(FlashSaleStatus status) {
        this.status = status;
    }

    public void addProduct(FlashSaleProduct product) {
        productList.add(product);
    }
}
