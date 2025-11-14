package org.example.splaborator;

public class Image extends Element {
    private String name;

    public Image(String name) {
        this.name = name;
    }
    public void print() {
        System.out.println(name);
    }
}
