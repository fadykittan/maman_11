package com.university.question_1;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected String _name;
    protected int _totalValue;
    protected List<Card> cardList = new ArrayList<>();
    protected List<Card> ASCardList = new ArrayList<>();

    public Player(String name){
        this._name = name;
        this._totalValue = 0;
    }

    public void takeCard(Card card){
        if(card.isAS()){
            ASCardList.add(card);
        } else {
            cardList.add(card);
        }
        updateTotalValue();
    }

    protected abstract void updateTotalValue();


}
