package org.example.splaborator;

import jakarta.persistence.Entity;

@Entity
public class Image extends Element {
    private String name;

    public Image() {

    }
    public Image(String name) {
        this.name = name;
    }
    public void print() {
        System.out.println(name);
    }
}
