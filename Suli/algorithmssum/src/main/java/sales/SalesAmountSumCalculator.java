package sales;

import java.util.ArrayList;
import java.util.List;

public class SalesAmountSumCalculator {

   private int num=0;

    public int sumSalesAmount(List<Salesperson> a) {
        for (int i = 0; i <a.size() ; i++) {
           num+= a.get(i).getAmount();
        }
        return num;

    }

}
