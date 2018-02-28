package inheritancemethods.products;

import java.math.BigDecimal;

public class Product {

    private String name;
    private BigDecimal unitWeight;
    private int numberOfDecimals;


    public Product(String name, BigDecimal unitWeigth, int numberOfDecimals) {
        this.name = name;
        this.unitWeight = unitWeigth;
        this.numberOfDecimals = numberOfDecimals;
    }

    public Product(String name, BigDecimal unitWeigth) {
        this.name = name;
        this.unitWeight = unitWeigth;
        this.numberOfDecimals = 2;
    }

    public BigDecimal totalWeight(int pieces) {
        return unitWeight.multiply( BigDecimal.valueOf(pieces));
    }


    public String getName() {
        return name;
    }

    public BigDecimal getUnitWeight() {
        return unitWeight;
    }

    public int getNumberOfDecimals() {
        return numberOfDecimals;
    }

    public Product() {
    }
}
