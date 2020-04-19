// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 5
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/** Frog
 *  A new frog starts at the given position, with the given direction, and 
 *     has either a "light" or "dark" shade.
 *  Frogs can turn in 4 directions: left, right, up, and down. 
 *  Frogs move around at a constant speed in an arena with an enclosing wall,
 *     following its direction, until it hits a wall. In which case it stops moving.
 *  Frog can grow in size, and (for the completion) can also shrink by resetting their size
 *      to the orginal value.
 *
 *  The walls of the arena are determined by the constants:
 *    FrogGame.TopWall, FrogGame.BotWall, FrogGame.LeftWall and FrogGame.RightWall
 */

public class Frog {
    // Constants
    public static final int INITIAL_SIZE = 30;
    public static final int GROWTH_RATE = 1;
    public static final int SPEED = 2;

    // Fields
    public double x=0;
    public double y=0;
    public int size=INITIAL_SIZE;

    public String direction="";
    public String shade="";

    /*# YOUR CODE HERE */
    //Constructor 
    /** 
     * Make a new frog
     * The parameters specify the initial position of the top left corner,
     *   the direction, and the shade of the Frog ("light" or "dark")
     * We assume that the position is within the boundaries of the arena
     */
    public Frog(double left, double top, String dir, String shade)  {
        /*# YOUR CODE HERE */
        x=left;
        y=top;
        direction=dir;
        shade=shade;

    }

    /**
     * Turn right
     */
    public void turnRight(){
        /*# YOUR CODE HERE */
        direction = "right";

    }

    /**
     * Turn left
     */
    public void turnLeft(){
        /*# YOUR CODE HERE */
        direction = "left";
    }

    /**
     * Turn up
     */
    public void turnUp(){
        /*# YOUR CODE HERE */
        direction = "up";

    }

    /**
     * Turn down
     */
    public void turnDown(){
        /*# YOUR CODE HERE */
        direction = "down";
    }

    /**
     * Moves the frog: 
     *   use SPEED unit forward in the correct direction
     *   by changing the position of the frog.
     * Make sure that the frog does not go outside the arena, by making sure 
     *  - the top of the frog is never smaller than FrogGame.TopWall
     *  - the bottom of the frog is never greater than FrogGame.BotWall
     *  - the left of the frog is never smaller than FrogGame.LeftWall
     *  - the right of the frog is never smaller than FrogGame.RightWall
     */
    public void move() {
        /*# YOUR CODE HERE */
        
        /*while*/
        if(y>FrogGame.TopWall&&x>FrogGame.LeftWall&&(y+size)<FrogGame.BotWall&&(x+size)<FrogGame.RightWall) {
            if(direction.equals("right")){
                x=x+2;
            }
            if(direction.equals("left")){
                x=x-2;
            }
            if(direction.equals("down")){
                y=y+2;
            }
            if(direction.equals("up")){
                y=y-2;
            }
        }

         //if(dir.equals("")){
             else{
            if(y>FrogGame.TopWall){
                y=y-2;
            }
            if((y+size+2)<FrogGame.BotWall){
                y=y+2;
            }
            if(x>FrogGame.LeftWall){
                x=x-2;
            }
            if((x+size+2)<FrogGame.RightWall){
                x=x+2;
            }
        }

    }

    /**
     * Check whether the frog is touching the given point, eg, whether the
     *   given point is included in the area covered by the frog.
     * Return true if the frog is on the top of the position (x, y)
     * Return false otherwise
     */
    public boolean touching(double X, double Y) {
        /*# YOUR CODE HERE */
        if(X<x + size && X>x && Y<y+size && Y>y){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * The Frog has just eaten a bug
     * Makes the frog grow larger by GROWTH_RATE.
     */
    public void grow(){
        /*# YOUR CODE HERE */
        size = size + GROWTH_RATE;

    }
    /**
     * The Frog has just bumped into a snake
     * Makes the frog size reset to its original size
     * ONLY NEEDED FOR COMPLETION
     */
    public void shrink(){
        /*# YOUR CODE HERE */
        size = INITIAL_SIZE;

    }

    /**
     * Draws the frog at the current position.
     */
    public void draw(){
        /*# YOUR CODE HERE */
        if(shade.equals("dark")){
            UI.drawImage("darkfrog.JPG", x, y, size, size);
        }
        else{
            UI.drawImage("lightfrog.JPG", x, y, size, size);
        }

    }
}

