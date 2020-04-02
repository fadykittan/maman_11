package com.university.question_1;

public class ComputerPlayer extends Player {

    private final int MAX_CARDS_VALUE = 17;

    public ComputerPlayer(String name){
        super(name);
    }


//    protected void updateTotalValue() {
//
//    }

    public boolean isNeedMoreCard(){

        int totalValue = getTotalValue();

        if(totalValue >= 17) {
            return false;
        } else {
            return true;
        }

    }
}

