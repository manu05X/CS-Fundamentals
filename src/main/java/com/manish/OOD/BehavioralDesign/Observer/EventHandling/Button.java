package com.manish.OOD.BehavioralDesign.Observer.EventHandling;

import java.util.ArrayList;
import java.util.List;

public class Button {
    private List<ClickListener> clickListeners = new ArrayList<>();

    public void addClickListener(ClickListener listener) {
        clickListeners.add(listener);
    }

    public void click() {
        for (ClickListener listener : clickListeners) {
            listener.onClick();
        }
    }
}
