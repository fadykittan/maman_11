package com.university.question_1;

public class HumanPlayer extends Player {

    public HumanPlayer(String name){
        super(name);
    }


    protected void updateTotalValue() {
        for (Card card : cardList){
            _totalValue += card.getValue();
        }

        for (Card card : ASCardList){
            _totalValue += card.getMinValue();
        }
    }
}
