// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 10
 * Name:
 * Usercode:
 * ID:
 */

import java.util.*;
import ecs100.*;
import java.awt.Color;
import java.io.*;

/** Rectangle represents a solid rectangle shape
 *   Implements the Shape interface.
 *   Needs fields to record the position, size, and colour
 */

public class Rectangle implements Shape {
    //fields

    private double x1; 
    private double y1;
    private double x2;  
    private double y2;
    private Color col;  // the colour of the line

    /** Constructor with explicit values
     *  Arguments are the x and y of the top left corner,
     *  the width and height, and the color. 
     */
    public Rectangle(double x, double y, double wd, double ht, Color col) {

        this.x1 = x;
        this.y1 = y;
        this.x2 = wd;
        this.y2 = ht;
        this.col = col;

    }

    /** [Completion] Constructor which reads values from a String
     *  that contains the specification of the Rectangle. 
     *  The format of the String is determined by the toString method.
     *     The first 3 integers specify the color;
     *     the following four numbers specify the position and the size.
     */
    public Rectangle(String description) {
        Scanner data = new Scanner(description);
        int red = data.nextInt();
        int green = data.nextInt();
        int blue = data.nextInt();
        this.col = new Color(red,green,blue);
        this.x1 = data.nextDouble();
        this.y1 = data.nextDouble();
        this.x2 = data.nextDouble();
        this.y2 = data.nextDouble();
    }

    /** Returns true if the point (u, v) is on top of the shape */
    public boolean on(double u, double v) {

        if (u >= this.x1 && u <= (this.x1+this.x2) && v >= this.y1 && v <= (this.y1+this.y2)){
            return true;
        }

        return false;
    }

    /** Changes the position of the shape by dx and dy.
     *  If it was positioned at (x, y), it will now be at (x+dx, y+dy)
     */
    public void moveBy(double dx, double dy) {
        /*# YOUR CODE HERE */
        UI.clearGraphics();
        this.x1 += dx;
        this.y1 += dy;
        this.redraw();

    }

    /** Draws the rectangle on the graphics pane. 
     *  It draws a black border and fills it with the color of the rectangle.
     */
    public void redraw() {
        UI.setColor(this.col);
        UI.fillRect(this.x1, this.y1, this.x2, this.y2);
        UI.setColor(Color.black);
        UI.drawRect(this.x1, this.y1, this.x2, this.y2);

    }

    /** [Completion] Changes the width and height of the shape by the
     *  specified amounts.
     *  The amounts may be negative, which means that the shape
     *  should get smaller, at least in that direction.
     *  The shape should never become smaller than 1 pixel in width or height
     *  The center of the shape should remain the same.
     */
    public void resize (double changeWd, double changeHt) {

        if (x2 > 1 && y2 >1){
            this.x2 += changeWd;
            this.y2 += changeHt;
            this.redraw ();
        }

    }

    /** Returns a string description of the rectangle in a form suitable for
     *  writing to a file in order to reconstruct the rectangle later
     *  The first word of the string must be Rectangle 
     */
    public String toString() {

        return ("rect "+col.getRed()+" "+col.getGreen()+" "+col.getBlue()+" "+this.x1+" "+this.y1+" "+this.x2+" "+this.y2);

        //return null ; 
    }

}
