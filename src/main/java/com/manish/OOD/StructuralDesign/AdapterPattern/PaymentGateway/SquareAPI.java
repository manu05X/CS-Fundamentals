package com.manish.OOD.StructuralDesign.AdapterPattern.PaymentGateway;

// Square API (This is the third-party API that the adapter will wrap)
class SquareAPI {
    public void processPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via Square.");
    }
}
