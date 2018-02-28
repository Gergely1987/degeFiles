package dateoldtypes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateOfBirth {

    Date date;

    public DateOfBirth(int year, int month, int day) {
        setDateOfBirth(year + "-" + month + "-" + day, new SimpleDateFormat("yyyy-MM-dd"));
    }

    public DateOfBirth(String dateString, String pattern, Locale locale) {
        if (isEmpty(dateString)) {
            throw new IllegalArgumentException("Illegal date string");
        }
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Illegal pattern string");
        }
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        setDateOfBirth(dateString, new SimpleDateFormat(pattern));
    }

    public DateOfBirth(String dateString, String pattern) {
        this(dateString, pattern, Locale.getDefault());
    }

    public String findDayOfWeekForBirthDate(Locale locale) {
        if (locale == null) {
            throw new NullPointerException("Locale must not be null!");
        }
        return DayOfWeek.values().toString();
    }

    public String toString(String pattern) {
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Illegal pattern string");
        }

        return new SimpleDateFormat(pattern).format(date);
    }

    public boolean isWeekDay() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek);
        System.out.println(date);
        if(dayOfWeek==1 || dayOfWeek==7){
            return false;
        }
        return true;
    }


    boolean isEmpty(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        return true;
    }

    void setDateOfBirth(String dateString, DateFormat dateFormat) {
        dateFormat.setLenient(false);
        try {
            Date date = dateFormat.parse(dateString);
            this.date = date;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date!");
        }
    }

}
