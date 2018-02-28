package constructoroverloading.bus;

public class SimpleTime {
    private int hours;
    private int minutes;

    public SimpleTime(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public SimpleTime(int hours) {
        this.hours = hours;
        this.minutes = 0;
    }

    public SimpleTime(SimpleTime time) {
        this(time.getHours(),time.getMinutes());
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int difference(SimpleTime time) {
        int dif = 0;

        dif =this.hours*60+minutes-(time.getHours()*60+time.getMinutes());
        return dif;
    }

    public String toString() {
        if (minutes == 0) {
            return hours + ":00";
        }
        return hours + ":" + minutes;
    }

}
