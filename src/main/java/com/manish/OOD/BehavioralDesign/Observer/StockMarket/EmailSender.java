package com.manish.OOD.BehavioralDesign.Observer.StockMarket;

public class EmailSender implements ValueChangeListener {
    public void onValueChange(double newValue) {
        System.out.println("Sending email with new value: " + newValue);
    }
}
