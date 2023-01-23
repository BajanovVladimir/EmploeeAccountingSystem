package ru.employee_account_system.organization;

import ru.employee_account_system.employees.Employee;

import java.util.HashMap;
import java.util.Map;

public class Department {
    public static class Position {
        private final String nameOfPosition;
        private Position chief;

        public Position(String nameOfPosition, Position chief) {
            this.nameOfPosition = nameOfPosition;
            this.chief = chief;
        }
        public Position(String nameOfPosition) {
            this.nameOfPosition = nameOfPosition;
            this.chief = null;
        }

        public String getNameOfPosition() {
            return nameOfPosition;
        }

        public Position getChief() {
            return this.chief;
        }
    }//End Position

    private String nameOfDepartment;

    private Department preChief;

    private Map<Employee, Position> departmentEmployees = new HashMap<>();
    private Map<Position, Integer> departmentPositions = new HashMap<>();

    public Department(String nameOfDepartment){
        this.nameOfDepartment = nameOfDepartment;
        this.preChief = null;
    }
    public Department(String nameOfDepartment, Department preChief){
        this.nameOfDepartment = nameOfDepartment;
        this.preChief = preChief;
    }



    public Department getPreChief() {
        return preChief;
    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }

    public void setPreChief(Department preChief) {
        this.preChief = preChief;
    }

    public Map<Position, Integer> getDepartmentPositions() {
        return departmentPositions;
    }

    public void createDepartmentPosition(Position position, int numberOfPlace) {
        departmentPositions.put(position, numberOfPlace);
    }

}
