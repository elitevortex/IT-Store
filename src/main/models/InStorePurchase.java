package main.models;

import main.utils.PurchaseType;

public class InStorePurchase extends Purchase{

    public InStorePurchase(int newCustomerId, int newDeviceId , String newDate, String newDeliveryAddress, PurchaseType newType) {
        super(newCustomerId,newDeviceId , newDate,  newDeliveryAddress,  newType);
    }


}
