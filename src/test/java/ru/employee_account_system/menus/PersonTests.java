package ru.employee_account_system.menus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.employee_account_system.employees.Person;

public class PersonTests {
    @Test
    public void test_that_person_is_created(){
        Person personOne = new Person(new Person.Name("Иванов","Иван","Иванович"),"07.01.1981", Person.Gender.MEN);
        Assertions.assertEquals("Иванов", personOne.getLastName());
        Assertions.assertEquals("Иван", personOne.getFirstName());
        Assertions.assertEquals("Иванович", personOne.getPatronymic());
    }
    @Test
    public void test_that_phoneNumber_is_set(){
        Person personOne = new Person(new Person.Name("Иванов","Иван","Иванович"),"07.01.1981", Person.Gender.MEN);
        personOne.setPhoneNumber("+79868754567");
        Assertions.assertEquals("+79868754567", personOne.getPhoneNumber());
    }
}
