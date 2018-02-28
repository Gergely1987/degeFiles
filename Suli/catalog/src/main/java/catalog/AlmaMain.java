package catalog;


import java.util.Arrays;
import java.util.List;

public class AlmaMain {

public static void modify(String str, List<String> strList){
    str=str+"a";
    //strList.add(0,"alma");
    System.out.println(str);

}
    public static void main(String[] args) {

    String s="korte";
    List<String> l= Arrays.asList("korte");
l.add("alma");
    modify(s,l);
        System.out.println(s);
        System.out.println(l);

    }

}
