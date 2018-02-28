package methodchain.robot;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private int distance = 0;
    private int azimut = 0;
    private List<String> NavigationList = new ArrayList<String>();

    public List<String> getNavigationList() {
        return NavigationList;
    }

    public Robot go(int meter) {

        this.distance += meter;

        return this;

    }

    public Robot rotate(int angle) {
        this.azimut += angle;
        if (this.azimut + angle > 360) {
            this.azimut = this.azimut + angle - 360;
        } else if (this.azimut < -360) {
            this.azimut = this.azimut - angle + 360;
        }

        return this;

    }

    public int getDistance() {
        return distance;
    }

    public int getAzimut() {
        return azimut;
    }

    public Robot registerNavigationPoint() {
        NavigationPoint np = new NavigationPoint(distance, azimut);

        NavigationList.add(np.toString());
        return this;
    }

}
