package com.manish.OOD.StructuralDesign.AdapterPattern.PaymentGateway;

// PayPal API (This is the third-party API that the adapter will wrap)
class PayPalAPI {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via PayPal.");
    }
}
