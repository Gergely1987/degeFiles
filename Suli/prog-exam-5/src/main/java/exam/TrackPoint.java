package exam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TrackPoint {

    private LocalDateTime time;
    private double lat;
    private double lon;
    private int elevation;
    private String comment;

    TrackPoint trackPoint;

    public TrackPoint(String fullTrack) {
    String[]array=fullTrack.split(",");
    if(array.length<6){
        throw new IllegalArgumentException("Invalid field number");
    }

    DateTimeFormatter formatter= DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    String dateNew=array[0]+" "+array[1];
    time=LocalDateTime.parse(dateNew,formatter);
    lat=Double.parseDouble(array[2]);
    lon=Double.parseDouble(array[3]);
    elevation=Integer.parseInt(array[4]);
    comment=array[5];



    }

    public TrackPoint(LocalDateTime time, double lat, double lon, int elevation, String comment) {
        this.time = time;
        this.lat = lat;
        this.lon = lon;
        this.elevation = elevation;
        this.comment = comment;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public int getElevation() {
        return elevation;
    }

    public String getComment() {
        return comment;
    }
}
