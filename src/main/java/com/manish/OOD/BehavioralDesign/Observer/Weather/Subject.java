package com.manish.OOD.BehavioralDesign.Observer.Weather;

// Subject Interface
interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
