package ru.employee_account_system.menus;

import ru.employee_account_system.constants.Constants;
import ru.employee_account_system.employees.Employee;
import ru.employee_account_system.employees.Person;
import ru.employee_account_system.utils.MenuUtils;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class NewEmployeeMenu {
    public static void isNewNameMenu(){
        while (true) {
            MenuUtils.printSeparator("-");
            MenuUtils.printSeparator("|");
            MenuUtils.printSeparator("-");
            System.out.print("фамилия:");
            Scanner in = new Scanner(System.in);
            String lastName = in.next();
            System.out.print("\nимя: ");
            String firstName = in.next();
            System.out.print("\nотчество: ");
            String patronymic = in.next();
            System.out.println("\nпол: ");
            System.out.println("м - мужской\n ж - женский");
            String gender = in.next();
            System.out.print("\nдата рождения");
            String dataOfBirth = in.next();
            System.out.print("\nномер телефона");
            String phoneNumber = in.next();
            System.out.println("\nдата принятия на работу");
            String dataOfEmployment = in.next();
            System.out.println("для сохранения данных  введите любой символ");
            System.out.println("esc - для выхода в главное меню");
            String action = in.next();
            if(action.equals(Constants.ESC)){
                break;
            } else {
                Person.Gender personGender = isGender(gender);
                Person.Name name = new Person.Name(lastName, firstName, patronymic);
                Person person = new Person(name,dataOfBirth,personGender);
                Employee employee = new Employee(person,dataOfEmployment,"Бухгалтерия","Бухгалтер",54000);
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
