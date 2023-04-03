package main.models.purchases;

import main.utils.PurchaseType;
import main.utils.Utils;

public class InStorePurchase extends Purchase {
    private String storeLocation;

    public InStorePurchase(int newCustomerId, int newDeviceId , String newDate,
                           String newStoreLocation, PurchaseType newType) throws Exception{
        super(newCustomerId,newDeviceId , newDate,  newType);

        if (setStoreLocation(newStoreLocation)){
            // TODO
        } else{
            throw new Exception("Store location length must be between 3 and 10 characters");
        }

        setPurchaseId(newPurchaseId());
    }

    public String getStoreLocation(){
        return this.storeLocation;
    }

    public boolean setStoreLocation(String newStoreLocation){
        if ((Utils.stringInRange(newStoreLocation, 3, 10) == true)){
            this.storeLocation = newStoreLocation;
            return true;
        }
        else{
            return false;
        }
    }
    public int newPurchaseId(){
        return Utils.nextID(100, 999);
    }
}
