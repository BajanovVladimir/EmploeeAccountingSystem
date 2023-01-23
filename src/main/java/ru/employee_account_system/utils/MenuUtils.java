package ru.employee_account_system.utils;
//надо будет доделать
public class MenuUtils {
    public static int stringToInt(String str){
        try{
            return Integer.parseInt(str);
        } catch (NumberFormatException e){
            System.out.println("Неверный формат команды");
        }
        return -1;
    }

    public static void printSeparator(String separator) {
        final int numberOfSeparatorsElements = 90;
        System.out.println();
        for (int i = 0; i < numberOfSeparatorsElements; i++) {
            System.out.print(separator);
        }
    }
}
