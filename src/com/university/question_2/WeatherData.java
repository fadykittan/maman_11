package com.university.question_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeatherData {

    public static Map<Integer, ArrayList<Integer>> chartData = new HashMap<>();
    public static int oldestYear = 2015;
    public static int newestYear = 2016;

    public static void prepareData() {

        int[] temperature = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] years = {2015, 2016};


        for (int i = 0; i < temperature.length; i++) {

            ArrayList<Integer> monthData = new ArrayList<>();

            for (int j = 0; j < 12; j++) {
                monthData.add(temperature[i]);
            }

            chartData.put(years[i%12], monthData);

        }


    }


    public static boolean isYearInRange(int year){
        if(oldestYear <= year && year <= newestYear){
            return true;
        } else {
            return false;
        }
    }

    public static ArrayList<Integer> getYearData(int year){
        return chartData.get(year);
    }


}
