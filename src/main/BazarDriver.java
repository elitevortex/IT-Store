package main;

import main.controllers.*;
import main.utils.MenuManager;

import java.awt.*;

public class BazarDriver {
    public static void main(String[] args) {
        PurchaseManager purchaseManager = new PurchaseManager();
        MenuManager menuManager = new MenuManager();
        Store newStore = new Store(purchaseManager, menuManager);

        int selection;
        do {
            selection = menuManager.menuItem();
            switch (selection) {
                case 1:
                    newStore.createComputers();
                    break;
                case 2:
                    newStore.createPrinters();
                    break;
                case 3:
                    newStore.createPurchase();
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
        }while (selection != 7);
    }
}
