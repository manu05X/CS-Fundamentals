package com.manish.OOD.BehavioralDesign.Observer.StockMarket;

import java.util.ArrayList;
import java.util.List;

public class Stock {
    private double value;
    private List<ValueChangeListener> valueChangeListeners = new ArrayList<>();

    public void addValueChangeListener(ValueChangeListener listener) {
        valueChangeListeners.add(listener);
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
        for (ValueChangeListener listener : valueChangeListeners) {
            listener.onValueChange(value);
        }
    }
}
