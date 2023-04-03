package main.utils;

import java.util.Scanner;

public class MenuManagerEmployee implements IMenuManager{

    private static MenuManagerEmployee employeeMenu = null;

    public int menuItem(){
        Scanner sel = new Scanner(System.in);

        System.out.println("1) New Computer");
        System.out.println("2) New Printer");
        System.out.println("3) New Purchase");
        System.out.println("4) Exit");
        System.out.print("Select one:");
        int choice = Integer.parseInt(sel.nextLine());
        System.out.println("Your choice:"+choice);
        return choice;
    }

    public static MenuManagerEmployee getInstance(){
        MenuManagerEmployee newEmployeeMenu = new MenuManagerEmployee();
        if (newEmployeeMenu == null){
            employeeMenu = newEmployeeMenu;
        }
        return newEmployeeMenu;
    }
}
