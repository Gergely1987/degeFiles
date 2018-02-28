package sales;

import java.util.List;

public class SalesAmountMaxSelector {


    public Salesperson selectSalesPersonWithMaxSalesAmount(List<Salesperson> total) {

            int max = total.get(0).getAmount();
            int num=0;
            for (int i = 0; i < total.size(); i++) {
                if (total.get(i).getAmount() > max) {
                    max = total.get(i).getAmount();
                  num=i;

                }

            }
            return total.get(num);
        }

}
