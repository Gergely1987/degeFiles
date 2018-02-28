package activity;

public class ReportBuilder {
    private ActivityType activityType=null;
    private double distance=-1;

    public ActivityType getActivityType() {
        return activityType;
    }

    public double getDistance() {
        return distance;
    }


    public ReportBuilder withActivityType(ActivityType activityType) {
        this.activityType = activityType;
        return this;
    }

    public ReportBuilder withDistance(double distance) {
        this.distance = distance;
        return this;
    }

    public Report build(){
        if(activityType==null ){
           throw new IllegalArgumentException("missing data"+activityType);
        }
        if(distance==-1){
            throw new IllegalArgumentException("missing data"+distance);
        }
        return new Report(activityType,distance);
    }
}
