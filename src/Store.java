public class Store {
    private Computer[] computers;
    private Printer[] printers;

    Store(){}

    //  creates the objects of the arrays using the input lengths
    public void initStore(int numComputer, int numPrinters){
        this.computers = new Computer[numComputer];
        this.printers = new Printer[numPrinters];
    }

    // creating three computers and saving them in the array "computers"
    public void createComputers(){
        computers[0] = new Computer("XPS", "Laptop 16 inch", "Dell");
        computers[1] = new Computer("iMac", "Desltop 27 inch", "Apple");
        computers[2] = new Computer("Thinkpad", "Laptop 14 inch", "Lenovo");
    }

    // creates two printers in the array printers
    public void createPrinters(){
        printers[0] = new Printer("Mono Printer", "Ink-jet Printer", 10);
        printers[1] = new Printer("Multi Function", "Laser Printer", 10);
    }

    // iterates through all the printers in the array and prints them
    public void printPrinters(){
        for(int i = 0; i < this.printers.length; i++){
            System.out.println("Printer (" + (i + 1)  + ") Type: Printer " + this.printers[i].toString());
        }
    }

    // iterates through all the computers in the array and prints them.
    public void printComputers(){
        for(int i = 0; i < this.computers.length; i++){
            System.out.println("Computer (" + (i + 1)  + ") Type: Computer " + this.computers[i].toString());
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
