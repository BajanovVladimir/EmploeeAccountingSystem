package ru.employee_account_system.menus;

import ru.employee_account_system.access.Access;
import ru.employee_account_system.employees.Employee;
import ru.employee_account_system.employees.Person;
import ru.employee_account_system.organization.Department;
import ru.employee_account_system.utils.ListUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Person.Name name = new Person.Name("Петров", "Алексей", "Васильевич");
        String phoneNumber = "+79873456543";
        String dateOfBirth = "12.03.1987";
        Person per = new Person(name,dateOfBirth, Person.Gender.MEN);
        per.setPhoneNumber(phoneNumber);
        Employee emp = new Employee(per,"12.03.2006","Бухгалтерия", "Бухгалтер",53000);
        System.out.println(emp.toString());
        Access.AccessType admin = Access.AccessType.ADMIN;
        System.out.println(admin);
        Scanner in = new Scanner(System.in);
        Access access = new Access();
        access.addUser("admin","admin",Access.AccessType.ADMIN);
        Department department = new Department("Отдел1");
        System.out.println(department.getNameOfDepartment());
        Department.Position position1 = new Department.Position("Главный инженер");
        Department department1 = new Department("Отдел главного инженера");
        Department.Position position2 = new Department.Position("инженер");
        Department department2 = new Department("Отдел разработки",department1);
        department1.createDepartmentPosition(position1,1);
        department2.createDepartmentPosition(position2,2);
        Department dep = department2.getPreChief();

        System.out.println(dep.getNameOfDepartment());
    }
}
