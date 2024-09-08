package com.manish.OOD.StructuralDesign.AdapterPattern.PaymentGateway;

// Stripe API (This is the third-party API that the adapter will wrap)
class StripeAPI {
    public void charge(double amount) {
        System.out.println("Charging $" + amount + " via Stripe.");
    }
}
