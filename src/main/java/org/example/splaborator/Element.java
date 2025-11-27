package org.example.splaborator;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Element() {
    }

    public void print() {}

    public void add(Element e) {
    }

    public void remove(Element e) {
    }

    public Element get(int i) {
        return null;
    }
}