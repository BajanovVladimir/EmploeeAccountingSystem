package ru.employee_account_system.organization;

import ru.employee_account_system.access.Access;

import java.util.*;

public class Organization {
   private Map<Position,Integer> department = new HashMap<>();
   private Access accessMap = new Access();
    List<String> departmentList = new LinkedList<>();
    public void addDepartment(String department){
        departmentList.add(department);
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

    public Map<Position, Integer> getDepartment() {
        return department;
    }

    public void setDepartment(Map<Position, Integer> department) {
        this.department = department;
    }

    public Access getAccessMap() {
        return accessMap;
    }

    public void setAccessMap(Access accessMap) {
        this.accessMap = accessMap;
    }
}
