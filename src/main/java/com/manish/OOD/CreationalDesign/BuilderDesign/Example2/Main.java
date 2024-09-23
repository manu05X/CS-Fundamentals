package com.manish.OOD.CreationalDesign.BuilderDesign.Example2;

public class Main {
    public static void main(String[] args) {
        // Create some products for the order.
        Product product1 = new Product("Laptop", 1500.0);
        Product product2 = new Product("Phone", 800.0);

        // Create billing and shipping addresses for the order.
        Address billingAddress = new Address("123 Main St", "New York", "NY", "10001");
        Address shippingAddress = new Address("456 Elm St", "Los Angeles", "CA", "90001");

        // Use the OrderBuilder to create an order by adding products and setting other details.
        Order order = new Order.OrderBuilder()
                .addProduct(product1)                          // Add first product
                .addProduct(product2)                          // Add second product
                .setBillingAddress(billingAddress)             // Set billing address
                .setShippingAddress(shippingAddress)           // Set shipping address
                .setDiscount(10.0)                             // Set discount
                .setTax(5.0)                                   // Set tax
                .build();                                      // Build the final order

        // Print the order details to the console.
        System.out.println("Order created with products: " + order.getProducts());
        System.out.println("Billing Address: " + order.getBillingAddress());
        System.out.println("Shipping Address: " + order.getShippingAddress());
        System.out.println("Discount: " + order.getDiscount());
        System.out.println("Tax: " + order.getTax());
    }
}

/*

In this example, we define an Employee class with four final fields: firstName, lastName, age, and department. We also define a Builder class with the same four fields. The Builder class has methods for setting the age and department fields, and a build() method that creates a new Employee object.
This creates a new Employee object with the firstName "John", lastName "Doe", age 30, and department "IT". Once the Employee object is created, it can't be modified, because all of the fields are final.

 Key Components:
Product Class:
    Represents individual products with a name and price that are added to an order.

Address Class:
    Represents a customer's billing or shipping address with attributes like street, city, state, and zip code.

Order Class (Product):
    The complex object being constructed with fields for products, addresses, discount, and tax. It is immutable after construction since the constructor is private and only accessible via the OrderBuilder.

OrderBuilder Class (Builder):
    This class provides methods to add products, set addresses, and apply discounts/taxes. The build() method returns the final Order object.

Main Class (Driver):
    Demonstrates how to use the OrderBuilder to create an order by adding products, setting addresses, and applying discounts. Finally, it prints the order details.

Director (Optional):
    In this example, the director class is not explicitly used, but you could introduce a SalesDirector or similar class to manage the building of different types of orders.

 */