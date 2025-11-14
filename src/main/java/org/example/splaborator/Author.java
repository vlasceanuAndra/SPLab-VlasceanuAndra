package org.example.splaborator;

public class Author {
    public String name;


    public Author(String name) {
        this.name = name;

    }
    public String getName() {
        return name;
    }
    public void Print() {
        System.out.println("Autor: " + name );
    }
}
