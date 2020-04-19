// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 102 Assignment 10
 * Name:
 * Usercode:
 * ID:
 */

import java.util.*;
import ecs100.*;
import java.awt.Color;
import java.io.*;

/** Polygon represents a polygon made of a sequence of straight lines.
 *  Implements the Shape interface.
 *  Has a field to record the colour of the line and two fields to store
 *  lists of the x coordinates and the y coordinates of all the vertices
 */

public class Polygon implements Shape{
    private ArrayList<Double> xPoints = new ArrayList<>();
    private ArrayList<Double> yPoints = new ArrayList<>();
    private int totalPoints;
    private Color col;

    public Polygon (Color col ){
        this.col = col;
    }

    public Polygon (String description) {
        Scanner data = new Scanner(description);
        int red = data.nextInt();
        int green = data.nextInt();
        int blue = data.nextInt();
        this.col = new Color(red,green,blue);
        while (data.hasNextDouble()){
            xPoints.add(data.nextDouble());
            yPoints.add(data.nextDouble());
        }
        totalPoints = xPoints.size();
        //this.x2 = data.nextDouble();
        //this.y2 = data.nextDouble();
    }

    public boolean on(double u, double v){
        // an easy approximation is to pretend it is the enclosing rectangle.
        // It is nicer to do a little bit of geometry and get it right
        /*# YOUR CODE HERE */ 
        return false;
    }

    public void moveBy(double dx, double dy){
        /*# YOUR CODE HERE */

    }

    public void redraw(){
        UI.setColor(col);
        double[] x= new double[totalPoints];
        double[] y= new double[totalPoints];
        for (int i = 0; i < totalPoints ; i++) {
            x[i]= this.xPoints.get(i);
            y[i]= this.yPoints.get(i);
        }
        UI.setColor(col);
        UI.fillPolygon(x,y,totalPoints);
        UI.setColor(Color.BLACK);
        UI.drawPolygon(x,y,totalPoints);

    }

    public void resize(double changeX, double changeY){

    }

    public String toString(){
        return null;
    }
}

