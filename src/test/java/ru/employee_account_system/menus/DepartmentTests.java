package ru.employee_account_system.menus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.employee_account_system.employees.Employee;
import ru.employee_account_system.employees.Person;
import ru.employee_account_system.organization.Department;
import ru.employee_account_system.organization.Organization;

public class DepartmentTests {
    @Test
    public  void test() {
        Organization.Position pos1 = new Organization.Position("бухгалтер", 100000);
        Person pers1 = new Person(new Person.Name("Петров", "Петр", "Александрович"), "12.03.1985", Person.Gender.MEN);
        Person pers2 = new Person(new Person.Name("Сидорова", "Ольга", "Петровна"), "15.05.1987", Person.Gender.WOMEN);
        Employee emp1 = new Employee(pers1, "01.02.2022", "Бухгалтерия", "бухгалтер");
        Employee emp2 = new Employee(pers2, "01.02.2022", "Бухгалтерия", "бухгалтер");
        Department dep1 = new Department();
        dep1.addPosition(pos1,emp1);
         Organization.Position pos = dep1.getPosition(emp1);
        Assertions.assertEquals(100000,pos.getPay());
    }

}
