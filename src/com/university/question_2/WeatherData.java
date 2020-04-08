package com.university.question_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WeatherData {

    public static Map<Integer, ArrayList<Integer>> chartData = new HashMap<>();
    private static int oldestYear;
    private static int newestYear;

    public static void prepareData() {

        int[] temperature = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12,
                9, 10, 15, 20, 23, 25, 30, 35, 25, 15, 12, 8,
                21, 23, 26, 31, 35, 37, 40, 50, 36, 33, 28, 23,
                20, 22, 25, 30, 34, 37, 40, 45, 36, 31, 26, 21,
                18, 20, 22, 27, 32, 35, 37, 40, 35, 32, 26, 20
        };

        int[] years = {2015, 2016, 2017, 2018, 2019};

        findMaxMinYear(years);

        for (int y = 0; y < years.length; y++) {

            ArrayList<Integer> yearData = new ArrayList<>();

            for (int t = y * 12; t < (y + 1) * 12; t++) {
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
