package com.university.question_1;

import javax.swing.*;
import java.util.ArrayList;

public class GameManager {
    private ComputerPlayer comPlayer;
    private HumanPlayer humPlayer;
    private DeckOfCards deck;
    private static int YES = 0;
    private static int NO = 1;
    private static int CANCEL = 2;

    public void init (){
        //create computer player
        this.comPlayer = new ComputerPlayer("The Computer");

        //create single player
       this.humPlayer = new HumanPlayer("You");

        //create deck of cards
        this.deck = new DeckOfCards();

        //random the cards
        deck.shuffle();

        //give 2 cards for each player
        Card c = deck.dealCard();
        comPlayer.takeCard(c);
        c = deck.dealCard();
        comPlayer.takeCard(c);

        c = deck.dealCard();
        humPlayer.takeCard(c);
        c = deck.dealCard();
        humPlayer.takeCard(c);
    }

    public void play(){
        //for loop
        boolean singlePlayer = true ;
        while (singlePlayer == true) {
          Card h = deck.dealCard();
          this.humPlayer.takeCard(h);
        }
        //display cards for each player
        //ask single player if need more cards
            //give one card
        //check the value for single player
        //ask computer player if need more card
            //give one card
        //check value for computer player
        //compare between the cards of two players





    }

    public void start(){
        this.init();
        this.play();

    }



    public boolean askComputerForMoreCard(){
        return comPlayer.isNeedMoreCard();
    }

    public Card giveComputerCard(){
        Card card = deck.dealCard();
        comPlayer.takeCard(card);
        return card;
    }


    public Card givePlayerCard(){
        Card card = deck.dealCard();
        humPlayer.takeCard(card);
        return card;
    }

    public Player getWinnerPlayer(){
        int playerCardsValue = humPlayer.getTotalValue();
        int computerCardsValue = comPlayer.getTotalValue();

        if(playerCardsValue > computerCardsValue && playerCardsValue <= 21) {
            return humPlayer;
        }

        if(computerCardsValue > playerCardsValue && computerCardsValue <= 21){
            return comPlayer;
        }

        return null;
    }

    public ArrayList<Card> getHumanPlayerCards(){
        return humPlayer.getAllCards();
    }

    public ArrayList<Card> getComputerCards(){
        return comPlayer.getAllCards();
    }

}
