package org.example.splaborator;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();
    @OneToMany(targetEntity = Element.class, cascade = CascadeType.ALL)
    private List<Element> elements = new ArrayList<>();
    public Book() {
    }

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void addContent(Element element) {
        elements.add(element);
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public Long getId() {
        return id;
    }

    public void print() {
        System.out.println("Title: " + title);
        for(Author a : authors) {
            a.Print();
        }
        for (Element element : elements) {
            element.print();
        }
    }
}