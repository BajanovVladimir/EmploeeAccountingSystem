package ru.employee_account_system.menus;

import ru.employee_account_system.constants.Constants;

import java.util.Scanner;

public class EmployeesMenu {
    public static void isEmployeeMenuPrint() {

        while (true) {
            System.out.println("Выбирите действие:");
            System.out.println("1 - Задать нового сотрудника");
            System.out.println("2 - Редактировать сотрудника");
            System.out.println("esc - Для выхода в основное меню");
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