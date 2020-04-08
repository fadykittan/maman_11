package com.university.question_1;

import javax.swing.*;
import java.awt.*;

public class Game {

    private static int YES = 0;
    private static int NO = 1;
    private static int CANCEL = 2;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Slides");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        GameGUI gui = new GameGUI();
        frame.add(gui);
        frame.setVisible(true);

        do {
            gui.resetGame();
            gui.prepareGame();

            int answer = gui.isPlayAnotherRound();
            while (answer == YES) {

                boolean ask = gui.askPlayerForMoreCard();
                if (ask) {
                    gui.givePlayerCard();
                }

                ask = gui.askComputerForMoreCard();
                if (ask) {
                    gui.giveComputerCard();
                }

                answer = gui.isPlayAnotherRound();

            }


            if (answer == NO) {
                gui.displayTheWinnerName();
            }

        } while (JOptionPane.showConfirmDialog(null, "Do you want to play again?") == YES);

    }

}
