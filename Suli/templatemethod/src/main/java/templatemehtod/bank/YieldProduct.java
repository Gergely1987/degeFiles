package templatemehtod.bank;

import java.math.BigDecimal;

public class YieldProduct extends GeneralProduct {
    public YieldProduct(int price) {
        super(price);
    }

    @Override
    public int round(double newPrice) {
        BigDecimal bd=new BigDecimal(Double.toString(newPrice));
        bd=bd.setScale(0,BigDecimal.ROUND_DOWN);

        return bd.intValue();
    }
}
