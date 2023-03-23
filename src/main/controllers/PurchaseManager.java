package main.controllers;

import main.models.InStorePurchase;
import main.models.OnlinePurchase;
import main.models.Purchase;
import main.utils.PurchaseType;

import java.util.ArrayList;
import java.util.Scanner;

public class PurchaseManager{
    private ArrayList<Purchase> purchases = new ArrayList<>();

    public void makePurchase(IData devices, Purchase newPurchase){
        if (devices.isDeviceAvailable(newPurchase.getDeviceId())){
            this.purchases.add(newPurchase);
        }
    }
    public void createPurchase(){
        int purchaseId;
        int customerId;
        int deviceId;
        String date;
        int typeSelection;
        PurchaseType type;
        String deliveryAddress;


        Scanner sel = new Scanner(System.in);

        System.out.print("Enter  CustomerId:");
        customerId = sel.nextInt();

        System.out.print("Enter DeviceId");
        deviceId = sel.nextInt();

        System.out.print("Enter Date");
        date = sel.nextLine();

        System.out.print("Enter Type (O online) OR (1 in_store)");

        System.out.println("Enter Delivery Address: ");
        deliveryAddress = sel.nextLine();

        typeSelection = sel.nextInt();
        if (typeSelection == 0){
            type = PurchaseType.ONLINE;
            Purchase newPurchase = new OnlinePurchase(customerId, deviceId, date, deliveryAddress, type);
            this.purchases.add(newPurchase);
        }
        else{
            type = PurchaseType.IN_STORE;
            Purchase newPurchase = new InStorePurchase(customerId, deviceId, date, deliveryAddress, type);
            this.purchases.add(newPurchase);
        }



    }

    public void printPurchases(){
        String leftAlignFormat = "| %-5d | %-5d | %-10s | %-8s |%n";
        String leftAlignFormatHeader = "| %-5s | %-5s | %-10s | %-8s |%n";

        String header=String.format(leftAlignFormatHeader, "Cust-ID","Dev-ID","Date","Type");
        int headerLen=header.length()-1; // -1 to ignore the return key
        String border = String.format("%" + headerLen + "s", " ").replace(' ', '-');
        System.out.format("%s\n", border);

        System.out.format(leftAlignFormatHeader, "C-I","D-ID","Date","Type");
        System.out.format("%s\n", border);

        for (int i = 0; i < this.purchases.size(); i++) {

            int c_id = this.purchases.get(i).getCustomerId();
            int d_id = this.purchases.get(i).getDeviceId();
            String date  = this.purchases.get(i).getDate();
            PurchaseType type = this.purchases.get(i).getType();

            System.out.format(leftAlignFormat, c_id, d_id, date, type);
        }
        System.out.format("%s\n", border);

    }

}
