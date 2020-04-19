 

import java.util.ArrayList;
import java.util.List;

import maze.*;

/**
 * An implementation of the left walker, which you need to complete according to
 * the specification given in the assignment handout.
 * 
 */
public class LeftWalker extends Walker {

	// walker faces north at the start by default
	private Direction facingDirection = Direction.NORTH;

	private boolean restart = true;

	public LeftWalker() {
		super("Left Walker");
	}1

	@Override
	protected Direction move(View v) {

		pause(100);

		if (restart == true) {
			return findLeftWall(v); // walker attempts to locate the left wall
		}

		else {

			if (ableTurnLeft(v)) {
				doturnLeft();
			}

			else {
				while (obstruction(v)) { // while there is a wall blocking the
											// walkers path
					if (ableTurnLeft(v)) {
						doturnLeft();
						break;
					} else {
						rotate(); // if you cannot turn left, rotate until you
									// can
					}
				}
			}
			return this.facingDirection;
		}

	}

	/*
	 * method figures out if the walker is able to turn left
	 * 
	 * @returns boolean
	 * 
	 * @param v View
	 */
	public boolean ableTurnLeft(View v) {
		switch (this.facingDirection) {
		case NORTH:
			return v.mayMove(Direction.WEST);
		case SOUTH:
			return v.mayMove(Direction.EAST);
		case EAST:
			return v.mayMove(Direction.NORTH);
		case WEST:
			return v.mayMove(Direction.SOUTH);
		default:
			return false;
		}
	}

	/*
	 * works out which direction is the direction to the walkers left and sets
	 * the direction to this result
	 */
	public void doturnLeft() {
		switch (this.facingDirection) {
		case NORTH:
			this.facingDirection = Direction.WEST; // sets the left turn based
													// on the direction it
													// is currently facing
			break;
		case SOUTH:
			this.facingDirection = Direction.EAST;
			break;
		case EAST:
			this.facingDirection = Direction.NORTH;
			break;
		case WEST:
			this.facingDirection = Direction.SOUTH;
			break;

		}
	}

	/*
	 * when the maze starts, the walker must find the first left wall to cling
	 * onto. the method locates this wall and if it is not found, the walker
	 * moves until it reaches the first left wall
	 * 
	 * @param v View
	 * 
	 * @return Direction
	 */
	public Direction findLeftWall(View v) {
		if (!wallSurroundingWalker(v)) {
			return Direction.NORTH; // if it is not touching any walls, move
									// north until it is
		} else {
			while (ableTurnLeft(v)) {
				rotate();z
			}
			restart = false;
			return facingDirection;
		}
	}

	/*
	 * if the walker is not touching any walls, it moves north until it finds a
	 * wall
	 * 
	 * @param v View
	 * 
	 * @return boolean
	 */
	public boolean wallSurroundingWalker(View v) {
		if (!v.mayMove(Direction.NORTH)) { // returns a boolean (t/f) on whether
											// there is something blocking its
											// path
			return true;
		}
		if (!v.mayMove(Direction.SOUTH)) {
			return true;
		}
		if (!v.mayMove(Direction.EAST)) {
			return true;
		}
		if (!v.mayMove(Direction.WEST)) {
			return true;
		}
		return false;
	}

	/*
	 * scans to see if walker is able to keep moving in the direction it is
	 * already going
	 * 
	 * @param v View
	 * 
	 * @return boolean
	 */
	public boolean obstruction(View v) {
		return !v.mayMove(facingDirection);
	}

	/*
	 * rotates the walker by turning it in a clockwise direction
	 */
	public void rotate() {
		switch (this.facingDirection) {
		case NORTH:
			this.facingDirection = Direction.EAST;
			break;
		case SOUTH:
			this.facingDirection = Direction.WEST;
			break;
		case EAST:
			this.facingDirection = Direction.SOUTH;
			break;
		case WEST:
			this.facingDirection = Direction.NORTH;
			break;

		}

	}

}