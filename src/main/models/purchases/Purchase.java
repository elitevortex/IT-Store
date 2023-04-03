package main.models.purchases;
import main.utils.*;

public abstract class Purchase {
    private int purchaseId;
    private int customerId;
    private int deviceId;
    private String date;
    private PurchaseType type;


    Purchase(){};
    public Purchase(int newCustomerId, int newDeviceId , String newDate, PurchaseType newType){
        try {
            setCustomerId(newCustomerId);
            setDate(newDate);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        this.deviceId = newDeviceId;
        this.date = newDate;
        this.type = newType;
    }

    public void setPurchaseId(int Id){this.purchaseId = Id;}
    public void setCustomerId(int Id){this.customerId = Id;}

    public boolean setDate(String newDate) {
        if((Utils.stringInRange(newDate, 8, 8) == true)){
            this.date = date;
            return true;
        }
        else{
            return false;
        }
    }

    public int getCustomerId(){ return this.customerId;}
    public int getDeviceId(){
        return this.deviceId;
    }
    public String getDate(){ return this.date;}
    public PurchaseType getType(){return this.type;}
    public int getPurchaseId(){return this.purchaseId;}

}



