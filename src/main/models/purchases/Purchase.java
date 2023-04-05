package main.models.purchases;
import main.utils.*;
/**
 * Purchase class is a base class that represents a generic Purchase (InStore or Online)
 *
 * @author Edward Chan 33095019
 * @version 1.0.0
 */
public abstract class Purchase {
    /**
     * The id of the purchase
     */
    private int purchaseId;
    /**
     * The customer's id
     */
    private int customerId;
    /**
     * The unique id of the device
     */
    private int deviceId;
    /**
     * The date of purchase
     */
    private String date;
    /**
     * The type of purchase
     */
    private PurchaseType type;

    /**
     * A constructor for a Purchase instance
     * @param newCustomerId the customers id
     * @param newDeviceId the id of the device
     * @param newDate the date of purchase
     * @param newType the type of purchase
     * @throws Exception throws an Exception if the date string is out of range
     */
    public Purchase(int newCustomerId, int newDeviceId , String newDate, PurchaseType newType) throws Exception{
        if (!setDate(newDate)){
            throw new Exception("Date must be of 8 character in length");
        }
        this.customerId = newCustomerId;
        this.deviceId = newDeviceId;
        this.date = newDate;
        this.type = newType;
    }

    /** A method to set the purchase id
     *
     * @param Id a new integer id
     */
    public void setPurchaseId(int Id){this.purchaseId = Id;}

    /**
     * A method to set the new date
     * @param newDate a string date
     * @return a boolean indicating whether the newDate is in the specified range
     */
    public boolean setDate(String newDate) {
        if((Utils.stringInRange(newDate, 8, 8) == true)){
            this.date = date;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * A getter for the customer id
     * @return the integer customer id
     */
    public int getCustomerId(){ return this.customerId;}

    /**
     * A getter for the device id
     * @return the integer device id
     */
    public int getDeviceId(){
        return this.deviceId;
    }
    /**
     * A getter for the date
     * @return the String date
     */
    public String getDate(){ return this.date;}
    /**
     * A getter for the type of purchase
     * @return an enum for the type of purchase
     */
    public PurchaseType getType(){return this.type;}

    /**
     * A getter for the purchase id
     * @return an integer for the purchase id
     */
    public int getPurchaseId(){return this.purchaseId;}

}



