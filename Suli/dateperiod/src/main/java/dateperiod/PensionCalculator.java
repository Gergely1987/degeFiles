package dateperiod;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class PensionCalculator {

    List<Period>periods=new ArrayList<>();

    public void addEmploymentPeriod(Period period){
        periods.add(fullyNormalized(period));
    }
    public Period sumEmploymentPeriods(){

    }
    public Period modifyByDays(Period period, int days){

    }
    public Period getPeriodBetweenDates(LocalDate fromDate, LocalDate toDate){

    }
    public Period getPeriodBetweenDates(String fromDate, String toDate, String pattern){

    }
    public int calculateTotalDays(Period period){
        Period normalized=period.normalized();
    }

    private Period fullyNormalized(Period period){


    }

}
