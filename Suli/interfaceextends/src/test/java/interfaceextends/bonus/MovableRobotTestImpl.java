package interfaceextends.bonus;

import interfaceextends.robot.MovableRobot;
import interfaceextends.robot.Point;

import java.util.List;

public class MovableRobotTestImpl implements MovableRobot{

        Point position;

        @Override
        public void moveTo(Point position) {
            this.position = position;
        }

        @Override
        public void fastMoveTo(Point position) {
            this.position = position;
        }

        @Override
        public void rotate(int angle) { throw new UnsupportedOperationException("Not implemented yet!"); }

        @Override
        public List<Point> getPath() {
            throw new UnsupportedOperationException("Not implemented yet!");
        }

        public Point getPosition() {
            return position;
        }
}
