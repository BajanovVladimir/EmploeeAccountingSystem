package ru.employee_account_system.organization;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Organization {
    Map<Position,Integer> department = new HashMap<>();
    Set<String> departmentSet = new HashSet<>();
    public void addDepartment(String department){
        departmentSet.add(department);
    }
    public static class Position{
        private final String nameOfPosition;
        private double pay;

        public Position(String nameOfPosition, double pay) {
            this.nameOfPosition = nameOfPosition;
            this.pay = pay;
        }

        public String getNameOfPosition() {
            return nameOfPosition;
        }

        public double getPay() {
            return pay;
        }

        public void setPay(double pay) {
            this.pay = pay;
        }
    }

}
