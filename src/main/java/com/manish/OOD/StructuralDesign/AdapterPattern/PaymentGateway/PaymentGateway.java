package com.manish.OOD.StructuralDesign.AdapterPattern.PaymentGateway;

// This is the interface that defines the common payment gateway interface
public interface PaymentGateway {
    public void processPayment(double amount);
}
