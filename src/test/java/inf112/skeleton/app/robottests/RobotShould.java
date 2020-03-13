package inf112.skeleton.app.robottests;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import inf112.skeleton.app.GameMovement;
import inf112.skeleton.app.objects.Board;
import inf112.skeleton.app.objects.Robot;
import inf112.skeleton.app.objects.tiles.*;
import inf112.skeleton.app.utilities.CardinalDirection;

public class RobotShould {
	int robotX, robotY;
	Robot robot;
	Board brd;

	@Before
	public void initialize() throws FileNotFoundException {
		robotX = robotY = 5;
		robot = new Robot(robotX, robotY, 0);
		brd = new Board("b0.csv");
	}

	/**
	 * MOVEMENT
	 */
	private void checkMovement(int steps, CardinalDirection direction) {
		robot.setDirection(direction.value);
		GameMovement.move(steps, robot, brd, null);

		if (direction == CardinalDirection.NORTH) {
			assertEquals(robotY - steps, robot.getY());
		} else if (direction == CardinalDirection.EAST) {
			assertEquals(robotX + steps, robot.getX());
		} else if (direction == CardinalDirection.SOUTH) {
			assertEquals(robotY + steps, robot.getY());
		} else if (direction == CardinalDirection.WEST) {
			assertEquals(robotX - steps, robot.getX());
		}
	}

	/**
	 * Move one forward in each direction
	 */
	@Test
	public void move1UpOnMove1Direction0() {
		checkMovement(1, CardinalDirection.NORTH);
	}

	@Test
	public void move1RightOnMove1Direction1() {
		checkMovement(1, CardinalDirection.EAST);
	}

	@Test
	public void move1DownOnMove1Direction2() {
		checkMovement(1, CardinalDirection.SOUTH);
	}

	@Test
	public void move1LeftOnMove1Direction3() {
		checkMovement(1, CardinalDirection.WEST);
	}

	/**
	 * Move one backwards in each direction
	 */
	@Test
	public void move1DownOnMoveNEGATIVE1Direction0() {
		checkMovement(1, CardinalDirection.NORTH);
	}

	@Test
	public void move1LeftOnMoveNEGATIVE1Direction1() {
		checkMovement(1, CardinalDirection.EAST);
	}

	@Test
	public void move1UpOnMoveNEGATIVE1Direction2() {
		checkMovement(1, CardinalDirection.SOUTH);
	}

	@Test
	public void move1RightOnMoveNEGATIVE1Direction3() {
		checkMovement(1, CardinalDirection.WEST);
	}

	/**
	 * Move two forward in each direction
	 */
	@Test
	public void move2UpOnMove2Direction0() {
		checkMovement(2, CardinalDirection.NORTH);
	}

	@Test
	public void move2RightOnMove2Direction1() {
		checkMovement(2, CardinalDirection.EAST);
	}

	@Test
	public void move2DownOnMove2Direction2() {
		checkMovement(2, CardinalDirection.SOUTH);
	}

	@Test
	public void move2LeftOnMove2Direction3() {
		checkMovement(2, CardinalDirection.WEST);
	}

	/**
	 * Move three forward in each direction
	 */
	@Test
	public void move3UpOnMove3Direction0() {
		checkMovement(3, CardinalDirection.NORTH);
	}

	@Test
	public void move3RightOnMove3Direction1() {
		checkMovement(3, CardinalDirection.EAST);
	}

	@Test
	public void move3DownOnMove3Direction2() {
		checkMovement(3, CardinalDirection.SOUTH);
	}

	@Test
	public void move3LeftOnMove3Direction3() {
		checkMovement(3, CardinalDirection.WEST);
	}

	/**
	 * ROTATION
	 */
	private void checkRotation(int rotation, CardinalDirection direction) {
		robot.setDirection(direction.value);
		GameMovement.rotate(rotation, robot);
		assertEquals((direction.value + rotation % 4 + 4) % 4, robot.getDirection());
	}

	/**
	 * Clockwise rotation from each direction
	 */
	@Test
	public void rotate1ClockWiseOnRotate1Direction0() {
		checkRotation(1, CardinalDirection.NORTH);
	}

	@Test
	public void rotate1ClockWiseOnRotate1Direction1() {
		checkRotation(1, CardinalDirection.EAST);
	}

	@Test
	public void rotate1ClockWiseOnRotate1Direction2() {
		checkRotation(1, CardinalDirection.SOUTH);
	}

	@Test
	public void rotate1ClockWiseOnRotate1Direction3() {
		checkRotation(1, CardinalDirection.WEST);
	}

	/**
	 * Counter-clockwise rotation from each direction
	 */
	@Test
	public void rotate1CounterClockWiseOnRotate1Direction0() {
		checkRotation(-1, CardinalDirection.NORTH);
	}

	@Test
	public void rotate1CounterClockWiseOnRotate1Direction1() {
		checkRotation(-1, CardinalDirection.EAST);
	}

	@Test
	public void rotate1CounterClockWiseOnRotate1Direction2() {
		checkRotation(-1, CardinalDirection.SOUTH);
	}

	@Test
	public void rotate1CounterClockWiseOnRotate1Direction3() {
		checkRotation(-1, CardinalDirection.WEST);
	}
}