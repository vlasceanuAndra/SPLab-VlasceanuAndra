package org.example.splaborator;

public class AlignCenter implements AlignStrategy {
    @Override
    public void render(String text){
        int width = 170;
        int padding = (width - text.length())/2;
        if (padding < 0) padding = 0;
        System.out.println(" ".repeat(padding) + text);
    }
}
