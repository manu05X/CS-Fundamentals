package com.manish.LLD.BookMyShow.Part1.models;

import com.manish.LLD.BookMyShow.Part1.models.enums.PaymentMethod;
import com.manish.LLD.BookMyShow.Part1.models.enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Payment {
    private String paymentId;
    private Booking booking;
    //private double amount; // amount will come from booking so amount is not required field in Payment
    private PaymentMethod method;
    private PaymentStatus status;
    private LocalDateTime transactionTime;

    public Payment(String paymentId, Booking booking, PaymentMethod method, PaymentStatus paymentStatus, LocalDateTime transactionTime) {
        this.paymentId = paymentId;
        this.booking = booking;
        this.method = method;
        this.status = paymentStatus;
        this.transactionTime = transactionTime;
    }


    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
//
//    public double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
}
