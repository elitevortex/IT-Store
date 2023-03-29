package main.controllers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import main.models.*;
import main.utils.MenuManager;
import main.utils.PurchaseType;

public class Store implements IData{
    private ArrayList<Computer> computers = new ArrayList<>();
    private ArrayList<Printer> printers = new ArrayList<>();
    private ArrayList<Device> devices = new ArrayList<>();
    private PurchaseManager purchaseManager = new PurchaseManager();
    private MenuManager menuManager = new MenuManager();

    public Store(PurchaseManager newPurchaseManager, MenuManager newMenuManager){
        this.purchaseManager = newPurchaseManager;
        this.menuManager = newMenuManager;
    }

    // creating three computers and saving them in the array "computers"
    public void createComputers() {
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
    public void createPrinters() {
        String name, description;
        int ppm;
        Scanner sel = new Scanner(System.in);
        System.out.print("Enter Device (printer) Name:");
        name = sel.nextLine();
        System.out.print("Enter Device (printer) Description:");
        description = sel.nextLine();
        System.out.print("Enter Printer ppm: ");
        ppm = sel.nextInt();
        Printer aPrinter = new Printer(name, description, ppm);
        printers.add(aPrinter);
        devices.add(aPrinter);
    }

    public void createPurchase() {
        int purchaseId;
        int customerId;
        int deviceId;
        String date;
        int typeSelection;
        PurchaseType type;
        String deliveryAddress;
        String storeLocation;


        Scanner sel = new Scanner(System.in);

        System.out.print("Enter  CustomerId:");
        customerId = Integer.parseInt(sel.nextLine());

        System.out.print("Enter DeviceId: ");
        deviceId = Integer.parseInt(sel.nextLine());

        System.out.print("Enter Date: ");
        date = sel.nextLine();

        System.out.print("Enter Type (O online) OR (1 in_store): ");
        typeSelection = Integer.parseInt(sel.nextLine());

        if (typeSelection == 0) {
            type = PurchaseType.ONLINE;

            System.out.print("Enter Delivery Address: ");
            deliveryAddress = sel.nextLine();

            Purchase newPurchase = new OnlinePurchase(customerId, deviceId, date, deliveryAddress, type);
            newPurchase.newPurchaseId();

            this.purchaseManager.makePurchase(this, newPurchase);
        } else {
            type = PurchaseType.IN_STORE;

            System.out.print("Enter Store Location: ");
            storeLocation = sel.nextLine();

            Purchase newPurchase = new InStorePurchase(customerId, deviceId, date, storeLocation, type);
            newPurchase.newPurchaseId();
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
}
