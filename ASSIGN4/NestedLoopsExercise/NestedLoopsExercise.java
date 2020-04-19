// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for Assignment 4
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** NestedLoopsExercise is a collection of small methods with nested while loops
 */
public class NestedLoopsExercise{

    /* Print some '*' to form a triangular shape.
     *    For example, if the argument is 5, it should print
     *    *
     *    **
     *    ***
     *    ****
     *    *****
     */
    public void printStars(int size){
        /*# YOUR CODE HERE */

    }

    /* Print some numbers to form a triangular shape.
     *    For example, if the size was 5, it should print (the . represents a space)
     *    ....1
     *    ...22
     *    ..333
     *    .4444
     *    55555
     */
    public void printNumbers(){
        int size = 5;
        /*# YOUR CODE HERE */

    }

    /** ---------- The code below is already written for you ---------- **/
    /** Constructor: set up user interface */
    public NestedLoopsExercise(){
        UI.initialise();
        UI.addButton("Clear", UI::clearText );
        UI.addButton("triangle with stars", () -> this.printStars(UI.askInt("printStars(int size")));
        UI.addButton("triangle with numbers", this::printNumbers);
        UI.setDivider(1.0);
        UI.addButton("Quit", UI::quit );
    }


}
