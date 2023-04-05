package main.models.purchases;

import main.utils.PurchaseType;
import main.utils.Utils;
/**
 * InStorePurchase class is a child class of Purchase that represents an in store purchase
 *
 * @author Edward Chan 33095019
 * @version 1.0.0
 */
public class OnlinePurchase extends Purchase {
    /**
     * The address for delivery
     */
    private String deliveryAddress;

    /**
     * A constructor for an OnlinePurchase
     * @param newCustomerId the customers id
     * @param newDeviceId the id of the device
     * @param newDate the date of purchase
     * @param newDeliveryAddress the delivery  for the item
     * @param newType the type of purchase
     * @throws Exception
     */
    public OnlinePurchase(int newCustomerId, int newDeviceId , String newDate,
                          String newDeliveryAddress, PurchaseType newType) throws Exception {
        super(newCustomerId,newDeviceId , newDate,  newType);

        setPurchaseId(newPurchaseId());

        if(!setDeliveryAddress(newDeliveryAddress)){
            throw new Exception("Delivery address must be between 5 and 20 characters");
        }
    }

    /**
     * A method that returns the delivery address of the store
     * @return a String representing the address of delivery for that purchase
     */
    public String getDeliveryAddress(){return this.deliveryAddress; }

    /**
     * A method that sets the delivery address
     * @param newDeliveryAddress
     * @return a boolean indicating whether the newDeliveryAddress is in the specified range
     */
    public boolean setDeliveryAddress(String newDeliveryAddress){
        if((Utils.stringInRange(newDeliveryAddress, 5, 20) == true)){
            this.deliveryAddress = newDeliveryAddress;
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
