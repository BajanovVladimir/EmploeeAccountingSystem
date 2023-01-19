package ru.employee_account_system.menus;

import ru.employee_account_system.constants.Constants;

import java.util.Scanner;

public class MainMenu {
    public static void isMainMenuPrint(){
        Boolean exit = false;
        while (!exit){
            Scanner in = new Scanner(System.in);
            System.out.println("Выбирете действие:");
            System.out.println();
            System.out.println("1 - ");
            System.out.println("2 - ");
            System.out.println("3 - ");
            System.out.println("esc - для выхода ");
            String menu = in.next();
            if(menu.equals(Constants.ESC)){
                exit = true;
            }else {
                int menuInt = MenuUtils.stringToInt(menu);
                getNextMenu(menuInt);
            }
        }

    }
    private static void getNextMenu(int menu){
        switch (menu){
            case 1:
                EmployeesMenu.isEmployeeMenuPrint();
            case 2:
                System.out.println("выбрано меню 2");
        }
    }

}
