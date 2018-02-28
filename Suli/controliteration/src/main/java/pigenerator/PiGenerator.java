package pigenerator;

import java.math.BigDecimal;

public class PiGenerator {
    int count = 0;
    String hossz="";
    String[] vers = {"Nem", "a", "régi", "s", "durva", "közelítés", "mi", "szótól", "szóig", "így", "kijön", "betűiket", "számlálva", "Ludolph", "eredménye", "már", "ha", "itt", "végezzük", "húsz", "jegyen", "De", "rendre", "kijő", "még", "tíz", "pontosan", "Azt", "is", "bízvást", "ígérhetem"};

    public BigDecimal getPi(){
        BigDecimal bd=null;

        for (int i = 0; i <vers.length ; i++) {
            count=vers[i].length();
            hossz+=Integer.toString(count);
        }

        hossz=hossz.substring(0,1)+"."+hossz.substring(1);

        bd=new BigDecimal(hossz);
        System.out.println(bd);
        return  bd;
    }



}