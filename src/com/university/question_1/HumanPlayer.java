package com.university.question_1;

public class HumanPlayer extends Player {

    public HumanPlayer(String name){
        super(name);
    }


    protected void updateTotalValue() {
        for (MyCard myCard : myCardList){
            _totalValue += myCard.getValue();
        }

        for (MyCard myCard : ASMyCardList){
            _totalValue += myCard.getMinValue();
        }
    }
}
