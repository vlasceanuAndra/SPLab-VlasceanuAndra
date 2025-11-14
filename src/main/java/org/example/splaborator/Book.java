package org.example.splaborator;
import org.example.splaborator.Author;
import java.util.*;


public class Book {
    private String title;
    private Author author;
    private ArrayList<Element> elements =  new ArrayList<>();
    public Book(String title) {
        this.title = title;
    }
    public void addAuthor(Author author) {
        this.author = author;
    }
    public void addContent(Element element) {
        elements.add(element);
    }
    public String getTitle() {
        return title;
    }
    public Author getAuthor() {
        return author;
    }

    public void print() {
        System.out.println("Title: " + title);
        author.Print();
        for (Element element : elements) {
            element.print();
        }
    }
}
