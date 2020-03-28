package com.university.question_1;

import javax.swing.*;

public class DisplayGame {

    private static int YES = 0;
    private static int NO = 1;
    private static int CANCEL = 2;

    public static void main(String[] args) {

        JFrame game = new JFrame();
        DisplayGamePanel displayGamePanel = new DisplayGamePanel();
//        JPanel j = new JPanel();
        game.add(displayGamePanel);
        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.setSize(500 , 500);
        game.setVisible(true);
        int x = JOptionPane.showConfirmDialog(game, "Do you want to play again?");
        System.out.println(x);

    }

}
