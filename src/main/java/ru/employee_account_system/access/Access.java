package ru.employee_account_system.access;

import java.util.HashMap;
import java.util.Map;

public class Access {

    public enum AccessType{
        ADMIN("aдминистратор"),
        OPERATOR("oператор"),
        USER("пользователь");

        AccessType(String accessType){
        }
    }
    public static class User{
        private final String login;
        private String password;
        private AccessType accessType;

         User(String login,String password,AccessType accessType){
             this.login = login;
             this.password = password;
             this.accessType = accessType;
        }

        public String getPassword() {
            return password;
        }

        public AccessType getAccessType() {
            return accessType;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public void setAccessType(AccessType accessType) {
            this.accessType = accessType;
        }

        @Override
        public String toString() {
            return "логин: " + this.login +
                    "  тип доступа: " + this.accessType;
        }
    }//end class User
    private final Map<String,User> accessMap = new HashMap<>();
    public Boolean accessMapIsEmpty(){
        return accessMap.size() == 0;
    }
    public Boolean userIsFound(String login){
        if(accessMap.containsKey(login)){
            return true;
        }
        return false;
    }

    public  Boolean addUser(String login, String password, AccessType accessType){
        User user = new User(login,password,accessType);
        if(accessMapIsEmpty()){
            accessMap.put(login,user);
            return true;
        } else{
            if(!userIsFound(login)){
                accessMap.put(login,user);
                return true;
            }
        }
        return false;
    }
    public Boolean removeUser(String login){
        if(userIsFound(login)){
            this.accessMap.remove(login);
            return true;
        }
        return  false;
    }
    public Boolean changeUserPassword(String login,String newPassword){
        if(!userIsFound(login)){
            return  false;
        }
        User user = this.accessMap.get(login);
        user.setPassword(newPassword);
        return true;
    }
    public Boolean changeUserAccessType(String login,AccessType newAccessType){
        if(!userIsFound(login)){
            return  false;
        }
        User user = this.accessMap.get(login);
        user.setAccessType(newAccessType);
        return true;
    }

    public Boolean loginIsCorrect(String login){
        return accessMap.containsKey(login);
    }
    public Boolean passwordIsCorrect(String login,String password){
        User user = getUser(login);
        return user.password.equals(password);
    }
    public User getUser(String login) throws IllegalArgumentException{
        if(!userIsFound(login)) {
            throw new IllegalArgumentException();
        }
        return this.accessMap.get(login);
    }
    public AccessType getUserAccessType(String login, String password) throws IllegalArgumentException{
        if(!isAccess(login,password)) {
            throw new IllegalArgumentException();
        }
        User user = this.getUser(login);
        return user.accessType;
    }

    public Map<String, User> getAccessMap() {
        return accessMap;
    }

    public Boolean isAccess(String login, String password){
        return loginIsCorrect(login) && passwordIsCorrect(login, password);
    }

}
