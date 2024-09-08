package com.manish.OOD.CreationalDesign.BuilderDesign.Example2;

public class Main {
    public static void main(String[] args) {
        // Create some products
        Product product1 = new Product("Laptop", 1500.0);
        Product product2 = new Product("Phone", 800.0);

        // Create addresses
        Address billingAddress = new Address("123 Main St", "New York", "NY", "10001");
        Address shippingAddress = new Address("456 Elm St", "Los Angeles", "CA", "90001");

        // Use the OrderBuilder to create an order
        Order order = new Order.OrderBuilder()
                .addProduct(product1)
                .addProduct(product2)
                .setBillingAddress(billingAddress)
                .setShippingAddress(shippingAddress)
                .setDiscount(10.0)
                .setTax(5.0)
                .build();

        // Print the order details
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
 */
