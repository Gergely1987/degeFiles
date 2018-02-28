package inheritancemethods.products;

import java.math.BigDecimal;

public class PackedProduct extends Product {
    private int packingUnit;
    private BigDecimal weightOfBox;

    public PackedProduct(String name, BigDecimal unitWeigth, int numberOfDecimals, int packingUnit, BigDecimal weightOfBox) {
        super(name, unitWeigth, numberOfDecimals);
        this.packingUnit = packingUnit;
        this.weightOfBox = weightOfBox;
    }

    @Override
    public BigDecimal totalWeight(int pieces) {
        BigDecimal a = (BigDecimal.valueOf(pieces).divide(BigDecimal.valueOf(packingUnit))).setScale(0, BigDecimal.ROUND_DOWN);
        int b = 1;
        a = a.add(BigDecimal.valueOf(b));
        a = a.multiply(weightOfBox);
        BigDecimal totalUnitWeight = super.getUnitWeight().multiply(BigDecimal.valueOf(pieces));
        a = totalUnitWeight.add(a);

        return a;
    }

    public int getPackingUnit() {
        return packingUnit;
    }

    public BigDecimal getWeightOfBox() {
        return weightOfBox;
    }

}
