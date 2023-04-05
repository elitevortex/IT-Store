package main.models.devices;
import main.utils.*;

/**
 * Printer class is a child class of Device that represents a Printer instance
 *
 * @author Edward Chan 33095019
 * @version 1.0.0
 */

public class Printer extends Device {
    /**
     * An integer pages per minute attribute of the Printer instance
     */
    private int ppm;

    /**
     * A constructor for a Printer instance
     * @param newName the new Printer name
     * @param newDescription the new description for a Printer
     * @param newPpm the new pages per minute for a Printer
     * @throws Exception throws an exception if the new ppm is outside the specificeid range
     */
    public Printer(String newName, String newDescription, int newPpm) throws Exception{
        super(newName, newDescription);
        if(!setPpm(newPpm)) {
            throw new Exception("Incorrect range of ppm");
        }

        setId(generateId());

    }

    /**
     * A method that returns the ppm
     * @return int value of the ppm
     */
    public int getPpm() {
        return this.ppm;
    }

    /**
     * A method that sets the ppm
     * @param newPpm the new pages per minute
     * @return a boolean indicating success of set (if it's in specified range)
     */
    public boolean setPpm(int newPpm){
        if ((Utils.intInRange(newPpm, 5, 20) == true)){
            this.ppm = newPpm;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * A method that randomly generates an integer with a specified range
     * @return an int of the new id
     */
    public int generateId(){
        Utils myUtil = new Utils();
        return myUtil.nextID(100, 999);

    }

    /**
     * A method that concatenating the PPM, maintaining a tabular format
     * @return returns the string representation of a Printer
     */
    public String toString(){
        return super.toString() + "PPM: " + getPpm();
    }
}
