package com.university.question_1;

import javax.swing.*;
import java.awt.*;

public class GameGUI extends JPanel {


    private GameManager gameManager;
    private boolean win;
    private final int MARGIN = 20;

    public GameGUI(GameManager gameManager) {
        this.gameManager = gameManager;
  //      win = game.gameOver();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int w = getWidth()  - 2 * MARGIN;
        int h = getHeight() -  2 * MARGIN;

        gameManager.drawBoard(g, new Dimension(MARGIN, MARGIN, w, h));

        if(win) {
            g.setColor(Color.GREEN);
            g.drawString("Well Done :)", getWidth() / 2 - 50, 30);
        }
    }

//    public void makeMove(int row, int col) {
//        game.move(row, col);
//        repaint();
//    }

    public void giveEachPlayerCard(){

        //todo write code here
    }

    public void prepareGame(){

        //todo write code here
        //give each player 2 cards
    }


    public void displayTheWinnerName(){
        //todo write code here



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
