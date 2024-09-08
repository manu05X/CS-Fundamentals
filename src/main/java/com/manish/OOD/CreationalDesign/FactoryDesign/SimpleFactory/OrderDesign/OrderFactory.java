package com.manish.OOD.CreationalDesign.FactoryDesign.SimpleFactory.OrderDesign;

// OrderFactory class to create instances of different Order types based on input
public class OrderFactory {
    // Static factory method to create an order based on the provided type
    public static Order createOrder(String type) {
        switch(type) {
            // If the type is "Physical", return an instance of PhysicalOrder
            case "Physical":
                return new PhysicalOrder();
            // If the type is "Digital", return an instance of DigitalOrder
            case "Digital":
                return new DigitalOrder();
            // If the type is "Service", return an instance of ServiceOrder
            case "Service":
                return new ServiceOrder();
            // If the type is not recognized, throw an exception
            default:
                throw new IllegalArgumentException("Invalid order type: " + type);
        }
    }
}
