package com.university.question_1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameGUI extends JPanel {


    private static int YES = 0;
    private static int NO = 1;
    private static int CANCEL = 2;

    private GameManager gameManager;
    private final int MARGIN = 10;
    private final int CARD_SIZE = 50;
    private final Point COMPUTER_FIRST_CARD_POSITION = new Point(10, 75);
    private final Point PLAYER_FIRST_CARD_POSITION = new Point(10, 275);


    int lastPlayerAnswer = YES;


    public GameGUI() {
        this.gameManager = new GameManager();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<Card> playerCards = gameManager.getHumanPlayerCards();
        ArrayList<Card> computerCards = gameManager.getComputerCards();

        g.setFont(new Font("arial", Font.BOLD, 20));
        g.setColor(Color.BLACK);
        g.drawString("Computer's Cards:", 10, 50);

        draw(g, new Dimension(CARD_SIZE, CARD_SIZE), new Point(COMPUTER_FIRST_CARD_POSITION), computerCards);

        g.setFont(new Font("arial", Font.BOLD, 20));
        g.setColor(Color.BLACK);
        g.drawString("Your Cards:", 10, 250);

        draw(g, new Dimension(CARD_SIZE, CARD_SIZE), new Point(PLAYER_FIRST_CARD_POSITION), playerCards);

    }

    public void prepareGame() {

        //give each player 2 cards
        gameManager.init();
    }


    public void displayTheWinnerName() {
        Player player = gameManager.getWinnerPlayer();

        String name;
        if (player == null) {
            name = "No Winner";
        } else {
            name = player.getName();
            name = "the winner is " + name;

        }

        String message = "\nComputer total cards value: " + gameManager.getComputerTotalValue() + "\n";
        message = message + "Your total cards value: " + gameManager.getPlayerTotalValue() + "\n";
        message = message + "\n" + name;

        JOptionPane.showMessageDialog(null, message);
    }

    public int isPlayAnotherRound() {
        boolean computerAnswer = askComputerForMoreCard();
        if (lastPlayerAnswer == YES || computerAnswer) {
            return YES;
        }
        return lastPlayerAnswer;

    }

    public boolean askPlayerForMoreCard() {
        if (lastPlayerAnswer == YES) {
            int ans = JOptionPane.showConfirmDialog(null, "Do you want more cards?");

            lastPlayerAnswer = ans;

            if (ans == YES) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void givePlayerCard() {
        gameManager.givePlayerCard();
        repaint();
    }

    public boolean askComputerForMoreCard() {
        return gameManager.askComputerForMoreCard();
    }

    public void giveComputerCard() {
        gameManager.giveComputerCard();
        repaint();
    }

    public void draw(Graphics g, Dimension d, Point p, ArrayList<Card> playercards) {

        for (Card c : playercards) {
            c.draw(g, d, p);
            p.x = p.x + CARD_SIZE + MARGIN;
        }

    }


    public void resetGame() {
        gameManager.init();
        lastPlayerAnswer = YES;
        repaint();
    }

}
