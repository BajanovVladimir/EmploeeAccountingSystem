package ru.employee_account_system.menus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.employee_account_system.access.Access;

class AccessTest {
    @Test
    public void test_that_login_and_password_are_added() {
        Access access = new Access();
        boolean ac = access.addAccess("login123", "pasword123");
        Assertions.assertTrue(ac);
        Assertions.assertEquals("pasword123",access.getPassword("login123"));
    }
    @Test
    public void test_that_login_and_password_are_not_added() {
        Access access = new Access();
        access.addAccess("login123", "pasword123");
        boolean ac = access.addAccess("login123", "pasword123");
        Assertions.assertFalse(ac);
    }
    @Test
    public void test_that_login_is_correct() {
        Access access = new Access();
        access.addAccess("login1", "pasword1");
        access.addAccess("login2", "pasword2");
        access.addAccess("login3", "pasword3");
        access.addAccess("login4", "pasword4");
       boolean ac = access.loginIsCorrect("login3");
        Assertions.assertTrue(ac);
    }
    @Test
    public void test_that_login_is_not_correct() {
        Access access = new Access();
        access.addAccess("login1", "pasword1");
        access.addAccess("login2", "pasword2");
        access.addAccess("login3", "pasword3");
        access.addAccess("login4", "pasword4");
       boolean ac = access.loginIsCorrect("login5");
        Assertions.assertFalse(ac);
    }
    @Test
    public void test_that_password_is_correct() {
        Access access = new Access();
        access.addAccess("login1", "pasword1");
        access.addAccess("login2", "pasword2");
        access.addAccess("login3", "pasword3");
        access.addAccess("login4", "pasword4");
       boolean ac = access.passwordIsCorrect("login3","pasword3");
        Assertions.assertTrue(ac);
    }
    @Test
    public void test_that_password_is_not_correct() {
        Access access = new Access();
        access.addAccess("login1", "pasword1");
        access.addAccess("login2", "pasword2");
        access.addAccess("login3", "pasword3");
        access.addAccess("login4", "pasword4");
        boolean ac = access.passwordIsCorrect("login3","password4");
        Assertions.assertFalse(ac);
    }
    @Test
    public void test_that_access_is_allowed() {
        Access access = new Access();
        access.addAccess("login1", "pasword1");
        access.addAccess("login2", "pasword2");
        access.addAccess("login3", "pasword3");
        access.addAccess("login4", "pasword4");
        boolean ac = access.isAccess("login3","pasword3");
        Assertions.assertTrue(ac);
    }
    @Test
    public void test_that_access_is_not_allowed() {
        Access access = new Access();
        access.addAccess("login1", "pasword1");
        access.addAccess("login2", "pasword2");
        access.addAccess("login3", "pasword3");
        access.addAccess("login4", "pasword4");
        boolean ac = access.isAccess("login3","");
        Assertions.assertFalse(ac);
    }
}