package enumtype.week;

import java.util.ArrayList;
import java.util.List;

public class WorkdayCalculator {

    public List<DayType> dayTypes(Day firstDay, int numberOfDays) {
        List<DayType> newType = new ArrayList<>();

        newType.add(firstDay.getValue());
        Day currentDay = firstDay;

        for (int i=0; i<numberOfDays; i++){
         newType.add(nextDay(currentDay).getValue());
         currentDay = nextDay(currentDay);

        }

        System.out.println(newType.toString());
        return newType;

    }

    private Day nextDay(Day day) {

        switch (day.ordinal()) {
            case 0:
                return Day.THUESDAY;

            case 1:
                return Day.WEDNESDAY;

            case 2:
                return Day.THURSDAY;

            case 3:
                return Day.FRIDAY;

            case 4:
                return Day.SATURDAY;

            case 5:
                return Day.SUNDAY;

            default:
                return Day.MONDAY;

        }
    }
}
