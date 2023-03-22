package controllers;

import models.Purchase;
import java.util.ArrayList;

public class PurchaseManager {
    private ArrayList<Purchase> purchases = new ArrayList<>();

    public void addPurchase(Purchase newPurchase){
        this.purchases.add(newPurchase);
    }
}
