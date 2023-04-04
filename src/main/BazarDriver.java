package main;

import main.controllers.*;
import main.utils.IMenuManager;
import main.utils.MenuManagerAdmin;
import main.utils.MenuManagerEmployee;

public class BazarDriver {
    public static void main(String[] args) {
        try{
            PurchaseManager purchaseManager = PurchaseManager.getInstance();
            IMenuManager  menuManager =  MenuManagerEmployee.getInstance();
            Store newStore = Store.getInstance(purchaseManager, menuManager);
            newStore.runBazar();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
