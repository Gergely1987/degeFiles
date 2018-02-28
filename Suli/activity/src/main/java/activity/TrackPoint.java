package activity;

public class TrackPoint {
    private Coordinate coordinate;
    private double elevation;


    public double getDistanceFrom(TrackPoint newPoint){
        final int R = 6371;
        double latDistance = Math.toRadians(newPoint.coordinate.latitude - coordinate.latitude);
        double lonDistance = Math.toRadians(newPoint.coordinate.longitude - coordinate.longitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(coordinate.latitude)) * Math.cos(Math.toRadians(newPoint.coordinate.latitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = elevation - newPoint.elevation;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);

    }

    public TrackPoint(Coordinate coordinate, double elevation) {
        this.coordinate = coordinate;
        this.elevation = elevation;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public double getElevation() {
        return elevation;
    }


}
