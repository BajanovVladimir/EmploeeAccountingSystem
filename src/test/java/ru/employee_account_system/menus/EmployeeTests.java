package ru.employee_account_system.menus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.employee_account_system.employees.Employee;
import ru.employee_account_system.employees.Person;

public class EmployeeTests {
    @Test
    public  void test_that_Employee_is_created(){
        Person pers1 = new Person(new Person.Name("Владимиров", "Владимир", "Васильевич"),"12.03.1981", Person.Gender.MEN);
        Employee employee1 = new Employee(pers1,"13.01.2023","Бухгалтерия","Бухгалтер");
        pers1.setPhoneNumber("+79876543456");
        Assertions.assertEquals("Владимиров",employee1.getLastName());
    }
    @Test
    public  void test_that_Employee_toString_is_corrected(){
        Person pers1 = new Person(new Person.Name("Владимиров", "Владимир", "Васильевич"),"12.03.1981", Person.Gender.MEN);
        Employee employee1 = new Employee(pers1,"13.01.2003","Бухгалтерия","Бухгалтер");
        pers1.setPhoneNumber("+79876543456");
        Assertions.assertEquals("Владимиров Владимир Васильевич\n"+
                                        "пол: мужской\n"+
                                        "дата рождения: 12.03.1981\n"+
                                        "телефон: +79876543456\n"+
                                        "отдел: Бухгалтерия\n"+
                                        "должность: Бухгалтер\n"+
                                        "дата приема на работу: 13.01.2003",employee1.toString());
    }
}
