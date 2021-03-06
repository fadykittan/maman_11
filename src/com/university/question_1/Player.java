package com.university.question_1;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {

    protected String _name;
    protected ArrayList<Card> cardList = new ArrayList<>();
    protected ArrayList<Card> ASCardList = new ArrayList<>();

    public Player(String name) {
        this._name = name;
    }

    public void takeCard(Card card) {
        if (card.isAS()) {
            ASCardList.add(card);
        } else {
            cardList.add(card);
        }
    }

    public String getName() {
        return _name;
    }

    public int getTotalValue() {
        int totalValue = 0;

        for (Card c : cardList) {
            totalValue += c.getValue();
        }

        for (Card c : ASCardList) {
            if (totalValue + c.getMaxValue() <= 21) {
                totalValue += c.getMaxValue();
            } else {
                totalValue += c.getMinValue();
            }
        }

        return totalValue;
    }


    public ArrayList<Card> getAllCards() {
        ArrayList<Card> allCards = new ArrayList<>();
        allCards.addAll(cardList);
        allCards.addAll(ASCardList);

        return allCards;
    }

}
