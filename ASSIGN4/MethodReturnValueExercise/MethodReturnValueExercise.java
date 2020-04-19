// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for Assignment 4, COMP102 
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

public class MethodReturnValueExercise {

    /** Ask for two numbers
     *  and states whether one if a multiple of the other one */
    public void checkNumbers(){
        int num1 = UI.askInt("Enter first number ");
        int num2 = UI.askInt("Enter second number");

        if (isMultiple(num1, num2)) {
            UI.println( num1 + " is a multiple of " + num2);
        }
        else if (isMultiple(num2, num1)) {
            UI.println( num2 + " is a multiple of " + num1);
        }
        else {
            UI.println("not multiple");
        }
    }

    /** Return true if the first argument is a multiple of the second one.
     *  Return false if the first argument is NOT a multiple of the second one
     *  HINT: n1 is a multiple of n2 if the result of n1%n2 is 0
     */
    public /*# YOUR CODE HERE */      isMultiple (/*# YOUR CODE HERE */ ){
        /*# YOUR CODE HERE */ 

    }

    /* Tell the user to enter a sequence of numbers, ending with the word 'done'
     * then read all the numbers in a loop, printing out the letter score of each number as it goes.
     */
    public void printScores(){
        UI.print("Enter some numbers, ending with 'done': ");
        while (UI.hasNextDouble()){
            double mark = UI.nextDouble();
            UI.println(mark + " corresponds to: " + letterScore(mark));
        }
        UI.next();  // Read and throw away the 'done' 
    }

    /** Return the corresponding grade to the given mark.
     */
    public /*# YOUR CODE HERE */    letterScore (/*# YOUR CODE HERE */ ){
        /*# YOUR CODE HERE */ 

    }

    /** ---------- The code below is already written for you ---------- **/

    /** Constructor to set up the user interface */
    public MethodReturnValueExercise(){
        UI.initialise();
        UI.addButton("Clear", UI::clearText );
        UI.addButton("Check numbers", this::checkNumbers );
        UI.addButton("Print scores", this:: printScores);
        UI.setDivider(1);
        UI.addButton("Quit", UI::quit );
    }


}
