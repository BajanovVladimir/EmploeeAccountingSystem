package ru.employee_account_system.menus;

import ru.employee_account_system.access.Access;

import java.util.Scanner;

public class AccessMenu {

   static final int numberOfElements = 90;

    public static void printSeparator(String separator){
        System.out.println();
        for(int i = 0; i < numberOfElements; i++){
            System.out.print(separator);
        }

    }
    public static void inLogin(){
        Access accessList = new Access();
       accessList.addUser("admin", "admin",Access.AccessType.ADMIN);
       accessList.addUser("operator","operator",Access.AccessType.OPERATOR);
        while (true) {
            printSeparator("-");
            printSeparator("|");
            Scanner in = new Scanner(System.in);
            System.out.print("\n Введите пользователя: ");
            String login = in.next();
            System.out.print("\n Введите пароль: ");
            String password = in.next();
            if(accessList.isAccess(login,password)){
                break;
            }
            System.out.println("Неверный пользователь или пароль! Попробуйте еще раз!");
        }
    }
}
