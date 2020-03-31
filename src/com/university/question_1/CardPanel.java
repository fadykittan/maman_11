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
        JLabel label = new JLabel("ACE");
//        this.setLayout(new FlowLayout());
        g.setColor(Color.WHITE);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Aril", Font.BOLD, 24));
       label.setVisible(true);
        this.add(label);

//        g.drawString("ACE", 10,50);
//        g.fill3DRect( (int) (0.1 * width), (int) (0.7 * height), 70, 100, true);


    }

}
