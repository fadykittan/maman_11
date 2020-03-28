package com.university.question_1;

public class GameManager {
    private ComputerPlayer comPlayer;
    private HumanPlayer humPlayer;
    private DeckOfCards deck;

    public void init (){
        //create computer player
        this.comPlayer = new ComputerPlayer("Dizel");

        //create single player
       this.humPlayer = new HumanPlayer("Awni");

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


}
