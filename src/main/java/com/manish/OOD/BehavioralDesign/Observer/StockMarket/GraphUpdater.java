package com.manish.OOD.BehavioralDesign.Observer.StockMarket;

public class GraphUpdater implements ValueChangeListener {
    public void onValueChange(double newValue) {
        System.out.println("Updating graph with new value: " + newValue);
    }
}
