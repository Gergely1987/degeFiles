package xml.gpx;

import java.time.ZonedDateTime;

public class TrackPoint {
    private double lat;
    private double lon;
    private double elevation;
    private ZonedDateTime time;

    public TrackPoint() {
    }

    public TrackPoint(double lat, double lon, double elevation, ZonedDateTime time) {
        this.lat = lat;
        this.lon = lon;
        this.elevation = elevation;
        this.time = time;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public double getElevation() {
        return elevation;
    }

    public ZonedDateTime getTime() {
        return time;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setElevation(double elevation) {
        this.elevation = elevation;
    }

    public void setTime(ZonedDateTime time) {
        this.time = time;
    }
}
