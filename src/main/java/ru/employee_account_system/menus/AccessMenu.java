package ru.employee_account_system.menus;

import ru.employee_account_system.access.Access;
import ru.employee_account_system.organization.Organization;

import java.util.Scanner;

public class AccessMenu {

    static final int numberOfSeparatorsElements = 90;

    public static void printSeparator(String separator) {
        System.out.println();
        for (int i = 0; i < numberOfSeparatorsElements; i++) {
            System.out.print(separator);
        }

    }

    public static void inLogin(Organization organization) {
        Access accessList = organization.getAccessMap();
        organization.getAccessMap().addUser("admin", "admin", Access.AccessType.ADMIN);
        organization.getAccessMap().addUser("operator", "operator", Access.AccessType.OPERATOR);
        String login;
        while (true) {
            printSeparator("-");
            printSeparator("|");
            printSeparator("-");
            System.out.println(" \nВедите пользователя и пароль( для выхода из программы введите esc)");
            Scanner in = new Scanner(System.in);
            System.out.print("\n Введите пользователя: ");
            login = in.next();
            System.out.print("\n Введите пароль: ");
            String password = in.next();
            try {
                 Access.AccessType accessType = accessList.getUserAccessType(login,password);
                 MainMenu.isMainMenuPrint(organization,accessType);
            } catch (IllegalArgumentException e){
                System.out.println("Неверный пользователь или пароль! Попробуйте еще раз!");
            }
        }
    }
}
