package activity;

import java.util.ArrayList;
import java.util.List;

public class Track {
    private List<TrackPoint> trackPoints=new ArrayList<>();

    public void addTrackPoint(TrackPoint trackPoint){
        trackPoints.add(trackPoint);
    }

    public Coordinate findMaximumCoordinate(){
        double maxLongitude=trackPoints.get(0).getCoordinate().getLongitude();
        double maxLatitude=trackPoints.get(0).getCoordinate().getLatitude();

        for (int i = 0; i <trackPoints.size() ; i++) {
            if(trackPoints.get(i).getCoordinate().getLatitude()>maxLongitude){
                maxLongitude=trackPoints.get(i).getCoordinate().getLongitude();
            }
            if(trackPoints.get(i).getCoordinate().getLatitude()>maxLatitude){
                maxLatitude=trackPoints.get(i).getCoordinate().getLatitude();
            }
        }
        return new Coordinate(maxLatitude,maxLongitude);
    }

    public Coordinate findMinimumCoordinate(){
        double minLongitude=trackPoints.get(0).getCoordinate().getLongitude();
        double minLatitude=trackPoints.get(0).getCoordinate().getLatitude();

        for (int i = 0; i <trackPoints.size() ; i++) {
            if(trackPoints.get(i).getCoordinate().getLatitude()<minLongitude){
                minLongitude=trackPoints.get(i).getCoordinate().getLongitude();
            }
            if(trackPoints.get(i).getCoordinate().getLatitude()<minLatitude){
                minLatitude=trackPoints.get(i).getCoordinate().getLatitude();
            }
        }
        return new Coordinate(minLatitude,minLongitude);
    }


    public double getDistance(){
            double distance=0;
        for (int i = 0; i <trackPoints.size()-1 ; i++) {
           distance+=trackPoints.get(i).getDistanceFrom(trackPoints.get(i+1));

        }
        return distance;
    }

    public double getFullDecrease(){
        double fullDecrease=0;
        for (int i = 0; i <trackPoints.size()-1 ; i++) {
            if(trackPoints.get(i).getElevation()>trackPoints.get(i+1).getElevation()){
                fullDecrease+=trackPoints.get(i+1).getElevation();
            }
        }
        return fullDecrease;
    }

    public double getFullElevation(){
        double min_elevation=trackPoints.get(0).getElevation();
        double max_elevation=trackPoints.get(0).getElevation();
        for (int i = 0; i <trackPoints.size() ; i++) {
            if(trackPoints.get(i).getElevation()<min_elevation){
                min_elevation=trackPoints.get(i).getElevation();
            }
            if(trackPoints.get(i).getElevation()>max_elevation){
                max_elevation=trackPoints.get(i).getElevation();
            }
        }
        return max_elevation-min_elevation+1;

    }

    public double getRectangleArea(){
        Coordinate minCoordinate = findMinimumCoordinate();
        Coordinate maxCoordinate = findMaximumCoordinate();
        double sideA = maxCoordinate.getLatitude() - minCoordinate.getLatitude();
        double sideB = maxCoordinate.getLongitude() - minCoordinate.getLongitude();

        return sideA * sideB;

    }

    public List<TrackPoint> getTrackPoints() {
        return trackPoints;
    }
}
