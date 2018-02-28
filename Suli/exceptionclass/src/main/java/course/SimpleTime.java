package course;

public class SimpleTime {
    private int hour;
    private int minutes;

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minutes;
    }

    public SimpleTime(int hour, int minutes) {
        if (hour > 23 || hour < 0) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (minutes < 0 || minutes > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
        this.hour = hour;
        this.minutes = minutes;
    }

    public SimpleTime(String str) {

        if (str == null) {
            throw new InvalidTimeException("Time is null");
        }

        try {
            int hourT = Integer.parseInt(str.substring(0, 2));
            String point = str.substring(2, 3);
            int minT = Integer.parseInt(str.substring(3, 5));
            if(!point.equals(":")){
                throw new InvalidTimeException("Time is not hh:mm");
            }
            hour=hourT;
            minutes=minT;

            if (hour > 23 || hour < 0) {
                throw new InvalidTimeException("Hour is invalid (0-23)");
            }
            if (minutes < 0 || minutes > 59) {
                throw new InvalidTimeException("Minute is invalid (0-59)");
            }
        } catch (NumberFormatException  ite) {
            throw new InvalidTimeException("Time is not hh:mm");
        }

        int hour = Integer.parseInt(str.substring(0, 1));
        int min = Integer.parseInt(str.substring(3, 4));

        if (hour > 23) {
            throw new InvalidTimeException("Hour is invalid (0-23)");
        }
        if (min > 59) {
            throw new InvalidTimeException("Minute is invalid (0-59)");
        }
    }

    @Override
    public String toString() {

        String hoursString=Integer.toString(hour);
        String minutesString=Integer.toString(minutes);

        if(hoursString.length()==1){
            hoursString="0"+hoursString;
        }
        if(minutesString.length()==1){
            minutesString="0"+minutesString;
        }

        return hoursString+":"+minutesString;

    }
}
