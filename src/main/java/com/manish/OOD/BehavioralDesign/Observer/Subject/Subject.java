package com.manish.OOD.BehavioralDesign.Observer.Subject;

interface Subject {
    void attach(Observer o);

    void detach(Observer o);

    void notifyObservers();
}
