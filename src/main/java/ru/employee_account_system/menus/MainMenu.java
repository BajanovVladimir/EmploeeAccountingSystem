package ru.employee_account_system.menus;

import ru.employee_account_system.access.Access;
import ru.employee_account_system.constants.Constants;
import ru.employee_account_system.organization.Organization;
import ru.employee_account_system.utils.MenuUtils;

import java.util.Scanner;

public class MainMenu {
    public static void isMainMenuPrint(Organization organization,Access.AccessType accessType){
        Boolean exit = false;
        while (!exit){
            MenuUtils.printSeparator("-");
            MenuUtils.printSeparator("|");
            MenuUtils.printSeparator("-");
            Scanner in = new Scanner(System.in);
            System.out.println("выбирете действие:");
            System.out.println();
            System.out.println("1 - сотрудники");
            System.out.println("2 - ");
            if(Access.AccessType.ADMIN.name().equals(accessType.name())) {
                System.out.println("3 - пользователи");
            }
            System.out.println("4 - сменить пользователя");
            System.out.println("esc - для выхода ");
            String action = in.next();
            if(action.equals(Constants.ESC) || action.equals("4")){
                exit = true;
            }else {
                int menuInt = MenuUtils.stringToInt(action);
                getNextMenu(menuInt, organization.getAccessMap());
            }
        }

    }
    private static void getNextMenu(int menu,Access accessList){
        switch (menu){
            case 1:{
                EmployeesMenu.isEmployeeMenuPrint();
                break;
            }

            case 2:{
                break;
            }
            case 3: {
                UserMenu.userMenuPrint(accessList);
                break;
            }
            default:break;
        }
    }

}
