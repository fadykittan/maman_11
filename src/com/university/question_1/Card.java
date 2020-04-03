package com.university.question_1;

import java.awt.*;

public class Card {

    private String displayName;
    private int value;
    private boolean isAS;
    private final static int AS_VALUE_1 = 1;
    private final static int AS_VALUE_2 = 11;

    public Card(String displayName, int value, boolean isAS) {
        this.displayName = displayName;
        this.value = value;
        this.isAS = isAS;
    }

    public String getDisplayName() {
        return new String(displayName);
    }


    public int getValue() {
        if (this.isAS) {
            return 0;
        }
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

    public void draw(Graphics g, Dimension d, Point p) {
        g.setColor(Color.BLUE);

        g.fillRect((int) p.getX(), (int) p.getY(),
                (int) d.getWidth(), (int) d.getHeight());
        g.setFont(new Font("arial", Font.BOLD, 20));

        g.setColor(Color.WHITE);
        g.drawString("" + (isAS ? "A" : value), (int) (p.getX() + d.getWidth() / 2 - 5),
                (int) (p.getY() + d.getWidth() / 2 + 5));

    }
}

