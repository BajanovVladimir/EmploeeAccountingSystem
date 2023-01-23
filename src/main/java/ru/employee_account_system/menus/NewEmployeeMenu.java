package ru.employee_account_system.menus;

import ru.employee_account_system.constants.Constants;
import ru.employee_account_system.employees.Employee;
import ru.employee_account_system.employees.Person;

import java.util.Scanner;

public class NewEmployeeMenu {
    public static void isNewNameMenu(){
        while (true) {
            System.out.print("фамилия:");
            Scanner in = new Scanner(System.in);
            String lastName = in.next();
            System.out.print("\nимя: ");
            String firstName = in.next();
            System.out.print("\nотчество: ");
            String patronymic = in.next();
            System.out.println("\nпол: ");
            System.out.println("м - мужской\n ж - женский");
            System.out.print("\n");
            String gender = in.next();
            System.out.println("номер телефона");
            System.out.print("\n");
            String phoneNumber = in.next();
            System.out.println("для сохранения данных  введите любой символ");
            System.out.println("esc - для выхода в главное меню");
            String action = in.next();
            if(action.equals(Constants.ESC)){
                break;
            } else {
                Person.Gender personGender = isGender(gender);
                Person.Name name = new Person.Name(lastName, firstName, patronymic);
                Person person = new Person(name,"12.03.1985",personGender);
                Employee employee = new Employee(person,"13.14.1981","Бухгалтерия","Бухгалтер",54000);
                System.out.println(employee.toString());
                String str = in.next();
                break;
            }
        }
    }
    private static Person.Gender  isGender(String gender){
        switch (gender){
            case "м": return Person.Gender.MEN;
            case "ж": return Person.Gender.WOMEN;
        }
        return null;
    }
}
