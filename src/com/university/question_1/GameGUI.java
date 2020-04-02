package com.university.question_1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameGUI extends JPanel {


    private static int YES = 0;
    private static int NO = 1;
    private static int CANCEL = 2;

    private GameManager gameManager;
    private boolean win;
    private final int MARGIN = 10;
    private final int CARD_SIZE = 50;
    private final Point COMPUTER_FIRST_CARD_POSITION = new Point(10,50);
    private final Point PLAYER_FIRST_CARD_POSITION = new Point(10,150);


    int lastPlayerAnswer = YES;



    public GameGUI() {
        this.gameManager = new GameManager();
  //      win = game.gameOver();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ArrayList<Card> playerCards = gameManager.getHumanPlayerCards();

        draw(g, new Dimension(CARD_SIZE, CARD_SIZE), new Point(PLAYER_FIRST_CARD_POSITION), playerCards);

        ArrayList<Card> computerCards = gameManager.getComputerCards();

        draw(g, new Dimension(CARD_SIZE, CARD_SIZE), new Point(COMPUTER_FIRST_CARD_POSITION), computerCards);

    }

//    public void makeMove(int row, int col) {
//        game.move(row, col);
//        repaint();
//    }

    public void prepareGame(){

        //give each player 2 cards
        gameManager.init();
    }


    public void displayTheWinnerName(){
        Player player = gameManager.getWinnerPlayer();

        String name;
        if(player == null){
            name = "No Winner";
        } else {
            name = player.getName();
            name = "the winner is "  + name;

        }
        JOptionPane.showMessageDialog(null, name);
    }

    public int isPlayAnotherRound(){
        boolean computerAnswer = askComputerForMoreCard();
        if(lastPlayerAnswer == YES || computerAnswer){
            return YES;
        }
        return lastPlayerAnswer;

    }

    public boolean askPlayerForMoreCard() {
        if(lastPlayerAnswer == YES) {
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

    public void givePlayerCard(){
        gameManager.givePlayerCard();
        repaint();
    }

    public boolean askComputerForMoreCard(){
        return gameManager.askComputerForMoreCard();
    }

    public void giveComputerCard(){
        gameManager.giveComputerCard();
    }

    public void draw(Graphics g, Dimension d, Point p, ArrayList<Card> playercards) {

        for(Card c : playercards){
            c.draw(g, d, p);
            p.x = p.x + CARD_SIZE + MARGIN;
        }

//        int cellWidth = d.getWidth() / SIZE;
//
//        int x, y;
//        x = (int)p.getX();
//        y = (int)p.getY();
//
//        for(int i = 0; i < board.length; i++, y += cellWidth)
//        {
//            x = (int)p.getX();
//            for(int j = 0; j < board.length; j++, x += cellWidth)
//                board[i][j].draw(g, new Dimension(x, y, cellWidth, cellWidth));
//        }
    }


//    public void paintComponent(Graphics g){
//        super.paintComponent(g);
//        int width = getWidth();
//        int height = getHeight();
//        CardPanel card = new CardPanel();
//        card.setLocation((int) (0.1 * width), (int) (0.7 * height));
//        card.setAlignmentX(Component.CENTER_ALIGNMENT);
//        this.add(card);
//       card.paintComponent(g);
//      g.setColor(Color.GRAY);
//      g.fill3DRect( (int) (0.1 * width), (int) (0.7 * height), 70, 100, true);


   // }



}
