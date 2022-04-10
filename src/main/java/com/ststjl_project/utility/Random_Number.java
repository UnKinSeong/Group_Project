package com.ststjl_project.utility;


public class Random_Number {
    public static int randInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
    public static double randDouble(double min, double max){
        return min+(double)(Math.random()*((max-min)+1));
    }
}
