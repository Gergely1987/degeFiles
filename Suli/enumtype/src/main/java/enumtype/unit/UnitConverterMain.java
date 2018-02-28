package enumtype.unit;

import java.math.BigDecimal;

public class UnitConverterMain {
    public static void main(String[] args) {
    UnitConverter uc=new UnitConverter();
    LengthUnit lu= LengthUnit.METER;

    System.out.println(lu.getMil());
        System.out.println();
    for (LengthUnit i: LengthUnit.values()){
        System.out.println(i);
    }
        System.out.println();
    uc.siUnits();
    uc.convert(BigDecimal.valueOf(10.11111), LengthUnit.CENTIMETER,LengthUnit.METER);
    }
}
