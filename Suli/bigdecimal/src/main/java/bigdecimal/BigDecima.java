package bigdecimal;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class BigDecima {
    private static final String taxPercent = "0.27";

    public BigDecimal calculateTax(BigDecimal price) {
        BigDecimal bd;
        bd = price.multiply(new BigDecimal(taxPercent)).setScale(2, BigDecimal.ROUND_HALF_UP);

        return bd;
    }

    public BigDecimal calulatePriceWithTax(BigDecimal price) {
        BigDecimal bd = calculateTax(price);
        bd = bd.add(price);
        return bd;

    }

    public BigDecimal distributeBetweenDays(BigDecimal price, int numberOfDays) {
        BigDecimal bd;
        bd = price.divide(BigDecimal.valueOf(numberOfDays), RoundingMode.HALF_UP);
        return bd;

    }

    public BigDecimal interestOnInterest(BigDecimal principle, BigDecimal rate, int years) {
        BigDecimal bd = principle;
        for (int i = 0; i < years; i++) {
            bd = bd.add(bd.multiply(rate));

        }
        return bd;
    }

    public List<BigDecimal> roundHalfUpAndAddToLast(List<BigDecimal> numbers, int scale) {
        List<BigDecimal> difference = new ArrayList<>();
        BigDecimal d;
        BigDecimal e=new BigDecimal(String.valueOf(BigDecimal.ZERO));
        for (int i = 0; i < numbers.size(); i++) {
            d = numbers.get(i).subtract(numbers.get(i).setScale(scale, BigDecimal.ROUND_DOWN));
            difference.add(d);
        }

       for (int i=0; i<difference.size(); i++){
            e=e.add(difference.get(i));
       }
        difference.add(e);
            return difference;
    }

}
