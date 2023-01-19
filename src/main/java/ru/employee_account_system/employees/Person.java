package ru.employee_account_system.employees;

import javax.xml.crypto.Data;

public class Person {
       public enum Gender{
           MEN("мужской"),
           WOMEN("женский");
           private final String name;
           Gender(String name){
               this.name = name;
           }
       }
       public static class Name{
           private  String lastName;
           private final String firstName;
           private final String patronymic;

           public Name(String lastName, String firstName, String patronymic) {
               this.lastName = lastName;
               this.firstName = firstName;
               this.patronymic = patronymic;
           }

           public String getLastName() {
               return lastName;
           }

           public String getFirstName() {
               return firstName;
           }

           public String getPatronymic() {
               return patronymic;
           }

           @Override
           public String toString() {
               return this.lastName +" "
                       + this.firstName +" "
                       + this.patronymic + "\n";
           }
       }
        private final Name personName;
        private final String dateOfBirth;
        private final Gender gender;

        private  String phoneNumber = "";
        public Person(Name personName,String dateOfBirth, Gender gender){
            this.personName = personName;
            this.dateOfBirth = dateOfBirth;
            this.gender = gender;
        }

        public String getLastName() {
            return this.personName.lastName;
        }

        public String getFirstName() {
            return this.personName.firstName;
        }

        public String getPatronymic() {
            return this.personName.patronymic;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

    public Name getPersonName() {
        return personName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return this.personName
                + "пол: "+ this.gender.name +"\n"
                + "дата рождения: "+ this.dateOfBirth+"\n"
                + "телефон: "+ this.phoneNumber;
    }
}
