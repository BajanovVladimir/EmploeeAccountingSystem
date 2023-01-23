package ru.employee_account_system.menus;

import ru.employee_account_system.constants.Constants;
import ru.employee_account_system.utils.MenuUtils;

import java.util.Scanner;

public class EmployeesMenu {
    public static void isEmployeeMenuPrint() {

        while (true) {
            MenuUtils.printSeparator("-");
            MenuUtils.printSeparator("|");
            MenuUtils.printSeparator("-");
            System.out.println("выбирите действие:");
            System.out.println("1 - задать нового сотрудника");
            System.out.println("2 - редактировать данные");
            System.out.println("esc - для выхода в основное меню");
            Scanner in = new Scanner(System.in);
            System.out.print("\n");
            String action = in.next();
            if (action.equals(Constants.ESC)) {
                break;
            }else{
               int actionInt =  MenuUtils.stringToInt(action);
               getNextMenu(actionInt);
            }
        }
    }
    private static void getNextMenu(int menu){
        switch (menu){
            case 1: {
                NewEmployeeMenu.isNewNameMenu();
                return;
            }
            case 2: {
                System.out.println("выбрано меню 2");
            }
            break;
        }
    }

}
