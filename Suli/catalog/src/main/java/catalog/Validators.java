package catalog;

import java.util.List;

public class Validators {


    public static boolean isBlank(String s) {
        return (s == null || s.trim().isEmpty());


    }

    public static boolean isEmpty(List<String> sList) {
        return (sList == null || sList.isEmpty());


    }


}