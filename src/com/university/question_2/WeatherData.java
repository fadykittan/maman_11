package com.university.question_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeatherData {

    public static Map<Integer, ArrayList<Integer>> chartData = new HashMap<>();
    private static int oldestYear = 2015;
    private static int newestYear = 2016;

    public static void prepareData() {

        int[] temperature = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] years = {2015, 2016};

        findMaxMinYear(years);

        for (int y = 0; y < years.length; y++) {

            ArrayList<Integer> yearData = new ArrayList<>();

            for (int t = y * 12; t < 12; t++) {
                yearData.add(temperature[t]);
            }

            chartData.put(years[y], yearData);

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


    private static void findMaxMinYear(int[] years) {
        int max = years[0];
        int min = years[0];

        for (int i = 0; i < years.length; i++) {
            if(years[i] > max) {
                max = years[i];
            }

            if(years[i] < min) {
                min = years[i];
            }
        }

        oldestYear = min;
        newestYear = max;

    }


    public static int getOldestYear() {
        return oldestYear;
    }

    public static int getNewestYear() {
        return newestYear;
    }
}
