package defaultconstuctor.date;

public class SimpleDate {

    private int year;
    private int month;
    private int day;

    public void setDate(int year, int month, int day){
        if(year<=1900|| month>12||month<1){
            throw new IllegalArgumentException("One or more given parameter cannot be applied!");
        }
        if((month==2 ||month==4 ||month==6 ||month==9||month==11)&&day>30){
            throw new IllegalArgumentException("One or more given parameter cannot be applied!");
        }
        if(year%4!=0|| year%100==0){
            throw new IllegalArgumentException("One or more given parameter cannot be applied!");
        }
        this.year=year;
        this.month=month;
        this.day=day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }


}
