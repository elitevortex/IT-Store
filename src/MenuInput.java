import java.util.Scanner;

public class MenuInput {
    public static int menuItem() {
        Scanner sel = new Scanner(System.in);

        System.out.println("1) New Computer");
        System.out.println("2) New Printer");
        System.out.println("3) List Computers");
        System.out.println("4) List Printers");
        System.out.println("5) Exit");
        System.out.print("Select one:");
        int choice = Integer.parseInt(sel.nextLine());
        System.out.println("Your choice:"+choice);
        return choice;
    }
}
