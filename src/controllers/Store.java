package controllers;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;
import models.*;

public class Store {
        private ArrayList<Computer> computers = new ArrayList<>();
    private ArrayList<Printer> printers = new ArrayList<>();

    //  creates the objects of the arrays using the input lengths
    public void initStore(int numComputer, int numPrinters){
        this.computers = new ArrayList<>(numComputer);
        this.printers = new ArrayList<>(numPrinters);
    }

    // creating three computers and saving them in the array "computers"
    public void createComputers() {
        String name, description, manufacture;
        Scanner sel = new Scanner(System.in);
        System.out.print("Enter models.Device (computer) Name:");
        name = sel.nextLine();
        System.out.print("Enter models.Device (computer) Description:");
        description = sel.nextLine();
        System.out.print("Enter models.Computer Manufacture: ");
        manufacture = sel.next();
        Computer aComputer = new Computer(name, description, manufacture);
        computers.add(aComputer);
    }

    // creates two printers in the array printers
    public void createPrinters() {
        String name, description;
        int ppm;
        Scanner sel = new Scanner(System.in);
        System.out.print("Enter models.Device (printer) Name:");
        name = sel.nextLine();
        System.out.print("Enter models.Device (printer) Description:");
        description = sel.nextLine();
        System.out.print("Enter models.Printer ppm: ");
        ppm = sel.nextInt();
        Printer aPrinter = new Printer(name, description, ppm);
        printers.add(aPrinter);
    }

    // iterates through all the printers in the array and prints them
    public void printPrinters(){
        for(int i = 0; i < this.printers.size(); i++){
            System.out.println("models.Printer (" + (i + 1)  + ") ID: " + this.printers.get(i).generateId() + " | Type: models.Printer " + this.printers.get(i).toString());
        }
    }

    // iterates through all the computers in the array and prints them.
    public void printComputers(){
        for(int i = 0; i < this.computers.size(); i++){
            System.out.println("models.Computer (" + (i + 1)  + ") ID: " + this.printers.get(i).generateId() + " | Type: models.Computer " + this.computers.get(i).toString());
        }
    }


////     calling all creation and printing methods
//    public void runBazar(){
//        initStore(3, 2);
//        createComputers();
//        createPrinters();
//        printComputers();
//        printPrinters();
//    }



}
