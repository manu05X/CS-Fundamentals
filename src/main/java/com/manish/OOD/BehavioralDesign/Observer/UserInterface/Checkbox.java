package com.manish.OOD.BehavioralDesign.Observer.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class Checkbox {
    private boolean checked;
    private List<ChangeListener> changeListeners = new ArrayList<>();

    public void addChangeListener(ChangeListener listener) {
        changeListeners.add(listener);
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
        for (ChangeListener listener : changeListeners) {
            listener.onChange(checked);
        }
    }
}
