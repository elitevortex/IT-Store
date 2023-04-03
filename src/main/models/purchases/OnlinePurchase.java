package main.models.purchases;

import main.utils.PurchaseType;
import main.utils.Utils;

public class OnlinePurchase extends Purchase {
    private String deliveryAddress;

    public OnlinePurchase(int newCustomerId, int newDeviceId , String newDate,
                          String newDeliveryAddress, PurchaseType newType) throws Exception {
        super(newCustomerId,newDeviceId , newDate,  newType);

        setPurchaseId(newPurchaseId());

        if(setDeliveryAddress(newDeliveryAddress)){
            // TODO
        } else{
            throw new Exception("Delivery address must be between 5 and 20 characters");
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
