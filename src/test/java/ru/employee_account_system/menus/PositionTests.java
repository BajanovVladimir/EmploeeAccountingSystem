package ru.employee_account_system.menus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.employee_account_system.organization.Organization;

public class PositionTests {
    @Test
    public void test_that_position_is_created(){
        Organization.Position position = new Organization.Position("Инженер",50000);
        Assertions.assertEquals(50000,position.getPay());
        Assertions.assertEquals("Инженер", position.getNameOfPosition());
    }
    @Test
    public void test_that_pay_is_set(){
        Organization.Position position = new Organization.Position("Инженер",50000);
        position.setPay(60500);
        Assertions.assertEquals(60500,position.getPay());

    }
}
