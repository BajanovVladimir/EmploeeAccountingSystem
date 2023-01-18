package ru.employee_account_system.access;

import java.util.HashMap;
import java.util.Map;

public class Access {

    public enum AccessType{
        ADMIN('a'),
        OPERATOR('o');
        private final Character accessType;
        AccessType(Character accessType){
            this.accessType = accessType;
        }
    }
    public static class User{
        private String login;
        private String password;
        private Enum accessType;

         User(String login,String password,Enum accessType){
             this.login = login;
             this.password = password;
             this.accessType = accessType;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public Enum getAccessType() {
            return accessType;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setAccessType(Enum accessType) {
            this.accessType = accessType;
        }
    }
    private Map<String,User> accessMap = new HashMap<>();
    public Boolean accessMapIsEmpty(){
        return accessMap.size() == 0;
    }

    public  Boolean addUser(String login, String password, Enum accessType){
        User user = new User(login,password,accessType);
        if(accessMapIsEmpty()){
            accessMap.put(login,user);
            return true;
        } else{
            if(!accessMap.containsKey(login)){
                accessMap.put(login,user);
                return true;
            }
        }
        return false;
    }
    public Boolean loginIsCorrect(String login){
        return accessMap.containsKey(login);
    }
    public Boolean passwordIsCorrect(String login,String password){
        User user = getUser(login);
        return user.password.equals(password);
    }
    public User getUser(String login){
        return this.accessMap.get(login);
    }

    public Boolean isAccess(String login, String password){
        if(loginIsCorrect(login) && passwordIsCorrect(login,password)){
            return true;
        }
        return false;
    }
}
