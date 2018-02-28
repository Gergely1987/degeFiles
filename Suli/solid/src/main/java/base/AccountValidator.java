package base;

public class AccountValidator implements Validator {

    @Override
    public boolean isValid(String username) {
       if(username!=null && username.length()>5 && !username.contains(" ")){
           return true;
       }
       return false;
    }
}
