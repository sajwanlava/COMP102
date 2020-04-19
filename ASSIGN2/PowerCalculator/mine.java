 

import java.util.ArrayList;
import java.util.List;

import maze.*;

/**
 * An implementation of the left walker, which you need to complete according to
 * the specification given in the assignment handout.
 * 
 */
public class LeftWalker extends Walker {
	private Direction directionON;

	public LeftWalker(){
		super("Left Walker");
		directionON = Direction.NORTH; 
	}

	@Override
	protected Direction move(View v) {
		// TODO: you need to implement this method according to the
		// specification given for the left walker!!

		// Use the pause() command to slow the simulation down so you can see
		// what's happening...
		pause(500);
		//if(! followA wall)
		//find a wall should follow the wall on your left
		//return x
		//follow a wall

		// Currently, the left walker just follows a completely random
		// direction. This is not what the specification said it should do, so
		// tests will fail ... but you should find it helpful to look at how it
		// works!
		return getSpecificDirection(v);
	}

	/**
	 * This simply returns a randomly chosen (valid) direction which the walker
	 * can move in.
	 * 
	 * @param View
	 *            v
	 * @return
	 */
	private Direction getSpecificDirection(View v) {
		// The random walker first decides what directions it can move in. The
		// walker cannot move in a direction which is blocked by a wall.
		List<Direction> possibleDirections = determinePossibleDirections(v);

		// Second, the walker chooses a random direction from the list of
		// possible directions
		return canMove(possibleDirections, v); 
	}

	/**
	 * Determine the list of possible directions. That is, the directions which
	 * are not blocked by a wall.
	 * 
	 * @param v
	 *            The View object, with which we can determine which directions
	 *            are possible.
	 * @return
	 */
	private List<Direction> determinePossibleDirections(View v) {
		Direction[] allDirections = Direction.values();
		ArrayList<Direction> possibleDirections = new ArrayList<Direction>();
		for (Direction d : allDirections) {
			if (v.mayMove(d)) {
				// Yes, this is a valid direction
				possibleDirections.add(d);
			}
		}

		return possibleDirections;
	}

	/*private boolean canLeft(View v, Direction directionON) {
		Direction left = hasLeft(directionON);
		return !v.mayMove(left);
	}*/




	/**
	 * Select a random direction from a list of possible directions.
	 * 
	 * @param possibleDirections
	 * @return
	 */
	/*private Direction selectRandomDirection(List<Direction> possibleDirections) {
		int random = (int) (Math.random() * possibleDirections.size());
		return possibleDirections.get(random);
	}*/

	private Direction hasLeft(Direction directionON) {
		if (directionON == Direction.NORTH) {
			return Direction.WEST;
		} 
		else if (directionON == Direction.EAST) {
			return Direction.NORTH;
		} 
		else if (directionON == Direction.SOUTH) {
			return Direction.EAST;
		} 
		else if (directionON == Direction.WEST) {
			return Direction.SOUTH;
		}
		return null;
	}
	private Direction hasFront(Direction directionON) {
		return directionON;
	}

	private Direction hasRight(Direction directionON) {
		if(directionON == Direction.NORTH) {
			return Direction.EAST;
		}
		else if(directionON == Direction.EAST) {
			return Direction.SOUTH;
		}
		else if(directionON == Direction.SOUTH) {
			return Direction.WEST;
		}
		else if(directionON == Direction.WEST) {
			return Direction.NORTH;
		}
		return null;
	}

	private Direction hasBack(Direction directionON) {
		if (directionON == Direction.NORTH) {
			return Direction.SOUTH;
		} 
		else if (directionON == Direction.EAST) {
			return Direction.WEST;
		} 
		else if (directionON == Direction.SOUTH) {
			return Direction.NORTH;
		} 
		else if (directionON == Direction.WEST) {
			return Direction.EAST;
		}
		return null;
	}
	//makes it turn clockwise
	private Direction clockwise(Direction directionON) {
		if(directionON == Direction.NORTH) {
			return Direction.EAST;
		}
		else if(directionON == Direction.EAST) {
			return Direction.SOUTH;
		}
		else if(directionON == Direction.SOUTH) {
			return Direction.WEST;
		}
		else if(directionON == Direction.WEST) {
			return Direction.NORTH;
		}
		return null;
	}

	//makes it turn anticlockwise
	private Direction anticlockwise(Direction directionON) {
		if(directionON == Direction.NORTH) {
			return Direction.WEST;
		}
		else if(directionON == Direction.EAST) {
			return Direction.NORTH;
		}
		else if(directionON == Direction.SOUTH) {
			return Direction.EAST;
		}
		else if(directionON == Direction.WEST) {
			return Direction.SOUTH;
		}
		return null;
	}
	
	private boolean emptyWalls(View v){
	    //tells the walker whether it has walls sround it, true if it doesn't
	    if(!v.mayMove(Direction.NORTH){ return false;}
	    if(!v.mayMove(Direction.EAST){return false;}
	    if(!v.mayMove(Direction.SOUTH){return false;}
	    if(!v.mayMove(Direction.WEST){return false;}
	    return true;
	   }

	//whether it may move 
	private Direction canMove(List<Direction>possibleDirections, View v) {

		//checks whether it can go in the directions
		boolean canGoLeft = v.mayMove(hasLeft(directionON)); 
		boolean canGoRight = v.mayMove(hasRight(directionON));
		boolean canGoFront = v.mayMove(hasFront(directionON));
		boolean canGoBack = v.mayMove(hasBack(directionON));
		
		if(canGoLeft){
		    if(emptyWalls){
		        directionON = Direction.NORTH;
		        return directionON;
		      }
		      else{
		          if(hasLeft(directionON)){
		              clockwise(directionON);
		          }
		      }
		  }
		  else{
		      if(!canGoFront){
		          if(canGoLeft){
		              directionON = hasLeft(directionON);
		              
		          }
		          else{
		              clocks}}}
     
		//if there are no walls go north

		//if it can go left and has some walls, go turn left
		/*if(canGoLeft && possibleDirections.size() < 4) { 
			//if it cant go to the left and cant 
			if(canGoLeft) {
				//while(canGoLeft) {
				System.out.println("CLOCKWISE");
				directionON = anticlockwise(directionON);
				//directionON = hasLeft(directionON);
				//return directionON;//hasLeft(directionON);
				//}
			}
			/*else {
				System.out.println("ANTICLOCKWISE");
				directionON = clockwise(directionON);
				//return directionON;
			}*/
		}
		//if there are no walls
		if(possibleDirections.size() == 4) {
			directionON = Direction.NORTH;
			//return directionON;
		}

		/*if(canGoFront) {
			return directionON;
		}*/
		//if it can go in the facing direction keep going
		if(v.mayMove(directionON)) {
			return directionON;
		}
		//if it gets stopped by a wall in front turn in the clockwise direction
		else {
			System.out.print(" TURN ");
			directionON = clockwise(directionON);
		}*/
		/*else if(!canGoLeft && possibleDirections.size() <4) { //&& possibleDirections.contains(directionON)) {
			System.out.print(" TURN ");
			directionON = clockwise(directionON);
		}*/

		/*else if(!v.mayMove(Direction.NORTH)) {
			System.out.print( "WORK");
			directionON = clockwise(directionON);
		}*/
		/*else if(!canGoLeft && !canGoRight && !canGoFront) {
			System.out.print("Do this");
			return hasBack(directionON);
		}*/

		return null;
	}

}
