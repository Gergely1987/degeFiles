package dateoldtypes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class proba {
    public static void main(String[] args) {

        Calendar cal=Calendar.getInstance();
        cal.set(1987,10,17);

        int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek);
    }
}
