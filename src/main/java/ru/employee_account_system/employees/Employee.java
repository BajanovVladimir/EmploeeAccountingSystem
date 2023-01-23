package ru.employee_account_system.employees;

public class Employee extends Person {
    private final String dateOfEmployment;
    private String department;
    private  String position;
    private final Person person;
    private  double pay;

    public Employee(Person person,String dateOfEmployement,String department,String position,double pay) {
        super(person.getPersonName(),person.getDateOfBirth(),person.getGender());
        this.person = person;
        this.dateOfEmployment = dateOfEmployement;
        this.department = department;
        this.position = position;
        this.pay = pay;
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

    @Override
    public String toString() {
        return this.person+"\n"
                + "отдел: " + this.department + "\n"
                + "должность: " +this.position + "\n"
                + "дата приема на работу: " + this.dateOfEmployment;
    }
}
