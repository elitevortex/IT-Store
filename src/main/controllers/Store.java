package main.controllers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.models.devices.*;
import main.models.purchases.*;
import main.utils.IMenuManager;
import main.utils.MenuManagerEmployee;
import main.utils.PurchaseType;

/**
 * The Store class that implements storage and creation functionality for available devices
 *
 * @author Edward Chan 33095019
 * @version 1.0.0
 */
public class Store implements IData{
    /**
     * Array list of all Computer instances in the Store
     */
    private ArrayList<Computer> computers = new ArrayList<>();
    /**
     * Array list of all Printers instances in the Store
     */
    private ArrayList<Printer> printers = new ArrayList<>();
    /**
     * Array list of all Device instances in the Store
     */
    private ArrayList<Device> devices = new ArrayList<>();
    /**
     * The purchase manager of the store
     */
    private PurchaseManager purchaseManager;
    /**
     * The MenuManger (Admin or Employee) of the store
     */
    private IMenuManager menuManager;
    /**
     * the current Store that is initialised as null
     * this allows use of only one purchase at a time
     */
    private static Store myStore = null;

    /**
     * A constructor for the Store class
     * @param newPurchaseManager the purchase manager for the Store instance
     * @param newMenuManager the menu manager for the Store instance
     * @throws Exception
     */
    private Store(PurchaseManager newPurchaseManager, IMenuManager newMenuManager) throws Exception {
        if (!setMenuManager(newMenuManager) || ! setPurchaseManager(newPurchaseManager)){
            throw new Exception("MenuManager or PurchaseManager is null");
        }
    }

    /**
     * A method that creates a Store instance
     * @param newPurchaseManager
     * @param newMenuManager
     * @return
     * @throws Exception
     */
    public static Store getInstance(PurchaseManager newPurchaseManager, IMenuManager newMenuManager) throws Exception{
        Store store =  new Store(newPurchaseManager, newMenuManager);
        if (myStore == null){
            myStore = store;
        }
        return store;
    }

    /**
     * A method to set the new PurchaseManager a
     * @param newPurchaseManager the new PurchaseManager object
     * @return boolean that indicates success validating the new purchase manager
     */
    public boolean setPurchaseManager(PurchaseManager newPurchaseManager){
        if (newPurchaseManager != null) {
            this.purchaseManager = newPurchaseManager;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * A method to set the new MenuManager
     * @param newMenuManager the new MenuManager object
     * @return boolean that indicates success validating the new MenuManager
     */
    public boolean setMenuManager(IMenuManager newMenuManager){
        if (newMenuManager != null){
            this.menuManager = newMenuManager;
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * A method that creates a Computer instance based on user inputted attributes
     * @throws Exception will throw an Exception if arguments passed into Computer are of incorrect char range
     */
    public void createComputers() throws Exception{
        String name, description, manufacture;
        Scanner sel = new Scanner(System.in);
        System.out.print("Enter Device (computer) Name:");
        name = sel.nextLine();
        System.out.print("Enter Device (computer) Description:");
        description = sel.nextLine();
        System.out.print("Enter Computer Manufacture: ");
        manufacture = sel.next();
        Computer aComputer = new Computer(name, description, manufacture);
        computers.add(aComputer);
        devices.add(aComputer);
    }

    /**
     * A method that creates a Printer instance based on user inputted attributes
     * @throws Exception will throw an Exception if arguments passed into Printer are of incorrect char range
     */
    public void createPrinters() throws Exception{
        String name, description;
        int ppm = 0;
        Scanner sel = new Scanner(System.in);
        System.out.print("Enter Device (printer) Name:");
        name = sel.nextLine();
        System.out.print("Enter Device (printer) Description:");
        description = sel.nextLine();

        System.out.print("Enter Printer ppm: ");
        try{
            ppm = sel.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
        }
        Printer aPrinter = new Printer(name, description, ppm);
        printers.add(aPrinter);
        devices.add(aPrinter);
    }

    /**
     * A method that creates a new Purchase based on user selection and device availability in current Store
     * @throws Exception
     */
    public void createPurchase() throws Exception {
        int purchaseId;
        int customerId = 0;
        int deviceId = 0;
        String date;
        int typeSelection = 0;
        PurchaseType type;
        String deliveryAddress;
        String storeLocation;


        Scanner sel = new Scanner(System.in);

        System.out.print("Enter  CustomerId:");
        try{
            customerId = Integer.parseInt(sel.nextLine());
        }
        catch (InputMismatchException e){
            System.out.println(e);;
        }

        System.out.print("Enter DeviceId: ");
        try{
            deviceId = Integer.parseInt(sel.nextLine());
        } catch (InputMismatchException e){
            System.out.println(e);
        }

        System.out.print("Enter Date: ");
        date = sel.nextLine();

        System.out.print("Enter Type (O online) OR (1 in_store): ");
        try{
            typeSelection = Integer.parseInt(sel.nextLine());
        } catch (InputMismatchException e){
            System.out.println(e);
        }

        if (typeSelection == 0) {
            type = PurchaseType.ONLINE;

            System.out.print("Enter Delivery Address: ");
            deliveryAddress = sel.nextLine();

            Purchase newPurchase = new OnlinePurchase(customerId, deviceId, date, deliveryAddress, type);
            this.purchaseManager.makePurchase(this, newPurchase);
        } else {
            type = PurchaseType.IN_STORE;

            System.out.print("Enter Store Location: ");
            storeLocation = sel.nextLine();

            Purchase newPurchase = new InStorePurchase(customerId, deviceId, date, storeLocation, type);
            this.purchaseManager.makePurchase(this, newPurchase);

        }
    }

    /**
     * A method that prints all available printers in the store in a tabular format
     */
    public void printPrinters(){
        for(int i = 0; i < this.printers.size(); i++){
            System.out.println("Printer (" + (i + 1)  + ") ID: " + this.printers.get(i).getId()+ " | Type: Printer " + this.printers.get(i).toString());
        }
    }

    /**
     * A method that prints all available printers in the store in a tabular format
     */
    public void printComputers(){
        for(int i = 0; i < this.computers.size(); i++){
            System.out.println("Computer (" + (i + 1)  + ") ID: " + this.computers.get(i).getId() + " | Type: Computer " + this.computers.get(i).toString());
        }
    }

    /**
     * A method that checks the availability of a device within the current store
     * @param id the if of the device being checked
     * @return a boolean indicating whether the device is in the store
     */
    @Override
    public boolean isDeviceAvailable(int id) {
        for (Device device: this.devices){
            if (device.getId() == id){
                return true;
            }
        }
        return false;
    }

    /**
     * A method that runs store operations based on a switch case that the user can select
     * @throws Exception throws an exception if any of operations get invalid user inputs
     */
    public void runBazar() throws Exception{

        int selection;
        do {
            selection = menuManager.menuItem();
            switch (selection) {
                case 1:
                    this.createComputers();
                    break;
                case 2:
                    this.createPrinters();
                    break;
                case 3:
                    this.createPurchase();
                    break;
                case 4:
                    this.printComputers();
                    break;
                case 5:
                    this.printPrinters();
                    break;
                case 6:
                    purchaseManager.printPurchases();
                    break;
                case 7:
                    System.exit(0);
            }
        }while (selection != 7);
    }
}
