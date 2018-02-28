package datenewtypes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class DateOfBirth {

    LocalDate dateOfBirth;

    public DateOfBirth(int year, int month, int day) {
        dateOfBirth = LocalDate.of(year, month, day);
    }

    public DateOfBirth(String date, String pattern) {
        if (isEmpty(date)) {
            throw new IllegalArgumentException("Empty date string");
        }
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string");
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        dateOfBirth = LocalDate.parse(date, dtf);

    }

    public DateOfBirth(String date, String pattern, Locale local) {
        if (local == null) {
            throw new NullPointerException("Locale must not be null");
        }
        if (isEmpty(date)) {
            throw new IllegalArgumentException("Empty date string");
        }
        if (isEmpty(pattern)) {
            throw new IllegalArgumentException("Empty pattern string");
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        dateOfBirth = LocalDate.parse(date, dtf);

    }


    public String findDayOfWeekForBirthDate(Locale locale){
        if(locale==null){throw new NullPointerException("Locale must not be null!");}
        DateTimeFormatter formatter =DateTimeFormatter.ofPattern("EEEE",locale);
        String result=formatter.format(dateOfBirth);
        return result;
    }

    public int countDaysSinceBirth(){
        if(getDateOfBirth().isAfter(LocalDate.now())){
            throw new IllegalStateException("Birthdate is in the future");
        }
        int result= (int)ChronoUnit.DAYS.between(dateOfBirth,LocalDate.now());
        return result;
    }

    public int countDaysBetween(DateOfBirth date){
        return (int) ChronoUnit.DAYS.between(this.getDateOfBirth(), date.getDateOfBirth());
    }



    public String toString(String pattern) {
        if(isEmpty(pattern)){
            throw new IllegalArgumentException("Empty pattern string");
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return dateOfBirth.format(dtf);

    }

    private boolean isEmpty(String str) {
        if (str == null || str.trim().isEmpty()) {
            return true;
        }
        return false;
    }


    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
}
