package sales;

import java.util.List;

public class SalespersonWithFurthestBelowTargetSelector {

    public Salesperson selectSalesPersonWithFurthestBelowTarget(List<Salesperson> total) {
        int num=0;
        int belowestTarget = total.get(0).getDifferenceFromTarget();

        for (int i = 0; i < total.size(); i++) {
            if (total.get(i).getDifferenceFromTarget() < belowestTarget) {
                belowestTarget = total.get(i).getDifferenceFromTarget();
                num=i;
            }

        }
        return total.get(num);
    }
}
