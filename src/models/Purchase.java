package models;
import utils.*;

public class Purchase {
    private int purchaseId;
    private int customerId;
    private int deviceId;
    private String date;
    private PurchaseType type;

    public int newId(){
        Utils myUtil = new Utils();
        return myUtil.nextID(100000, 9999999);
    }
}



