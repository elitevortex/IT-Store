package main.utils;

import java.util.Scanner;

/**
 * The MenuManagerAdmin class which implements the IMenuManager interface, and it's respective methods
 *
 * @author Edward Chan 33095019
 * @version 1.0.0
 */
public class MenuManagerAdmin implements IMenuManager{
    /**
     * An admin menu manager, initialised as null to ensure that we only have a single manager per Store
     */
    private static MenuManagerAdmin adminMenu = null;

    /**
     * A method that prints all available operation options to the user
     * @return an integer that is inputted by the user
     */
    public int menuItem() {
        Scanner sel = new Scanner(System.in);

        System.out.println("1) New Computer");
        System.out.println("2) New Printer");
        System.out.println("3) New Purchase");
        System.out.println("4) List Computers");
        System.out.println("5) List Printers");
        System.out.println("6) List Purchases");
        System.out.println("7) Exit");
        System.out.print("Select one:");
        int choice = Integer.parseInt(sel.nextLine());
        System.out.println("Your choice:"+choice);
        return choice;
    }

    /**
     * A method that creates an instance of a menu manager
     * @return a MenuManagerAdmin instance
     */
    public static MenuManagerAdmin getInstance(){
        MenuManagerAdmin newAdmin = new MenuManagerAdmin();
        if (newAdmin == null){
            adminMenu = newAdmin;
        }
        return newAdmin;
    }
}
