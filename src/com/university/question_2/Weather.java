package com.university.question_2;

import com.university.question_1.GameGUI;

import javax.swing.*;

public class Weather {

    public final static int CANCEL = -1;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Weather");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        WeatherGUI gui = new WeatherGUI();
        frame.add(gui);
        frame.setVisible(true);
        WeatherData.prepareData();


        int year = gui.askForYearToDisplay();

        while (year != CANCEL) {

            gui.getYearData(year);
            gui.showData();
            year = gui.askForYearToDisplay();
        }



    }

}
