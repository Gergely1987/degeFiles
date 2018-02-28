package formatlocaleregexp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpValidator {


    public boolean validateEmail(String email)throws IllegalArgumentException{

        if(email==null || email.trim().isEmpty()){
            throw new IllegalArgumentException("Empty string");
        }
        boolean valid=false;

        if(email.matches("([a-zA-Z0-9_\\.]*)@{1}(.*)")){
            valid=true;
        }
        return valid;
    }

    public boolean validateAcademicYear(String academicYear){

        if(academicYear==null || academicYear.trim().isEmpty()){
            throw new IllegalArgumentException("Empty string");
        }
        boolean valid=false;
        Pattern patter=Pattern.compile("(((^19)[8-9][0-9])|((^20)[0-1][0-9]))-(((19)[8-9][0-9])|((20)[0-1][0-9]))");
        Matcher m=patter.matcher(academicYear);
        if(m.matches()){
            valid=true;
        }

        String a="20 almaafaavavaa Bele szep fej kotta 20";
        if(a.matches("^\\d{2}[a-zA-Z\\s].[0-9]{2}$")){
            System.out.println("yess");
        }else {
            System.out.println("noooo");
        }

        return valid;

    }
    public boolean validateYearString(String yearString){
        boolean valid=false;
        if(yearString==null || yearString.trim().isEmpty()){
            throw new IllegalArgumentException("Empty string passed!");
        }

        if(yearString.matches("^[2][0][0-1][0-9]")){
            valid=true;
        }
        return valid;
    }

}
