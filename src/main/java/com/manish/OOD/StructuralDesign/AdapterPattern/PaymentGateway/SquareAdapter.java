package com.manish.OOD.StructuralDesign.AdapterPattern.PaymentGateway;

// This is the adapter for the Square payment gateway
public class SquareAdapter implements PaymentGateway {
    private SquareAPI squareAPI;

    public SquareAdapter(SquareAPI squareAPI) {
        this.squareAPI = squareAPI;
    }

    public void processPayment(double amount) {
        squareAPI.processPayment(amount);
    }
}
