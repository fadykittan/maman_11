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

    public void init() {
        //create computer player
        this.comPlayer = new ComputerPlayer("The Computer :(");

        //create single player
        this.humPlayer = new HumanPlayer("YOU :D");

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


    public boolean askComputerForMoreCard() {
        return comPlayer.isNeedMoreCard();
    }

    public Card giveComputerCard() {
        Card card = deck.dealCard();
        comPlayer.takeCard(card);
        return card;
    }


    public Card givePlayerCard() {
        Card card = deck.dealCard();
        humPlayer.takeCard(card);
        return card;
    }

    public Player getWinnerPlayer() {
        int playerCardsValue = humPlayer.getTotalValue();
        int computerCardsValue = comPlayer.getTotalValue();

        if (playerCardsValue > computerCardsValue && playerCardsValue <= 21) {
            return humPlayer;
        }

        if (computerCardsValue > playerCardsValue && computerCardsValue <= 21) {
            return comPlayer;
        }

        if (playerCardsValue > 21 && computerCardsValue <= 21) {
            return comPlayer;
        }

        if (computerCardsValue > 21 && playerCardsValue <= 21) {
            return humPlayer;
        }

        return null;
    }

    public ArrayList<Card> getHumanPlayerCards() {
        return humPlayer.getAllCards();
    }

    public ArrayList<Card> getComputerCards() {
        return comPlayer.getAllCards();
    }

    public int getPlayerTotalValue() {
        return humPlayer.getTotalValue();
    }

    public int getComputerTotalValue() {
        return comPlayer.getTotalValue();
    }

}
