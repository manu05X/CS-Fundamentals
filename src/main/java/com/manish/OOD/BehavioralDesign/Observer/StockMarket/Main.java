package com.manish.OOD.BehavioralDesign.Observer.StockMarket;

/* To complete the code, add the missing closing bracket and create an instance of the Stock class with some initial value, and add the GraphUpdater and EmailSender as listeners to the Stock object.
 */
public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock();
        stock.setValue(100.0); // Set an initial value

        GraphUpdater graphUpdater = new GraphUpdater();
        EmailSender emailSender = new EmailSender();

        stock.addValueChangeListener(graphUpdater);
        stock.addValueChangeListener(emailSender);

        // Update the value of the stock
        stock.setValue(110.0);
    }
}
