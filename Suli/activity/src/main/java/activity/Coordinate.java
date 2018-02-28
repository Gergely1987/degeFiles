package activity;

public class Coordinate {
    double latitude;
    double longitude;

    public Coordinate(double latitude, double longitude) {
        if(latitude>90 || latitude<-90){
            throw new IllegalArgumentException("not valid coordinates: "+latitude);
        }
        if(longitude>180 || longitude<-180){
            throw new IllegalArgumentException("not valid coordinates: "+longitude);
        }
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
