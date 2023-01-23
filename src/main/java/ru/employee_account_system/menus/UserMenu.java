package ru.employee_account_system.menus;

import ru.employee_account_system.access.Access;
import ru.employee_account_system.constants.Constants;
import ru.employee_account_system.utils.ListUtils;

import java.util.Scanner;

public class UserMenu {

    public static void userMenuPrint(Access accessList) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println("Выбирете действие:");
            System.out.println();
            System.out.println("1 - создать пользователя");
            System.out.println("2 - сменить пароль");
            System.out.println("3 - вывести пользователей на экран");
            System.out.println("esc - для выхода ");
            String action = in.next();
            if(action.equals(Constants.ESC)){
                break;
            }else {
                isAction(action,accessList);
                break;
            }
        }
    }
    private static void isAction(String action,Access accessList){
            switch (action){
                case "1": {
                    addUserMenu(accessList);
                    break;
                }
                case "2":
                case "3": {
                    ListUtils.printMap(accessList.getAccessMap(), System.out);
                    break;
                }
        }
    }
    public static Access.AccessType setAccessType(String accessType){
            switch (accessType) {
                case "1": {
                    return Access.AccessType.ADMIN;
                }
                case "2": {
                    return Access.AccessType.OPERATOR;
                }
                case "3": {
                    return Access.AccessType.USER;
                }
            }
            return null;
    }
    public static  void addUserMenu(Access accessList) {
        Scanner in = new Scanner(System.in);
        String accessType;
        Access.AccessType type;
        do {
            System.out.println("\n Выбирите права доступа: ");
            System.out.println("1 - администратор");
            System.out.println("2 - оператор");
            System.out.println("3 - пользователь");
            accessType = in.next();
            type = setAccessType(accessType);
        } while (type == null);
        System.out.print("\n Введите логин: ");
        String login= in.next();
        System.out.print("\n Введите пароль: ");
        String password= in.next();
        while(true) {
            System.out.print("\n Повторите пароль: ");
            String repeatPassword = in.next();
            if(password.equals(repeatPassword)){
                accessList.addUser(login,password,type);
                break;
            }
        }

    }
}
