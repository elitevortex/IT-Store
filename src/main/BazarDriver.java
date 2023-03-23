package main;

import main.controllers.*;
import main.utils.MenuManager;

public class BazarDriver {
    public static void main(String[] args) {
        Store newStore = new Store();
        PurchaseManager purchaseManager = new PurchaseManager();
        int selection;
        do {
            selection = MenuManager.menuItem();
            switch (selection) {
                case 1:
                    newStore.createComputers();
                    break;
                case 2:
                    newStore.createPrinters();
                    break;
                case 3:
                    purchaseManager.createPurchase();
                    break;
                case 4:
                    newStore.printComputers();
                    break;
                case 5:
                    newStore.printPrinters();
                case 6:
                    purchaseManager.printPurchases();
                case 7:
                    System.exit(0);
            }
        } while (selection != 10);
    }


}
