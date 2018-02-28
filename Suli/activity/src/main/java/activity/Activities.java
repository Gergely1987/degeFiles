package activity;

import java.util.ArrayList;
import java.util.List;

public class Activities {
    private List<Activity> activities;

    public Activities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }

    public List<Report> distancesByTypes() {
        List<Report> reports = new ArrayList<>();
        List<ReportBuilder> reportBuilders=new ArrayList<>();

        reportBuilders.add(new ReportBuilder().withActivityType(ActivityType.BASKETBALL));

    }

    public int numberOfTrackActivities() {
        int counter = 0;

        for (Activity ac : activities) {
            if (ac.getType() == ActivityType.RUNNING || ac.getType() == ActivityType.BIKING || ac.getType() == ActivityType.HIKING) {
                counter++;
            }
        }
        return counter;
    }

    public int numberOfWithoutTrackActivities() {
        int counter = 0;

        for (Activity ac : activities) {
            if (ac.getType() == ActivityType.BASKETBALL) {
                counter++;
            }
        }
        return counter;
    }
}
