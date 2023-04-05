package main.models.devices;
import main.models.devices.Device;
import main.utils.*;

/**
 * Computer class is a child class of Device that represents a Computer instance
 *
 * @author Edward Chan 33095019
 * @version 1.0.0
 */

public class Computer extends Device {
    /**
     * The manufacturer of the computer
     */
    private String manufacture;


    /**
     * The constructor for a new Computer instance
     * @param newName a new name for the Computer
     * @param newDescription a new description for the Computer
     * @param newManufacture a new manufacture for the Computer
     * @throws Exception throws an exception if invalid arguments are received
     */

    public Computer(String newName, String newDescription, String newManufacture) throws Exception {
        super(newName, newDescription);

        if (!setManufacture(newManufacture)) {
            throw new Exception("Incorrect manufacture length");
        }
        setId(generateId());
    }

    /**
     * A getter for the manufacture of the Computer
     * @return A String of the Manufacturer
     */
    public String getManufacture(){
        return this.manufacture;
    }

    /**
     * A setter for the menufacturer
     * @param newManufacture the new Computer manufacturer
     * @return a boolean based on whether the newManufacturer meets the character range constraints
     */
    public boolean setManufacture(String newManufacture){
        if ((Utils.stringInRange(newManufacture, 3, 15) == true)){
            this.manufacture = newManufacture;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * A method that randomly generates an the id between a certain range
     * @return an integer value of the id
     */
    public int generateId(){
        Utils myUtil = new Utils();
        return myUtil.nextID(100000, 9999999);
    }

    /**
     * A method that concatenates a new manufacturer section of the tabular string format for the Computer
     * @return
     */
    public String toString(){
        return super.toString() + "manufacture: " + getManufacture();
    }


}
