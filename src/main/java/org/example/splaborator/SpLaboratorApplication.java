package org.example.splaborator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpLaboratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpLaboratorApplication.class, args);
        Book abc = new Book("abc");
        Author LReb = new Author("Liviu Rebreanu");
        abc.addAuthor(LReb);
        Section cap1 = new Section("Capitol 1");
        Section cap2 = new Section("Capitol 2");
        Section cap3 = new Section("Capitol 3");
        Section cap4 = new Section("Subcapitolul 1.1");
        abc.addContent(new Paragraph("Cuvant inainte: Multumesc celor..."));
        abc.addContent(cap1);
        cap1.add(new Paragraph("Primul capitol incepe"));
        cap1.add(cap4);
        cap4.add(new Paragraph("Imi place sa scriu"));
        abc.addContent(cap2);
        cap2.add(new Paragraph("Al doilea capitol capitol incepe"));
        cap2.add(cap3);
        cap3.add(new Image("Imagine capitol 3"));
        abc.print();
    }

}
