package org.example.splaborator;

import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Entity
public class Paragraph extends Element {
    private String text;
    @Transient
    private AlignStrategy alignStrategy;
    public Paragraph() {

    }
    public Paragraph(String text) {
        this.text = text;
    }
    public void setAlignStrategy(AlignStrategy alignStrategy) {

        this.alignStrategy = alignStrategy;
    }
    @Override
    public void print(){
        if(alignStrategy != null){
            alignStrategy.render(text);
        }
        else
        System.out.println("Paragraph: " + text);
    }
    public String getText() {
        return text;
    }



}
