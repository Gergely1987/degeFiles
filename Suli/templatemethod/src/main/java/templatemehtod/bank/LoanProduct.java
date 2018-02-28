package templatemehtod.bank;

import java.math.BigDecimal;

public class LoanProduct extends GeneralProduct{

    public LoanProduct(int price) {
        super(price);
    }

    @Override
    public int round(double newPrice) {
        BigDecimal bd=new BigDecimal(Double.toString(newPrice));
        bd=bd.setScale(0,BigDecimal.ROUND_HALF_UP);

        return bd.intValue();
    }
}
