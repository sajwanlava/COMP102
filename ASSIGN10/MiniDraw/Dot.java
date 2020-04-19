// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 10
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.util.*;
import java.awt.Color;
import java.io.*;

/** Dot represents a small circle shape of a fixed size (5 pixels)
 *   Implements the Shape interface.
 *   Needs fields to record the position, and colour
 */

public class Dot implements Shape{
   
    private double x1;
    private double y1;
    //private double x2 = 5;
    //private double y2 = 5;
    private Color col;

    public Dot (double x, double y,  Color col ){
        this.x1 = x;
        this.y1 = y;
        //this.diam = diam;
        this.col = col;
    }

    public Dot (String description) {
        Scanner data = new Scanner(description);
        int red = data.nextInt();
        int green = data.nextInt();
        int blue = data.nextInt();
        this.col = new Color(red,green,blue);
        this.x1 = data.nextDouble();
        this.y1 = data.nextDouble();
        //this.x2 = data.nextDouble();
        //this.y2 = data.nextDouble();
    }

    public boolean on(double u, double v){
        // an easy approximation is to pretend it is the enclosing rectangle.
        // It is nicer to do a little bit of geometry and get it right
        /*# YOUR CODE HERE */
        double threshold = 3;

        if(u >= this.x1 && u <= (this.x1+threshold) && v >= this.y1 && v <= (this.y1+threshold)){
            return true;
        }

        return false; 
    }

    public void moveBy(double dx, double dy){
        /*# YOUR CODE HERE */
        UI.clearGraphics();
        this.x1 += dx;
        this.y1 += dy;
        this.redraw();

    }

    public void redraw(){
        /*# YOUR CODE HERE */
        //UI.clearGraphics();
        UI.setColor(this.col);
        UI.fillOval(this.x1, this.y1, 5, 5);
        UI.setColor(Color.black);
        UI.drawOval(this.x1, this.y1, 5, 5);

    }

    public void resize(double changeX, double changeY){

    }

    public String toString(){
        return ("dot"+col.getRed()+" "+col.getGreen()+" "+col.getBlue()+" "+this.x1+" "+this.y1);
    }
}
