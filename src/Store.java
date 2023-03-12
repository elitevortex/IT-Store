import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private ArrayList<Computer> computers;
    private ArrayList<Printer> printers;

    //  creates the objects of the arrays using the input lengths
    public void initStore(int numComputer, int numPrinters){
        this.computers = new ArrayList<>(numComputer);
        this.printers = new ArrayList<>(numPrinters);
    }

    // creating three computers and saving them in the array "computers"
    public void createComputers() {
        String name, description, manufacture;
        Scanner sel = new Scanner(System.in);
        System.out.print("Enter Device Name:");
        name = sel.nextLine();
        System.out.print("Enter Device Description:");
        description = sel.nextLine();
        System.out.print("Enter Computer Manufacture: ");
        manufacture = sel.next();
        Computer aComputer = new Computer(name, description, manufacture);
        computers.add(aComputer);
    }

    // creates two printers in the array printers
    public void createPrinters() {
        String name, description;
        int ppm;
        Scanner sel = new Scanner(System.in);
        System.out.print("Enter Device Name:");
        name = sel.nextLine();
        System.out.print("Enter Device Description:");
        description = sel.nextLine();
        System.out.print("Enter Computer ppm: ");
        ppm = sel.nextInt();
        Printer aPrinter = new Printer(name, description, ppm);
        printers.add(aPrinter);
    }

    // iterates through all the printers in the array and prints them
    public void printPrinters(){
        for(int i = 0; i < this.printers.size(); i++){
            System.out.println("Printer (" + (i + 1)  + ") Type: Printer " + this.printers.get(i).toString());
        }
    }

    // iterates through all the computers in the array and prints them.
    public void printComputers(){
        for(int i = 0; i < this.computers.size(); i++){
            System.out.println("Computer (" + (i + 1)  + ") Type: Computer " + this.computers.get(i).toString());
        }
    }

    // calling all creation and printing methods
    public void runBazar(){
        initStore(3, 2);
        createComputers();
        createPrinters();
        printComputers();
        printPrinters();
    }



}
