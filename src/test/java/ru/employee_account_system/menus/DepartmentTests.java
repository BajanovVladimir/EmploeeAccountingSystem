package ru.employee_account_system.menus;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.employee_account_system.organization.Department;
import ru.employee_account_system.organization.Organization;

public class DepartmentTests {
    @Test
    public  void test_that_department_is_created() {
        Department.Position position = new Department.Position("инженер");
        Department department = new Department("Отдел разработки");
        department.createDepartmentPosition(position,2);
        Assertions.assertEquals(1,department.getDepartmentPositions().size());
        Assertions.assertTrue(department.getDepartmentPositions().containsKey(position));
    }
    @Test
    public  void test_that_department_is_() {
        Department.Position position1 = new Department.Position("Главный инженер");
        Department department1 = new Department("Отдел главного инженера");
        Department.Position position2 = new Department.Position("инженер",position1 );
        Department department2 = new Department("Отдел разработки",department1);
        department1.createDepartmentPosition(position1,1);
        department2.createDepartmentPosition(position2,2);
        Assertions.assertEquals("Отдел главного инженера", department2.getPreChief().getNameOfDepartment());
    }

}
