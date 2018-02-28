package sales;

import java.util.List;

public class SalespersonWithFurthestAboveTargetSelector {
    public Salesperson selectSalesPersonWithFurthestAboveTarget(List<Salesperson> total) {
        int num=0;
        int furthestAboveTarget = total.get(0).getDifferenceFromTarget();

        for (int i = 0; i < total.size(); i++) {
            if (total.get(i).getDifferenceFromTarget() > furthestAboveTarget) {
                furthestAboveTarget = total.get(i).getDifferenceFromTarget();
                num=i;
            }
        }
        return total.get(num);
    }
}
