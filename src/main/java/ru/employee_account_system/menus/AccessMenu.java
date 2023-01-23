package ru.employee_account_system.menus;

import ru.employee_account_system.access.Access;
import ru.employee_account_system.constants.Constants;
import ru.employee_account_system.organization.Organization;
import ru.employee_account_system.utils.MenuUtils;

import java.util.Scanner;

public class AccessMenu {

    public static void inLogin(Organization organization) {
        Access accessList = organization.getAccessMap();
        organization.getAccessMap().addUser("admin", "admin", Access.AccessType.ADMIN);
        organization.getAccessMap().addUser("operator", "operator", Access.AccessType.OPERATOR);
        String login;
        while (true) {
            MenuUtils.printSeparator("-");
            MenuUtils.printSeparator("|");
            MenuUtils.printSeparator("-");
            System.out.println(" \nВедите пользователя и пароль( для выхода из программы введите esc)");
            Scanner in = new Scanner(System.in);
            System.out.print("\n Введите пользователя: ");
            login = in.next();
            if(login.equals(Constants.ESC)){
                break;
            }
            System.out.print("\n Введите пароль: ");
            String password = in.next();
            if(password.equals(Constants.ESC)){
                break;
            }
            try {
                 Access.AccessType accessType = accessList.getUserAccessType(login,password);
                 MainMenu.isMainMenuPrint(organization,accessType);
            } catch (IllegalArgumentException e){
                System.out.println("Неверный пользователь или пароль! Попробуйте еще раз!");
            }
        }
    }
}
