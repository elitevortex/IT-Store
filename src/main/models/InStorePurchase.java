package main.models;

import main.utils.PurchaseType;
import main.utils.Utils;

public class InStorePurchase extends Purchase{
    private String storeLocation;

    public InStorePurchase(int newCustomerId, int newDeviceId , String newDate, String newStoreLocation, PurchaseType newType) {
        super(newCustomerId,newDeviceId , newDate,  newType);
        setPurchaseId(newPurchaseId());

        this.storeLocation = newStoreLocation;
    }

    public String getStoreLocation(){
        return this.storeLocation;
    }

    public int newPurchaseId(){
        return Utils.nextID(100, 999);
    }
}
