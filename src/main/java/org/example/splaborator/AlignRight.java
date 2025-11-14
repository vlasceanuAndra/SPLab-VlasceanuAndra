package org.example.splaborator;

import javax.swing.*;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(String text){
        int width = 170;
        int padding = width - text.length();
        if (padding < 0) padding = 0;
        System.out.println(" ".repeat(padding) + text);
    }

}
