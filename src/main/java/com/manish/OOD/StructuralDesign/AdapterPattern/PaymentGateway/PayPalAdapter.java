package com.manish.OOD.StructuralDesign.AdapterPattern.PaymentGateway;

// This is the adapter for the PayPal payment gateway
public class PayPalAdapter implements PaymentGateway {
    private PayPalAPI paypalAPI;

    public PayPalAdapter(PayPalAPI paypalAPI) {
        this.paypalAPI = paypalAPI;
    }

    public void processPayment(double amount) {
        paypalAPI.makePayment(amount);
    }
}
