package org.example.splaborator;

import java.util.ArrayList;

public class Section extends Element {
    private String name;
    private ArrayList<Element> elements = new ArrayList<>();

    public Section(String name) {
        this.name = name;
    }


    @Override
    public void add(Element e) {
        elements.add(e);
    }
    @Override
    public void remove(Element e) {
        elements.remove(e);
    }

    @Override
    public Element get(int index) {
        return elements.get(index);
    }

    @Override
    public void print() {
        System.out.println("Section: " + name);
        for (Element e : elements) {
            e.print();
        }
    }

}
