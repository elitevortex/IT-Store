package main.models;
import main.utils.*;

public abstract class Purchase {
    private int purchaseId;
    private int customerId;
    private int deviceId;
    private String date;
    private String deliveryAddress;
    private PurchaseType type;

    Purchase(){};
    Purchase(int newCustomerId, int newDeviceId , String newDate, String newDeliveryAddress, PurchaseType newType){
        this.customerId = newCustomerId;
        this.deviceId = newDeviceId;
        this.date = newDate;
        this.deliveryAddress = newDeliveryAddress;
        this.type = newType;
    }
    public int newPurchaseId(){
        Utils myUtil = new Utils();
        return myUtil.nextID(100000, 9999999);
    }

    public int getCustomerId(){ return this.customerId;}
    public int getDeviceId(){
        return this.deviceId;
    }
    public String getDate(){ return this.date;}
    public PurchaseType getType(){return this.type;}

}



