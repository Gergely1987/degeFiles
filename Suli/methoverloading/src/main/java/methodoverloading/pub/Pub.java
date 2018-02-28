package methodoverloading.pub;

import java.util.ArrayList;
import java.util.List;

public class Pub {
    private String name;
    private int hours;
    private int minutes;


    public Pub(String name, int hours, int minutes) {
        this.name = name;
        this.hours = hours;
        this.minutes = minutes;
    }

    public String getName() {
        return name;
    }


    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public Pub getOpenFrom(){
        this.hours=getHours();
        this.minutes=getMinutes();
        return this;
    }

    @Override
    public String toString() {
        return name + ";" + getHours() + ":" + getMinutes();
    }
}
