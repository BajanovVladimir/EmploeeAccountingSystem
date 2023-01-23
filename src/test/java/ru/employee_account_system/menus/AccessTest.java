package ru.employee_account_system.menus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.employee_account_system.access.Access;

class AccessTest {
    @Test
    public void test_that_new_user_is_added() {
        Access access = new Access();
        boolean ac = access.addUser("login123", "pasword123",Access.AccessType.ADMIN);
        Assertions.assertTrue(ac);
        Assertions.assertEquals("pasword123",access.getUser("login123").getPassword());
    }
    @Test
    public void test_that_new_user_is_not_added() {
        Access access = new Access();
        access.addUser("login123", "pasword123", Access.AccessType.ADMIN);
        boolean ac = access.addUser("login123", "pasword123",Access.AccessType.OPERATOR);
        Assertions.assertFalse(ac);
    }
    @Test
    public void test_that_password_is_changed_if_user_is_found() {
        Access access = new Access();
        access.addUser("login123", "pasword123", Access.AccessType.ADMIN);
        boolean ac = access.changeUserPassword("login123", "pasword555");
        Assertions.assertTrue(ac);
        Assertions.assertEquals("pasword555",access.getUser("login123").getPassword());
    }
    @Test
    public void test_that_method_is_false_if_user_is_not_found() {
        Access access = new Access();
        access.addUser("login123", "pasword123", Access.AccessType.ADMIN);
        boolean ac = access.changeUserPassword("login", "pasword555");
        Assertions.assertFalse(ac);
    }
    @Test
    public void test_that_accessType_is_changed_if_user_is_found() {
        Access access = new Access();
        access.addUser("login123", "pasword123", Access.AccessType.ADMIN);
        boolean ac = access.changeUserAccessType("login123", Access.AccessType.OPERATOR);
        Assertions.assertTrue(ac);
        Assertions.assertEquals(Access.AccessType.OPERATOR,access.getUser("login123").getAccessType());
    }
    @Test
    public void test_that_changeUserAccessType_is_false_if_user_is_not_found() {
        Access access = new Access();
        access.addUser("login123", "pasword123", Access.AccessType.ADMIN);
        boolean ac = access.changeUserAccessType("login", Access.AccessType.OPERATOR);
        Assertions.assertFalse(ac);
    }
    @Test
    public void test_that_user_is_found() {
        Access access = new Access();
        access.addUser("login123", "pasword123", Access.AccessType.ADMIN);
        Assertions.assertTrue(access.userIsFound("login123"));
    }
    @Test
    public void test_that_user_is_not_found() {
        Access access = new Access();
        access.addUser("login123", "pasword123", Access.AccessType.ADMIN);
        Assertions.assertFalse(access.userIsFound("login143"));
    }
    @Test
    public void test_that_login_is_correct() {
        Access access = new Access();
        access.addUser("login1", "pasword1",Access.AccessType.OPERATOR);
        access.addUser("login2", "pasword2",Access.AccessType.OPERATOR);
        access.addUser("login3", "pasword3",Access.AccessType.ADMIN);
       boolean ac = access.loginIsCorrect("login3");
        Assertions.assertTrue(ac);
    }
    @Test
    public void test_that_login_is_not_correct() {
        Access access = new Access();
        access.addUser("login1", "pasword1",Access.AccessType.OPERATOR);
        access.addUser("login2", "pasword2",Access.AccessType.OPERATOR);
        access.addUser("login3", "pasword3",Access.AccessType.ADMIN);
        access.addUser("login4", "pasword4",Access.AccessType.OPERATOR);
       boolean ac = access.loginIsCorrect("login5");
        Assertions.assertFalse(ac);
    }
    @Test
    public void test_that_password_is_correct() {
        Access access = new Access();
        access.addUser("login1", "pasword1",Access.AccessType.OPERATOR);
        access.addUser("login2", "pasword2",Access.AccessType.OPERATOR);
        access.addUser("login3", "pasword3",Access.AccessType.ADMIN);
        access.addUser("login4", "pasword4",Access.AccessType.OPERATOR);
        boolean ac = access.passwordIsCorrect("login3","pasword3");
        Assertions.assertTrue(ac);
    }
    @Test
    public void test_that_password_is_not_correct() {
        Access access = new Access();
        access.addUser("login1", "pasword1",Access.AccessType.OPERATOR);
        access.addUser("login2", "pasword2",Access.AccessType.OPERATOR);
        access.addUser("login3", "pasword3",Access.AccessType.ADMIN);
        access.addUser("login4", "pasword4",Access.AccessType.OPERATOR);
        boolean ac = access.passwordIsCorrect("login3","password4");
        Assertions.assertFalse(ac);
    }
    @Test
    public void test_that_access_is_allowed() {
        Access access = new Access();
        access.addUser("login1", "pasword1",Access.AccessType.OPERATOR);
        access.addUser("login2", "pasword2",Access.AccessType.OPERATOR);
        access.addUser("login3", "pasword3",Access.AccessType.ADMIN);
        access.addUser("login4", "pasword4",Access.AccessType.OPERATOR);
        boolean ac = access.isAccess("login3","pasword3");
        Assertions.assertTrue(ac);
    }
    @Test
    public void test_that_access_is_not_allowed() {
        Access access = new Access();
        access.addUser("login1", "pasword1",Access.AccessType.OPERATOR);
        access.addUser("login2", "pasword2",Access.AccessType.OPERATOR);
        access.addUser("login3", "pasword3",Access.AccessType.ADMIN);
        access.addUser("login4", "pasword4",Access.AccessType.OPERATOR);
        boolean ac = access.isAccess("login3","");
        Assertions.assertFalse(ac);
    }
    @Test
    public void test_that() {
        Access access = new Access();
        access.addUser("login1", "pasword1",Access.AccessType.OPERATOR);
        access.addUser("login2", "pasword2",Access.AccessType.OPERATOR);
        access.addUser("login3", "pasword3",Access.AccessType.ADMIN);
        access.addUser("login4", "pasword4",Access.AccessType.OPERATOR);
        Access.User user = access.getUser("login1");
        Assertions.assertEquals("pasword1", user.getPassword());
    }
    @Test
    public void test_that_throw_exception_when_user_is_not_found() {
        Access access = new Access();
        access.addUser("login1", "pasword1",Access.AccessType.OPERATOR);
        access.addUser("login2", "pasword2",Access.AccessType.OPERATOR);
        access.addUser("login3", "pasword3",Access.AccessType.ADMIN);
        access.addUser("login4", "pasword4",Access.AccessType.OPERATOR);
        Assertions.assertThrows(IllegalArgumentException.class, () ->  access.getUser("login5"));
    }
    @Test
    public void test_that_user_remove() {
        Access access = new Access();
        access.addUser("login1", "pasword1",Access.AccessType.OPERATOR);
        access.addUser("login2", "pasword2",Access.AccessType.OPERATOR);
        access.addUser("login3", "pasword3",Access.AccessType.ADMIN);
        access.addUser("login4", "pasword4",Access.AccessType.OPERATOR);
        Assertions.assertTrue(access.removeUser("login3"));
        Assertions.assertEquals(3,access.getAccessMap().size());
    }
    @Test
    public void test_that_is_false_when_user_is_not_found() {
        Access access = new Access();
        access.addUser("login1", "pasword1",Access.AccessType.OPERATOR);
        access.addUser("login2", "pasword2",Access.AccessType.OPERATOR);
        access.addUser("login3", "pasword3",Access.AccessType.ADMIN);
        access.addUser("login4", "pasword4",Access.AccessType.OPERATOR);
        Assertions.assertFalse(access.removeUser("login5"));
        Assertions.assertEquals(4,access.getAccessMap().size());
    }
}