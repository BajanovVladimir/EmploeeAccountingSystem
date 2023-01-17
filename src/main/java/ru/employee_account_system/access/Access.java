package ru.employee_account_system.access;

import java.util.HashMap;
import java.util.Map;

public class Access {
    private Map<String,String> accessMap = new HashMap<>();
    public Boolean accessMapIsEmpty(){
        return accessMap.size() == 0;
    }

    public  Boolean addAccess(String login, String password){
        if(accessMapIsEmpty()){
            accessMap.put(login,password);
            return true;
        } else{
            if(!accessMap.containsKey(login)){
                accessMap.put(login,password);
                return true;
            }
        }
        return false;
    }
    public Boolean loginIsCorrect(String login){
        return accessMap.containsKey(login);
    }
    public Boolean passwordIsCorrect(String login,String password){
        return accessMap.get(login).equals(password);
    }
    public String getPassword(String login){
        return this.accessMap.get(login);
    }

    public Boolean isAccess(String login, String password){
        if(loginIsCorrect(login) && passwordIsCorrect(login,password)){
            return true;
        }
        return false;
    }
}
