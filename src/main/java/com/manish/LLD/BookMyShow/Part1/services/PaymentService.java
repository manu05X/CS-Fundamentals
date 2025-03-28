package com.manish.LLD.BookMyShow.Part1.services;

import com.manish.LLD.BookMyShow.Part1.models.Booking;
import com.manish.LLD.BookMyShow.Part1.models.Payment;
import com.manish.LLD.BookMyShow.Part1.models.enums.PaymentMethod;
import com.manish.LLD.BookMyShow.Part1.models.enums.PaymentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

/*
public class PaymentService {
    public boolean processPayment(Booking booking, PaymentMethod method) {
        // Implementation
        return true;
    }
}

 */

public class PaymentService {
    public boolean processPayment(Booking booking, PaymentMethod method) {
        if (booking == null || method == null || booking.calculateTotalAmount() <= 0) {
            System.out.println("Invalid booking details. Payment failed.");
            return false;
        }

        // Simulate payment processing based on method
        boolean paymentSuccess = initiateTransaction(method, booking.calculateTotalAmount());

        // Create payment record
        Payment payment = new Payment(
                UUID.randomUUID().toString(),
                booking,
                method,
                paymentSuccess ? PaymentStatus.COMPLETED : PaymentStatus.FAILED,
                LocalDateTime.now()
        );

        booking.setPayment(payment);
        return paymentSuccess;
    }

    private boolean initiateTransaction(PaymentMethod method, double amount) {
        System.out.println("Processing payment of ₹" + amount + " via " + method);

        // Simulating different success rates for each payment method
        switch (method) {
            case CREDIT_CARD:
            case DEBIT_CARD:
            case UPI:
                return true;  // Assume success for card/UPI
            case NET_BANKING:
                return Math.random() > 0.2;  // 80% success rate
            case CASH:
                return Math.random() > 0.1;  // 90% success rate
            default:
                return false; // Unknown method, fail transaction
        }
    }
}