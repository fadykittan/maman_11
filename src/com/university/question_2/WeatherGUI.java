package com.university.question_2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WeatherGUI extends JPanel {


    private ArrayList<Integer> chartData = new ArrayList<>();
    private final int MARGIN = 50;
    private final int BAR_WIDTH = 30;
    private final int SPACE_BETWEEN_BARS = 20;
    private final int LINE_LENGTH = 5;
    private final int Y_UNIT = 5;
    private final int Y_MAX_VALUE = 60;
    private Point pointZero;
    private int maxBarHeight;
    private int minBarHeight;
    private double scaleFactor;
    private int YUnitSize;


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        pointZero = new Point(MARGIN, this.getSize().height - MARGIN);

        Dimension chartSize = new Dimension();
        chartSize.width = this.getSize().width - 2 * MARGIN;
        chartSize.height = this.getSize().height - 2 * MARGIN;

        this.YUnitSize = chartSize.height / (Y_MAX_VALUE/ Y_UNIT);

        this.drawAxis(g, pointZero, chartSize);

        this.findScaleFactor(chartSize);


        this.drawChar(g, pointZero, chartSize);

    }


    public int askForYearToDisplay() {

        // loop until getting valid year
        while (true) {

            String input;
            int year;

            // take input
            input = JOptionPane.showInputDialog("Please enter a year between " + WeatherData.getOldestYear() + " and " + WeatherData.getNewestYear());

            // check if the user pressed Enter
            if (input == null || input.equals("")) {
                return Weather.CANCEL;
            }

            try {
                // convert the text into num
                year = Integer.parseInt(input);

                // check if the year in range, else loop again
                if (WeatherData.isYearInRange(year)) {
                    return year;
                }
                //todo else error print range year
            } catch (Exception e) {
                System.out.println("failed when trying to convert this '" + input + "' into number");
                //todo print only number note on screen " enter only number"
            }

        }

    }


    public void getYearData(int year) {
        chartData = WeatherData.getYearData(year);
        this.findMaxMinBarHeight();
    }

    public void showData() {
        repaint();
    }

    private void drawAxis(Graphics g, Point pointZero, Dimension d) {

        g.setColor(Color.BLACK);

        // draw X axis
        g.drawLine(pointZero.x, pointZero.y, pointZero.x + d.width, pointZero.y);

        // draw Y axis
        g.drawLine(pointZero.x, pointZero.y, pointZero.x, pointZero.y - d.height);

        // max temp is 60, 60 / 5 = 12
        // divide the Y into 12
        int spaceY = this.YUnitSize;
        int v = this.Y_UNIT;
        for(int i = spaceY; i < d.height; i += spaceY){
            g.drawLine(pointZero.x - this.LINE_LENGTH, pointZero.y - i, pointZero.x + this.LINE_LENGTH, pointZero.y - i);
            g.drawString("" + v, pointZero.x - 4 * this.LINE_LENGTH, pointZero.y - i + this.LINE_LENGTH);
            v = v + 5;
        }

    }


    private void drawChar(Graphics g, Point pointZero, Dimension chartSize) {

        int nextBarPosition = pointZero.x + SPACE_BETWEEN_BARS;

        int month = 1;
        for (Integer value : chartData) {

            if (value == maxBarHeight) {
                g.setColor(Color.RED);
            } else if (value == minBarHeight) {
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.GRAY);
            }

//            int barHeight = (int) (value * scaleFactor);
            int barHeight = (int) (((double) value / (double) this.Y_UNIT) * this.YUnitSize);

            g.fillRect(nextBarPosition, pointZero.y - barHeight, this.BAR_WIDTH, barHeight);

            g.setColor(Color.BLACK);
            g.drawString("" + month, nextBarPosition + this.BAR_WIDTH / 2, pointZero.y + this.YUnitSize / 2);

            nextBarPosition += this.SPACE_BETWEEN_BARS + this.BAR_WIDTH;
            month++;
        }
    }

    private void findMaxMinBarHeight() {

        int max = chartData.get(0);
        int min = chartData.get(0);

        for (Integer v : chartData) {
            if (v > max) {
                max = v;
            }

            if (v < min) {
                min = v;
            }
        }

        this.maxBarHeight = max;
        this.minBarHeight = min;
    }

    private void findScaleFactor(Dimension chartSize) {
        double maxHeight = chartSize.height * 0.9;
        this.scaleFactor = maxHeight / maxBarHeight;

    }

}
