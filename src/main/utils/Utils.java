package main.utils;

import java.util.Random;

/**
 * Utils is a class that implements utility methods to check string length and integer value requirements,
 * as well as creating random integers
 * @author Edward Chan 33095019
 * @version 1.0.0
 */
public class Utils {
    /**
     * A method that randomly creates a new integer id within a certain range
     * @param low the lowest possible generated number
     * @param high the highest possible generated number
     * @return the integer generated id
     */
    public static int nextID(int low, int high) {
        Random r = new Random();
        return (r.nextInt(high - low) + low);
    }

    /**
     * A method that checks whether the length of a string is within a certain integer range
     * @param checkingString the string to be checked
     * @param lo the lowest number of characters allowed in the string
     * @param hi the highest number of characters allowed in the string
     * @return a boolean indicating whether the string is in the specified range
     */
    public static boolean stringInRange(String checkingString, int lo, int hi){
        if (lo <= checkingString.length() && checkingString.length() <= hi){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * A method that checks whether an integer is within a specific integer range
     * @param checkingInt the int to be checked
     * @param lo the lowest number in the allowed range
     * @param hi the highest number in the allowed range
     * @return a boolean indicating whether the integer is in the specified range
     */
    public static boolean intInRange(int checkingInt, int lo, int hi){
        if (lo <= checkingInt && checkingInt <= hi){
            return true;
        }
        else{
            return false;
        }
    }
}

