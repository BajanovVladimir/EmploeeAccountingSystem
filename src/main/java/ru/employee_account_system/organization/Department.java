package ru.employee_account_system.organization;
import ru.employee_account_system.employees.Employee;

import java.util.HashMap;
import java.util.Map;

public class Department {
   private  Employee chief;
    Map< Employee, Organization.Position> departmentsMap = new HashMap<>();

    public void setChief(Employee chief){
        this.chief = chief;
    }
    public void addPosition(Organization.Position position, Employee employee){
        departmentsMap.putIfAbsent(employee,position);
    }
    public Organization.Position getPosition(Employee employee){
        return this.departmentsMap.get(employee);
    }


}
