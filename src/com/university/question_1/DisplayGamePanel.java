package com.university.question_1;

import javax.swing.*;
import java.awt.*;

public class DisplayGamePanel extends JPanel {


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        CardPanel card = new CardPanel();
        this.add(card);
        card.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fill3DRect( (int) (0.1 * width), (int) (0.7 * height), 70, 100, true);


    }



}
