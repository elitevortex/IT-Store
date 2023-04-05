package main;

import main.controllers.*;
import main.utils.IMenuManager;
import main.utils.MenuManagerAdmin;
import main.utils.MenuManagerEmployee;

/**
 *  <h1>Bazar Driver </h1>
 *  The Bazar Driver program implements an application that
 *  can control the transactions of a store that stocks printers and computers
 *
 *  <p>
 *      Giving proper comments is optimal but not implemented in this application
 *  </p>
 *
 * @author FIT2099 Edward Chan 33095019
 * @version 1.0
 * @since 2023-04-5
 */


public class BazarDriver {
    /**
     * Our main method that creates a purchase manager, a menu manager, and a store, and running the store
     * @param args the command line arguments
     * @throws Exception if unsuccessful in creating a purchase manager, menu manager, or store.
     */
    public static void main(String[] args) throws Exception{
        try{
            PurchaseManager purchaseManager = PurchaseManager.getInstance();
            IMenuManager  menuManager =  MenuManagerAdmin.getInstance();
            Store newStore = Store.getInstance(purchaseManager, menuManager);
            newStore.runBazar();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}
