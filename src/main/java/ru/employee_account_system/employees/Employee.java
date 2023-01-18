package ru.employee_account_system.employees;

public class Employee extends Person {
    private final String dateOfEmployement;
    private String department;
    private  String position;

    public Employee(Name personName, String dateOfBirth, Gender gender,String dateOfEmployement) {
        super(personName, dateOfBirth, gender);
        this.dateOfEmployement = dateOfEmployement;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
