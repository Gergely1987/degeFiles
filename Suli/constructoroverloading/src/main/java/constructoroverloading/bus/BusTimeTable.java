package constructoroverloading.bus;

import java.util.ArrayList;
import java.util.List;

public class BusTimeTable {


    private List<SimpleTime> TIME_TABLE=new ArrayList<>();

    public BusTimeTable(List<SimpleTime> timeTable){
        this.TIME_TABLE = timeTable;
    }
    public BusTimeTable(int firstHour, int lastHour, int everyMinute){
        int actualHour = firstHour;
        while (actualHour <= lastHour) {
            TIME_TABLE.add(new SimpleTime(actualHour, everyMinute));
            actualHour++;
        }
    }


    public List<SimpleTime> getTimeTable() {
        return TIME_TABLE;
    }

    public SimpleTime nextBus(SimpleTime actual){
        int a=actual.getHours()*60+actual.getMinutes();
        int b=TIME_TABLE.get(TIME_TABLE.size()-1).getHours()*60+TIME_TABLE.get(TIME_TABLE.size()-1).getMinutes();
        SimpleTime st=null;

        if(a>b){
            throw new IllegalStateException("No more buses today!");
        }
        for (int i = 0; i <TIME_TABLE.size()-1; i++) {
            if(a>TIME_TABLE.get(i).getHours()*60+TIME_TABLE.get(i).getMinutes() &&a<TIME_TABLE.get(i+1).getHours()*60+TIME_TABLE.get(i+1).getMinutes()){
                st= TIME_TABLE.get(i+1);
            }
        }
        return st;
    }
}
