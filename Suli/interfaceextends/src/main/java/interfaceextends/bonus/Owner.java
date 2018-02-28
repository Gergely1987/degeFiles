package interfaceextends.bonus;

import interfaceextends.robot.MovableRobot;
import interfaceextends.robot.Point;

public class Owner {
    private Point position;

    public Point getPosition() {
        return position;
    }


    public Owner(Point position){
        this.position=position;
    }

    public void callTheRobot(MovableRobot movableRobot){
            movableRobot.moveTo(position);
    }
    public void emergencyCallTheRobot(MovableRobot movableRobot){
        movableRobot.fastMoveTo(position);
    }

}
