import java.util.Scanner;

public class BazarDriver {
    public static void main(String[] args) {
        Store newStore = new Store();

        int selection;
        do {
            selection = MenuInput.menuItem();
            switch (selection) {
                case 1:
                    newStore.createComputers();
                    break;
                case 2:
                    newStore.createPrinters();
                    break;
                case 3:
                    newStore.printComputers();
                    break;
                case 4:
                    newStore.printPrinters();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (selection != 5);
    }


}
