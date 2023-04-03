package main.models.purchases;

import main.utils.PurchaseType;
import main.utils.Utils;

public class OnlinePurchase extends Purchase {
    private String deliveryAddress;

    public OnlinePurchase(int newCustomerId, int newDeviceId , String newDate, String newDeliveryAddress, PurchaseType newType) {
        super(newCustomerId,newDeviceId , newDate,  newType);

        setPurchaseId(newPurchaseId());

        try{
            setDeliveryAddress(newDeliveryAddress);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public String getDeliveryAddress(){return this.deliveryAddress; }
    public boolean setDeliveryAddress(String newDeliveryAddress){
        if((Utils.stringInRange(newDeliveryAddress, 5, 20) == true)){
            this.deliveryAddress = newDeliveryAddress;
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
