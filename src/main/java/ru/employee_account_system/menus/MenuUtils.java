package ru.employee_account_system.menus;
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
}
