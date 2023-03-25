package main.models;

import main.utils.PurchaseType;

public class InStorePurchase extends Purchase{
    private String storeLocation;

    public InStorePurchase(int newCustomerId, int newDeviceId , String newDate, String newStoreLocation, PurchaseType newType) {
        super(newCustomerId,newDeviceId , newDate,  newType);
        this.storeLocation = newStoreLocation;
    }

    public String getStoreLocation(){
        return this.storeLocation;
    }

}
