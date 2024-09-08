package com.manish.OOD.StructuralDesign.AdapterPattern.PaymentGateway;

// This is the adapter for the Stripe payment gateway
public class StripeAdapter implements PaymentGateway {
    private StripeAPI stripeAPI;

    public StripeAdapter(StripeAPI stripeAPI) {
        this.stripeAPI = stripeAPI;
    }

    public void processPayment(double amount) {
        stripeAPI.charge(amount);
    }
}
