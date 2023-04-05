package main.models.purchases;

import main.utils.PurchaseType;
import main.utils.Utils;

/**
 * InStorePurchase class is a child class of Purchase that represents an in store purchase
 *
 * @author Edward Chan 33095019
 * @version 1.0.0
 */

public class InStorePurchase extends Purchase {
    /**
     * The location of the Store
     */
    private String storeLocation;

    /**
     * A constructor for an InStorePurchase instance
     * @param newCustomerId the customers id
     * @param newDeviceId the id of the device
     * @param newDate the date of purchase
     * @param newStoreLocation the location of the store
     * @param newType the type of purchase
     * @throws Exception throws an Exception if the new store location is an invalid length
     */
    public InStorePurchase(int newCustomerId, int newDeviceId , String newDate,
                           String newStoreLocation, PurchaseType newType) throws Exception{
        super(newCustomerId,newDeviceId , newDate,  newType);

        if (!setStoreLocation(newStoreLocation)){
            throw new Exception("Store location length must be between 3 and 10 characters");
        }

        setPurchaseId(newPurchaseId());
    }

    /**
     * A method that returns the location of the store
      * @return a String representing the store location
     */
    public String getStoreLocation(){
        return this.storeLocation;
    }

    /**
     * A method that sets the new store location
     * @param newStoreLocation a new store location
     * @return a boolean indicating whether the new location satisfies the length specifications
     */
    public boolean setStoreLocation(String newStoreLocation){
        if ((Utils.stringInRange(newStoreLocation, 3, 10) == true)){
            this.storeLocation = newStoreLocation;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * A method that creates a new purchase id
     * @return a random integer in a specified range representing the purchase id
     */
    public int newPurchaseId(){
        return Utils.nextID(100, 999);
    }
}
