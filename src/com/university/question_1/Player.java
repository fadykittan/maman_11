package com.university.question_1;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    protected String _name;
    protected int _totalValue;
    protected List<MyCard> myCardList = new ArrayList<>();
    protected List<MyCard> ASMyCardList = new ArrayList<>();

    public Player(String name){
        this._name = name;
        this._totalValue = 0;
    }

    public void takeCard(MyCard myCard){
        if(myCard.isAS()){
            ASMyCardList.add(myCard);
        } else {
            myCardList.add(myCard);
        }
        updateTotalValue();
    }

    protected abstract void updateTotalValue();

}
