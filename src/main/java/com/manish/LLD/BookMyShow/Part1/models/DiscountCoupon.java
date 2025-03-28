package com.manish.LLD.BookMyShow.Part1.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DiscountCoupon {
    private String couponId;
    private String code;
    private double discountPercentage;
    private LocalDate validUntil;
    private double maxDiscount;


}
