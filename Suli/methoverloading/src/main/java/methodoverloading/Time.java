package methodoverloading;

import javax.management.StringValueExp;

public class Time {

    private int hours;
    private int minutes;
    private int seconds;

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public Time(int hours, int minutes, int seconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = 0;

    }

    public Time(int hours) {
        this.hours = hours;
        this.minutes = 0;
        this.seconds = 0;
    }

    public Time(Time time) {
        this.hours = time.getHours();
        this.minutes = time.getMinutes();
        this.seconds = time.getSeconds();
    }

    public boolean isEqual(Time time) {
        if (this.hours == time.getHours() && this.minutes == time.getMinutes() && this.seconds == time.getSeconds()) {
            return true;
        }
        return false;

    }

    public boolean isEqual(int hours, int minutes, int seconds) {
        if (this.hours == hours && this.minutes == minutes && this.seconds == seconds) {
            return true;
        }
        return false;
    }

    public boolean isEarlier(Time time) {
   int a=time.getHours()*60*60;
   int b=time.getMinutes()*60;
   int c=time.getSeconds();

   int d=this.hours*60*60;
   int e=this.minutes*60;
   int f=this.seconds;

   int Tsum=a+b+c;
   int sum=d+e+f;

   if(Tsum>sum){
       return true;
   }
   return false;

    }

    public boolean isEarlier(int hours, int minutes, int seconds) {
        int a=hours*60*60;
        int b=minutes*60;
        int c=seconds;

        int d=this.hours*60*60;
        int e=this.minutes*60;
        int f=this.seconds;

        int Tsum=a+b+c;
        int sum=d+e+f;

        if(Tsum>sum){
            return true;
        }
        return false;

    }
}
