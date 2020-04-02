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
        gui.prepareGame();

        int answer = gui.isPlayAnotherRound();
        while(answer == YES) {

            System.out.println("=============== NEW ROUND ===============");
           boolean ask = gui.askPlayerForMoreCard();
           if(ask){
               gui.givePlayerCard();
           }

           ask = gui.askComputerForMoreCard();
           if(ask) {
               gui.giveComputerCard();
           }

            answer = gui.isPlayAnotherRound();

        }



        if(answer == NO){
            gui.displayTheWinnerName();
        }



//        JFrame game = new JFrame();
//       DisplayGamePanel displayGamePanel = new DisplayGamePanel();
//       game.add(displayGamePanel);
//        CardPanel card = new CardPanel();
//      card.setLocation((int) (0.1 * width), (int) (0.7 * height));
//        card.setAlignmentX(Component.CENTER_ALIGNMENT);
//        game.add(card);
//        game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        game.setSize(1000 , 1000);
//        game.setVisible(true);
//      int x = JOptionPane.showConfirmDialog(game, "Do you want to play again?");
//       System.out.println(x);


    }

}
