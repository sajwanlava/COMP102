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

/** The snake is created at a random position with a random direction.
 * The constructor does not have any parameters.
 * It can move
 *  - makes it go forward one step in its current direction.
 *  - if outside arena boundaries, makes it go backward one step, and then turn to a new (random)
 *         direction.
 *  The walls of the arena are determined by the constants:
 *    FrogSnakeGame.TopWall, FrogSnakeGame.BotWall, FrogSnakeGame.LeftWall and FrogSnakeGame.RightWall
 * It can report its current position (x and y) with the
 *  getX() and getY() methods.
 *  draw() will make it draw itself,
 *  erase() will make it erase itself
 */

public class Snake{
    /*# YOUR CODE HERE */
    //fields
    private double left;
    private double top;
    private double direction;

    public Snake(){
        this.left = FrogGame.LeftWall+Math.random()*(FrogGame.RightWall-40);
        this.top = FrogGame.TopWall+Math.random()*(FrogGame.BotWall-50);
        this.direction = Math.random();
        this.draw();
    }

    public void move(){
        this.erase();
        //things
        this.draw();
    }


    public void draw()
    {
        UI.drawImage("snake.jpg", this.left, this.top, 40, 50);
    }

    public void erase()
    {
        UI.eraseImage("snake.jpg", this.left, this.top);
    }

    
}
