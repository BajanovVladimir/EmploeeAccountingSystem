package ru.employee_account_system.menus;

import ru.employee_account_system.access.Access;
import ru.employee_account_system.constants.Constants;
import ru.employee_account_system.utils.ListUtils;
import ru.employee_account_system.utils.MenuUtils;

import java.util.Scanner;

public class UserMenu {

    public static void userMenuPrint(Access accessList) {
        while (true) {
            MenuUtils.printSeparator("-");
            MenuUtils.printSeparator("|");
            MenuUtils.printSeparator("-");
            Scanner in = new Scanner(System.in);
            System.out.println("выбирете действие:");
            System.out.println();
            System.out.println("1 - создать пользователя");
            System.out.println("2 - сменить пароль");
            System.out.println("3 - удалить пользователя");
            System.out.println("4 - вывести пользователей на экран");
            System.out.println("esc - для выхода ");
            String action = in.next();
            if (!action.equals(Constants.ESC)) {
                isAction(action, accessList);
            }
            break;
        }
    }

    private static void isAction(String action, Access accessList) {
        switch (action) {
            case "1" -> addUserMenu(accessList);
            case "2" -> changePasswordMenu(accessList);
            case "3" -> removeUserMenu(accessList);
            case "4" -> {
                    ListUtils.printMap(accessList.getAccessMap(), System.out);
                    Scanner in = new Scanner(System.in);
                    System.out.print("для продолжения введите любой символ:  ");
                    String act = in.next();
                    System.out.println();
                }
        }
    }

    public static Access.AccessType setAccessType(String accessType) {
        switch (accessType) {
            case "1" -> {
                return Access.AccessType.ADMIN;
            }
            case "2" -> {
                return Access.AccessType.OPERATOR;
            }
            case "3" -> {
                return Access.AccessType.USER;
            }
        }
        return null;
    }

    public static void removeUserMenu(Access accessList) {
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("удаление пользователя(для выхода из меню введите esc)\n введите пользователя: ");
            String login = in.next();
            if (login.equals(Constants.ESC)) {
                break;
            }
            System.out.println();
            if (accessList.userIsFound(login)) {
                System.out.println("пользователь найден. удалить пользователя?");
                System.out.println("да - удалить");
                System.out.println("любой символ - отменить удаление");
                String action = in.next();
                if ("да".equals(action)) {
                    accessList.removeUser(login);
                    System.out.println("пользователь удален!");
                }
                break;
            } else {
                System.out.println("Пользователь не найден.  Попробуйте снова!");
            }
        }
    }

    public static void changePasswordMenu(Access accessList){
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.print("изменить пароль (для выхода из меню введите esc)\n введите пользователя: ");
            String login = in.next();
            if (login.equals(Constants.ESC)) {
                break;
            }
            System.out.println();
            if (accessList.userIsFound(login)) {
                System.out.println("пользователь найден. изменить пароль?");
                System.out.println("да - изменить");
                System.out.println("любой символ - отменить изменение");
                String action = in.next();
                if ("да".equals(action)) {
                    System.out.print("Введите новый пароль: ");
                    String newPassword = in.next();
                    accessList.changeUserPassword(login,newPassword);
                    System.out.println("пароль изменен!");
                }
                break;
            } else {
                System.out.println("Пользователь не найден.  Попробуйте снова!");
            }
        }
    }

    public static void addUserMenu(Access accessList) {
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
        System.out.print("\n введите логин: ");
        String login = in.next();
        System.out.print("\n введите пароль: ");
        String password = in.next();
        while (true) {
            System.out.print("\n повторите пароль: ");
            String repeatPassword = in.next();
            if (password.equals(repeatPassword)) {
                accessList.addUser(login, password, type);
                break;
            }
        }
    }
}
