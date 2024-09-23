package com.manish.OOD.StructuralDesign.AdapterPattern.PaymentGateway;

// com.manish.OOD.CreationalDesign.BuilderDesign.Pizza.Main class to demonstrate the Adapter Pattern
public class Main {
    public static void main(String[] args) {
        // Using PayPal through its adapter
        PayPalAPI paypalAPI = new PayPalAPI();
        PaymentGateway paypalAdapter = new PayPalAdapter(paypalAPI);
        paypalAdapter.processPayment(100.0);

        // Using Stripe through its adapter
        StripeAPI stripeAPI = new StripeAPI();
        PaymentGateway stripeAdapter = new StripeAdapter(stripeAPI);
        stripeAdapter.processPayment(200.0);

        // Using Square through its adapter
        SquareAPI squareAPI = new SquareAPI();
        PaymentGateway squareAdapter = new SquareAdapter(squareAPI);
        squareAdapter.processPayment(300.0);
    }
}

