package interfaceextends.bonus;

import interfaceextends.robot.Point;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OwnerTest {

	@Test
	public void testCallTheRobot() {
		//Given
		Point ownerPoint = new Point(5,6,7);
		Owner owner = new Owner(ownerPoint);
		MovableRobotTestImpl movableRobot = new MovableRobotTestImpl();
        //When
		owner.callTheRobot(movableRobot);
        //Then
		assertThat(movableRobot.getPosition().getX(), is(ownerPoint.getX()));
		assertThat(movableRobot.getPosition().getY(), is(ownerPoint.getY()));
		assertThat(movableRobot.getPosition().getZ(), is(ownerPoint.getZ()));
	}

	@Test
	public void testEmergencyCallTheRobot() {
		//Given
		Point ownerPoint = new Point(5,6,7);
		Owner owner = new Owner(ownerPoint);
        MovableRobotTestImpl movableRobot = new MovableRobotTestImpl();
        //When
		owner.emergencyCallTheRobot(movableRobot);
        //Then
		assertThat(movableRobot.getPosition().getX(), is(ownerPoint.getX()));
		assertThat(movableRobot.getPosition().getY(), is(ownerPoint.getY()));
		assertThat(movableRobot.getPosition().getZ(), is(ownerPoint.getZ()));
	}
}