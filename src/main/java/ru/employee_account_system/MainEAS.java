package ru.employee_account_system;

import ru.employee_account_system.employees.Employee;
import ru.employee_account_system.employees.Person;
import ru.employee_account_system.menus.AccessMenu;

import java.time.LocalDate;

public class MainEAS {
    public static void main(String[] args) {
        LocalDate dayOfBirth = LocalDate.of(1991,3,12);
        AccessMenu.inLogin();

    }
}
