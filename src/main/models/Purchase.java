package main.models;
import main.utils.*;

public abstract class Purchase {
    private int purchaseId;
    private int customerId;
    private int deviceId;
    private String date;
    private PurchaseType type;


    Purchase(){};
    Purchase(int newCustomerId, int newDeviceId , String newDate, PurchaseType newType){
        this.customerId = newCustomerId;
        this.deviceId = newDeviceId;
        this.date = newDate;
        this.type = newType;
    }

    public void setPurchaseId(int Id){this.purchaseId = Id;}
    public int getCustomerId(){ return this.customerId;}
    public int getDeviceId(){
        return this.deviceId;
    }
    public String getDate(){ return this.date;}
    public PurchaseType getType(){return this.type;}
    public int getPurchaseId(){return this.purchaseId;}

}



