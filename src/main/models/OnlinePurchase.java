package main.models;

import main.utils.PurchaseType;
import main.utils.Utils;

public class OnlinePurchase extends Purchase{
    private String deliveryAddress;

    public OnlinePurchase(int newCustomerId, int newDeviceId , String newDate, String newDeliveryAddress, PurchaseType newType) {
        super(newCustomerId,newDeviceId , newDate,  newType);
        setPurchaseId(newPurchaseId());
        this.deliveryAddress = newDeliveryAddress;
    }

    public String getDeliveryAddress(){return this.deliveryAddress; }

    public int newPurchaseId(){
        return Utils.nextID(100, 999);
    }

}
