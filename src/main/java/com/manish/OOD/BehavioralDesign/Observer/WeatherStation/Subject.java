package com.manish.OOD.BehavioralDesign.Observer.WeatherStation;

interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
