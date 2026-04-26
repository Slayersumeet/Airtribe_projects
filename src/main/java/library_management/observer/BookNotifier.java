package library_management.observer;

import java.util.*;

public class BookNotifier {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(String msg) {
        for (Observer o : observers) {
            o.update(msg);
        }
    }
}