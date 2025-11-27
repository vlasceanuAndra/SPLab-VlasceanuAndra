package org.example.observer;
import org.example.splaborator.Book;
import java.util.ArrayList;
import java.util.List;

public class Subject {
    protected final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(Book book) {
        for (var observer : observers) {
            observer.update(book);
        }
    }
}