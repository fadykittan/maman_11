package com.university.question_1;

import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {

    private static int CARD_HEIGHT = 100;
    private static int CARD_WIDTH = 70;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();

        this.setBackground(Color.GRAY);
        this.setSize(CARD_WIDTH, CARD_HEIGHT);
        g.setColor(Color.WHITE);
        g.drawString("ACE", 40,40);
//        g.fill3DRect( (int) (0.1 * width), (int) (0.7 * height), 70, 100, true);


    }

}
