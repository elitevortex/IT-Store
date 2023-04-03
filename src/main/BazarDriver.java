package main;

import main.controllers.*;
import main.utils.IMenuManager;
import main.utils.MenuManagerAdmin;

public class BazarDriver {
    public static void main(String[] args) {
        PurchaseManager purchaseManager = new PurchaseManager();
        IMenuManager  menuManager = new MenuManagerAdmin();
        Store newStore = new Store(purchaseManager, menuManager);
        newStore.runBazar();

//        int selection;
//        do {
//            selection = menuManager.menuItem();
//            switch (selection) {
//                case 1:
//                    newStore.createComputers();
//                    break;
//                case 2:
//                    newStore.createPrinters();
//                    break;
//                case 3:
//                    newStore.createPurchase();
//                    break;
//                case 4:
//                    newStore.printComputers();
//                    break;
//                case 5:
//                    newStore.printPrinters();
//                    break;
//                case 6:
//                    purchaseManager.printPurchases();
//                    break;
//                case 7:
//                    System.exit(0);
//            }
//        }while (selection != 7);
    }
}
