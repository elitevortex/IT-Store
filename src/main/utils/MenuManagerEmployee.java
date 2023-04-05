package main.utils;

import java.util.Scanner;

/**
 * The MenuManagerEmployee class which implements the IMenuManager interface, and it's respective methods
 *
 * @author Edward Chan 33095019
 * @version 1.0.0
 */
public class MenuManagerEmployee implements IMenuManager{
    /**
     * An employee menu manager, initialised as null to ensure that we only have a single manager per Store
     */
    private static MenuManagerEmployee employeeMenu = null;
    /**
     * A method that prints all available operation options to the user
     * @return an integer that is inputted by the user
     */
    public int menuItem(){
        Scanner sel = new Scanner(System.in);

        System.out.println("1) New Computer");
        System.out.println("2) New Printer");
        System.out.println("3) New Purchase");
        System.out.println("7) Exit");
        System.out.print("Select one:");
        int choice = Integer.parseInt(sel.nextLine());
        System.out.println("Your choice:"+choice);
        return choice;
    }

    /**
     * A method that creates an admin instance of a menu manager
     * @return a MenuManagerEmployee instance
     */
    public static MenuManagerEmployee getInstance(){
        MenuManagerEmployee newEmployeeMenu = new MenuManagerEmployee();
        if (newEmployeeMenu == null){
            employeeMenu = newEmployeeMenu;
        }
        return newEmployeeMenu;
    }
}
