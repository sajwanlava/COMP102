// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 8 
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/** 
 *
 * duckGame():
 *     construct array of objects,
 *     call methods on them,
 *     remove them
 *  Uses an array with nulls.
 *
 */

public class ArrayObjectsExercise{

    /**
     * Simple duck shooting game
     *  Uses the Duck class, which has a constructor and two methods:
     *   - To construct a duck, specify its horizontal position: eg new Duck(100);
     *   - jiggle() makes the duck jump up and down a few times
     *   - shoot() turns it upside down. You can't jiggle a duck after you have shot it.
     * 
     * The duckGame method should
     * - Construct an array to hold 5 Ducks,
     * - Fill the array with Ducks placed across the screen (at 200, 300, 400, 500, 600)
     *       The Duck constructor has one parameter - the position of the duck.
     *       the position of the i'th duck should be 200+(i*100)
     * - Have a loop that repeats 5 times:
     *   - Ask the user for the number of a duck to shoot ( 0 to 4)
     *   - IF the answer is valid and that element of the array contains a duck, THEN
     *      shoot the duck (call the shoot method on the duck), 
     *      remove it from the array (put null in the array element)
     *     ELSE
     *      tell the user they missed
     *   - jiggle all the remaining ducks (each array element that isn't null)
     */
    public void doDuckGame(){
        Duck[] ducks = new Duck[5];
        // make five Ducks and put them in the array.
        /*# YOUR CODE HERE */

        // repeat five times:
        for (int loop=0; loop<5; loop++){
            int index = UI.askInt("Which duck should I shoot?");
            // shoot the duck, (if it is still in the array)
            // and remove it from the array.
            // make each remaining duck jiggle
            /*# YOUR CODE HERE */

        }
        UI.println("That's all your shots");
    }

    /** ---------- The code below is already written for you ---------- **/
    /**
     * Constructor to set up an interface with buttons to call all the methods
     */
    public ArrayObjectsExercise(){
        UI.addButton("Clear", UI::clearPanes);
        UI.addButton("Duck Game", this::doDuckGame);
        UI.addButton("Quit", UI::quit);
    }

    public static void main(String[] args){
        new ArrayObjectsExercise();
    }        

}
