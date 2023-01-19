package ru.employee_account_system.menus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.employee_account_system.employees.Person;

public class PersonTests {
    @Test
    public void test_that_person_is_created(){
        Person personOne = new Person(new Person.Name("Сидоров","Василий","Константинович"),"07.01.1981", Person.Gender.MEN);
        Assertions.assertEquals("Сидоров", personOne.getLastName());
        Assertions.assertEquals("Василий", personOne.getFirstName());
        Assertions.assertEquals("Константинович", personOne.getPatronymic());
    }
    @Test
    public void test_that_phoneNumber_is_set(){
        Person personOne = new Person(new Person.Name("Петров","Константин","Владимирович"),"07.01.1981", Person.Gender.MEN);
        personOne.setPhoneNumber("+79868754567");
        Assertions.assertEquals("+79868754567", personOne.getPhoneNumber());
    }
    @Test
    public void test_that_toString_is_corrected(){
        Person.Name name = new Person.Name("Петров","Константин","Владимирович");
        Person personOne = new Person(name,"07.01.1981", Person.Gender.MEN);
        Assertions.assertEquals("Петров Константин Владимирович\n", name.toString());
        Assertions.assertEquals("Петров Константин Владимирович\n" +
                                        "пол: мужской\n" +
                                        "дата рождения: 07.01.1981\n"+
                                         "телефон: ",personOne.toString());
    }
}
