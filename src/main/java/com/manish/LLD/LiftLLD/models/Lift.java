package com.manish.LLD.LiftLLD.models;

import com.manish.LLD.LiftLLD.observer.Observer;
import java.util.ArrayList;
import java.util.List;

public class Lift {
    private int currentFloor;
    private LiftState state;
    private List<Observer> observers;

    public Lift(int startFloor) {
        this.currentFloor = startFloor;
        this.state = new StoppedState();
        this.observers = new ArrayList<>();
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentFloor);
        }
    }

    public void moveUp() {
        System.out.println("Lift moving up...");
        this.state = new MovingUpState();
        currentFloor++;
        notifyObservers();
    }

    public void moveDown() {
        System.out.println("Lift moving down...");
        this.state = new MovingDownState();
        currentFloor--;
        notifyObservers();
    }

    public void stop() {
        System.out.println("Lift stopping at floor: " + currentFloor);
        this.state = new StoppedState();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

}
