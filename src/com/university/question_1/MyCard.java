package com.university.question_1;

public class MyCard {

    private String displayName;
    private int value;
    private boolean isAS;
    private final static int AS_VALUE_1 = 1;
    private final static int AS_VALUE_2 = 11;

    public MyCard(String displayName, int value, boolean isAS) {
        this.displayName = displayName;
        this.value = value;
        this.isAS = isAS;
    }

    public String getDisplayName() {
        return new String(displayName);
    }

//    public int[] getValue() {
//        int[] valueArray;
//        if (this.isAS) {
//            valueArray = new int[2];
//            valueArray[0] = 1;
//            valueArray[1] = 11;
//        } else {
//            valueArray = new int[1];
//            valueArray[0] = this.value;
//        }
//        return valueArray;
//    }


    public int getValue() {
        return value;
    }

    public boolean isAS() {
        return isAS;
    }

    public int getMaxValue() {
        if (this.isAS) {
            return AS_VALUE_2;
        } else {
            return this.value;
        }
    }

    public int getMinValue() {
        if (this.isAS) {
            return AS_VALUE_1;
        } else {
            return this.value;
        }
    }

}
