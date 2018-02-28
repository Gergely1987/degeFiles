package bigdecimal;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BigDecimalMain {

    public static void main(String[] args) {
//        double d=0.1*3;
//        System.out.println(d);
//
//        System.out.println(new BigDecimal("0.1").multiply(new BigDecimal(3)));
//        System.out.println(new BigDecimal("0.144533").setScale(2,BigDecimal.ROUND_HALF_UP));
//        System.out.println(new BigDecimal(String.valueOf(BigDecimal.TEN)));
//        System.out.println(String.valueOf(BigDecimal.TEN));

        BigDecima bd = new BigDecima();
        System.out.println(bd.calculateTax(BigDecimal.valueOf(1.11)));
        System.out.println(bd.calulatePriceWithTax(BigDecimal.valueOf(100)));

        System.out.println(bd.distributeBetweenDays(BigDecimal.valueOf(103), 7));
        System.out.println(bd.interestOnInterest(BigDecimal.valueOf(100), BigDecimal.valueOf(0.2),2));

        List<BigDecimal> bigD=new ArrayList<>();
        bigD.add(BigDecimal.valueOf(100.1));
        bigD.add(BigDecimal.valueOf(100.2));
        bigD.add(BigDecimal.valueOf(100.3));
        bigD.add(BigDecimal.valueOf(100.4));

        System.out.println(bd.roundHalfUpAndAddToLast(bigD,0));



    }
}
