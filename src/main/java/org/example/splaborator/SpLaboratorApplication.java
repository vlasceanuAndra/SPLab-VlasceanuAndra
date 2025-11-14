package org.example.splaborator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpLaboratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpLaboratorApplication.class, args);
        System.out.println("Print fara align:");
        Book abc = new Book("abc");
        Author LReb = new Author("Liviu Rebreanu");
        abc.addAuthor(LReb);
        Section cap1 = new Section("Capitol 1");
        Section cap2 = new Section("Capitol 2");
        Section cap3 = new Section("Capitol 3");
        Section cap4 = new Section("Subcapitolul 1.1");
        Paragraph p1 = new Paragraph("Cuvant inainte: Multumesc celor...");
        abc.addContent(p1);
        abc.addContent(cap1);
        Paragraph p2 = new Paragraph("Primul capitol incepe");
        cap1.add(p2);
        cap1.add(cap4);
        Paragraph p3 = new Paragraph("Imi place sa scriu");
        cap4.add(p3);
        abc.addContent(cap2);
        Paragraph p4 = new Paragraph("Al doilea capitol capitol incepe");
        cap2.add(p4);
        cap2.add(cap3);
        cap3.add(new Image("Imagine capitol 3"));
        abc.print();

        System.out.println("Print cu align:");
        System.out.println(" ");
        p1.setAlignStrategy(new AlignLeft());
        p2.setAlignStrategy(new AlignRight());
        p3.setAlignStrategy(new AlignCenter());
        p4.setAlignStrategy(new AlignRight());
        abc.print();

    }

}
