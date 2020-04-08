package com.university.question_2;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WeatherGUI extends JPanel {


    private ArrayList<Integer> chartData;
    private final int MARGIN = 30;
    private final int BAR_WIDTH = 30;
    private final int SPACE_BETWEEN_BARS = 20;
    private Point pointZero;
    private int maxBarHeight;
    private int minBarHeight;
    private double scaleFactor;


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        pointZero = new Point(MARGIN, this.getSize().height - MARGIN);

        Dimension chartSize = new Dimension();
        chartSize.width = this.getSize().width - 2 * MARGIN;
        chartSize.height = this.getSize().height - 2 * MARGIN;


        this.drawAxis(g, pointZero, chartSize);

        chartData = new ArrayList<>();
        chartData.add(10);
        chartData.add(20);
        chartData.add(70);

        this.findMaxMinBarHeight();
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
            if (input.equals("")) {
                return Weather.CANCEL;
            }

            try {
                // convert the text into num
                year = Integer.parseInt(input);

                // check if the year in range, else loop again
                if (WeatherData.isYearInRange(year)) {
                    return year;
                }
            } catch (Exception e) {
                System.out.println("failed when trying to convert this '" + input + "' into number");
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

    }


    private void drawChar(Graphics g, Point pointZero, Dimension chartSize) {

        int nextBarPosition = pointZero.x + SPACE_BETWEEN_BARS;

        for (Integer value : chartData) {

            if (value == maxBarHeight) {
                g.setColor(Color.RED);
            } else if (value == minBarHeight) {
                g.setColor(Color.BLUE);
            } else {
                g.setColor(Color.GRAY);
            }

            int barHeight = (int) (value * scaleFactor);

            g.fillRect(nextBarPosition, pointZero.y - barHeight, BAR_WIDTH, barHeight);
            nextBarPosition += SPACE_BETWEEN_BARS + BAR_WIDTH;
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
