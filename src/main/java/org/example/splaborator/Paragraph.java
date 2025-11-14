package org.example.splaborator;

public class Paragraph extends Element {
    private String text;
    private AlignStrategy alignStrategy;
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



}
