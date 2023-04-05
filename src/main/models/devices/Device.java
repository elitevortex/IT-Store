package main.models.devices;
import main.utils.Utils;

/**
 * Device class is a base class that represents a generic Device (printer or computer)
 *
 * @author Edward Chan 33095019
 * @version 1.0.0
 */

abstract public class Device {
    /**
     *  The id of the device
     */
    private int id;
    /**
     * The name of the device
     */
    private String name;
    /**
     * The description of the device
     */
    private String description;

    /**
     * A constructor for the Device class
     * @param newName the name of the device
     * @param newDescription the initial description of the device
     * @throws Exception
     */
    public Device(String newName, String newDescription) throws Exception{
        if (!setName(newName) || !setDescription(newDescription)) {
            throw new Exception(("Incorrect length of device name or description"));
        }

    }

    /**
     * A getter for the Id
     * @return the int id of the device
     */
    public int getId(){
        return this.id;
    }

    /**
     * A getter for the name
     * @return the String name of the device
     */
    public String getName(){
        return this.name;
    }

    /**
     * A getter for the description
     * @return the String description of the device
     */
    public String getDescription(){
        return description;
    }

    /**
     * A method to set the id attribute
     * @param newId
     */
    public void setId(int newId){
        this.id = newId;
    }

    /**
     *  A method to set the name attribute
     * @param newName
     * @return boolean based on success of the set operation
     */
    public boolean setName(String newName){
        if ((Utils.stringInRange(newName, 3, 15) == true) ){
            this.name = newName;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     *  A method to set the name description
     * @param newDescription
     * @return boolean based on success of the set operation
     */
    public boolean setDescription(String newDescription){
        if ((Utils.stringInRange(newDescription, 5, 20) == true)){
            this.description = newDescription;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * An abstract method to generate a random id
     * @return int value of the generated id
     */
    public abstract int generateId();

    /**
     * A method to generate to a string representation of a device
     * @return a string with name and description in tabloid structure
     */
    public String toString(){
      return "| name: " + this.getName() + " | description: " + this.getDescription() + " | ";
    }

}
