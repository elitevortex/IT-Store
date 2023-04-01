package main.utils;

import java.util.Random;

public class Utils {
    public static int nextID(int low, int high) {
        Random r = new Random();
        return (r.nextInt(high - low) + low);
    }

    public static boolean stringInRange(String checkingString, int lo, int hi){
        if (lo <= checkingString.length() && checkingString.length() <= hi){
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean intInRange(int checkingInt, int lo, int hi){
        if (lo <= checkingInt && checkingInt <= hi){
            return true;
        }
        else{
            return false;
        }
    }
}

