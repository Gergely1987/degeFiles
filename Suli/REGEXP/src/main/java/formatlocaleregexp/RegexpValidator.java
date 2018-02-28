package formatlocaleregexp;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpValidator {


    public static void main(String[] args) {
        String line="kk 202";
        String email="decsics@gmail.com";

     //   [a-zA-Z \s]

        if(line.matches("\\D*([0-9]{3}).*")){
            System.out.println("has number");
        }else{
            System.out.println("cannot find num");
        }

        if (email.matches("([a-zA-Z 0-9]*)(@{1})([a-zA-Z]*)(\\.{1})([a-zA-Z]{2,4})")){
            System.out.println("valid email");
        }else{
            System.out.println("not valid this email");
        }


    String fromTo="2011-2015";
        if(fromTo.matches("((^[19]+[8-9]+[0-9])|(^[20]+[0-1]+[0-9]))-((^[19]+[8-9]+[0-9])|(^[20]+[0-1]+[0-9]))")){
            System.out.println("jo");
        }else{
            System.out.println("nem jó");
        }
    String date="2015";
        if(date.matches("^20\\d{2}$")){
            System.out.println("jo");
        }else{
            System.out.println("date nem jó");
        }

        boolean valid=false;
        Pattern patter=Pattern.compile("((^19)[8-9][0-9])|(^20[0-1][0-9])");
        Matcher m=patter.matcher("2002");
        if(m.matches()){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }


        String a="1999-2000";
        if(a.matches("(((^19)[8-9][0-9])|((^20)[0-1][0-9]))-(((19)[8-9][0-9]$)|((20)[0-1][0-9]$))")){
            System.out.println("yesss");
        }else{
            System.out.println("nooo");
        }
    }


}
