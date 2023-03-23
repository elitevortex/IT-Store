package main.models;

import main.utils.PurchaseType;

public class OnlinePurchase extends Purchase{

    public OnlinePurchase(int newCustomerId, int newDeviceId , String newDate, String newDeliveryAddress, PurchaseType newType) {
        super(newCustomerId,newDeviceId , newDate,  newDeliveryAddress,  newType);
    }


}
