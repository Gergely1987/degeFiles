package enumtype.unit;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class UnitConverter {

    public BigDecimal convert(BigDecimal length, LengthUnit source, LengthUnit target) {


       BigDecimal mm=  BigDecimal.valueOf(source.getMil()).multiply(length).divide(BigDecimal.valueOf(target.getMil())).setScale(4,BigDecimal.ROUND_UP);



        System.out.println(mm);
        return mm;
    }

    public List<LengthUnit> siUnits(){

        List<LengthUnit> newSi=new ArrayList<>();
            for (int i=0; i<LengthUnit.values().length; i++){
              if(LengthUnit.values()[i].isSi()==true){
               newSi.add(LengthUnit.values()[i])   ;
                }
                
            }
        System.out.println(newSi);
        return newSi;
    }

}
