package main.controllers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import main.models.devices.*;
import main.models.purchases.*;
import main.utils.IMenuManager;
import main.utils.MenuManagerEmployee;
import main.utils.PurchaseType;

public class Store implements IData{
    private ArrayList<Computer> computers = new ArrayList<>();
    private ArrayList<Printer> printers = new ArrayList<>();
    private ArrayList<Device> devices = new ArrayList<>();
    private PurchaseManager purchaseManager;
    private IMenuManager menuManager;
    private static Store myStore = null;

    private Store(PurchaseManager newPurchaseManager, IMenuManager newMenuManager) throws Exception {
        if (!setMenuManager(newMenuManager) || ! setPurchaseManager(newPurchaseManager)){
            throw new Exception("MenuManager or PurchaseManager is null");
        }
    }

    public static Store getInstance(PurchaseManager newPurchaseManager, IMenuManager newMenuManager) throws Exception{
        Store store =  new Store(newPurchaseManager, newMenuManager);
        if (myStore == null){
            myStore = store;
        }
        return store;
    }

    public boolean setPurchaseManager(PurchaseManager newPurchaseManager){
        if (newPurchaseManager != null) {
            this.purchaseManager = newPurchaseManager;
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setMenuManager(IMenuManager newMenuManager){
        if (newMenuManager != null){
            this.menuManager = newMenuManager;
            return true;
        }
        else{
            return false;
        }
    }
    // creating three computers and saving them in the array "computers"
    public void createComputers() throws Exception {
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

    // creates two printers in the array printers
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

    // iterates through all the printers in the array and prints them
    public void printPrinters(){
        for(int i = 0; i < this.printers.size(); i++){
            System.out.println("Printer (" + (i + 1)  + ") ID: " + this.printers.get(i).getId()+ " | Type: Printer " + this.printers.get(i).toString());
        }
    }

    // iterates through all the computers in the array and prints them.
    public void printComputers(){
        for(int i = 0; i < this.computers.size(); i++){
            System.out.println("Computer (" + (i + 1)  + ") ID: " + this.computers.get(i).getId() + " | Type: Computer " + this.computers.get(i).toString());
        }
    }


    @Override
    public boolean isDeviceAvailable(int id) {
        for (Device device: this.devices){
            if (device.getId() == id){
                return true;
            }
        }
        return false;
    }

    public void runBazar() throws Exception {

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
