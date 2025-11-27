package org.example.observer;
import org.example.splaborator.Book;
import org.springframework.stereotype.Component;

@Component
public class AllBooksSubject extends Subject {
    public void add(Book book) {
        System.out.println("--- SUBJECT A PRIMIT CARTEA, NOTIFIC " + observers.size() + " OBSERVATORI ---");
        notifyObservers(book);
    }
}