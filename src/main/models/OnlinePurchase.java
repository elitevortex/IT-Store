package main.models;

import main.utils.PurchaseType;

public class OnlinePurchase extends Purchase{
    private String deliveryAddress;

    public OnlinePurchase(int newCustomerId, int newDeviceId , String newDate, String newDeliveryAddress, PurchaseType newType) {
        super(newCustomerId,newDeviceId , newDate,  newType);
        this.deliveryAddress = newDeliveryAddress;
    }

    public String getDeliveryAddress(){return this.deliveryAddress; }

}
