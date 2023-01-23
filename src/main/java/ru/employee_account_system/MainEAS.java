package ru.employee_account_system;

import ru.employee_account_system.access.Access;
import ru.employee_account_system.menus.AccessMenu;
import ru.employee_account_system.menus.MainMenu;
import ru.employee_account_system.organization.Organization;

public class MainEAS {
    public static void main(String[] args) {
        Organization organization = new Organization();
        AccessMenu.inLogin(organization);
        MainMenu.isMainMenuPrint(organization);
    }
}
