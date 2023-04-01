package main.controllers;

import main.models.purchases.Purchase;
import main.utils.PurchaseType;

import java.util.ArrayList;

public class PurchaseManager{
    private ArrayList<Purchase> purchases = new ArrayList<>();

    public void makePurchase(IData devices, Purchase newPurchase){
        if (devices.isDeviceAvailable(newPurchase.getDeviceId())){
            this.purchases.add(newPurchase);
        }
    }

    public void printPurchases(){

        String leftAlignFormat = "| %-5d | %-5d | %-5d | %-10s | %-8s |%n";
        String leftAlignFormatHeader = "| %-5s | %-5s | %-5s | %-10s | %-8s |%n";

        String header=String.format(leftAlignFormatHeader,"Pur-ID", "Cust-ID","Dev-ID","Date","Type");
        int headerLen=header.length()-1; // -1 to ignore the return key
        String border = String.format("%" + headerLen + "s", " ").replace(' ', '-');
        System.out.format("%s\n", border);

        System.out.format(leftAlignFormatHeader,"Pur_ID", "Cust-ID","Dev-ID","Date","Type");
        System.out.format("%s\n", border);

        for (int i = 0; i < this.purchases.size(); i++) {

            Purchase curr_purchase = this.purchases.get(i);
            int p_id = curr_purchase.getPurchaseId();
            int c_id = curr_purchase.getCustomerId();
            int d_id = curr_purchase.getDeviceId();
            String date  = curr_purchase.getDate();
            PurchaseType type = curr_purchase.getType();
            System.out.format(leftAlignFormat,p_id, c_id, d_id,date, type);
        }
        System.out.format("%s\n", border);

    }

}
