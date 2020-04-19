// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 102 Assignment 5 
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;

/** Program to create simple animated animal character using the
 *  Animal class.  
 */

public class PetShow{
    /** animate creates two animals on the window.
     *  Then animates them according to a fixed script by calling a series
     *  of methods on the animals.
     *  
     *  CORE
     */
    public void animate(){
        //making the new characters
        Animal a1 = new Animal("tiger", "Sher Khan", 100, 200); 
        Animal a2 = new Animal("snake", "Kaa", 350, 200);

        a2.speak("Sss I want the man cub");
        a1.shout("I will have him");
        //starts at that x point to keep point for the while loop
        int x1 = 100; 
        while(x1<=250){
            double fwd = 25; //move forward each time
            x1 = x1 + 25; // moves count along the x point
            a1.goForward(fwd);
        }
        a1.speak("Give him to me");
        a1.shout("roar");

        a2.jump(30);

        int x2 = 350;
        while(x2<=410){
            double bkw = 30;
            x2 = x2 + 30;
            a2.goBackward(bkw);
        }
        
        a1.speak("Sssorry Sher Khan");
        a1.speak("I won't disresspect you again");
        a1.speak("lasst I saw the man cub he");
        a1.speak("wass with the ssstupid bear");
        //a1.speak("bear");
        

    }

    /** threeAnimalsRoutine creates three animals on the window.
     *  Then makes each animal do the same routine in turn.
     *  You should define a routine method, and threeAnimalsRoutine
     *   should call the routine method three times, to make
     *   each of the three animals perform the routine in turn.
     *   
     *   COMPLETION
     */
    public void threeAnimalsRoutine(int goForward, int goBackward, int jump, String speak){
        /*# YOUR CODE HERE 
        Animal a1 = new Animal("dinosaur", "turt", 100, 200); 
        Animal a2 = new Animal("dog", "dino", 350, 200);
        Animal a3 = new Animal("turtle", "doggy",500 , 200); */
        

    }

    /** ---------- The code below is already written for you ---------- **/

    /** Constructor: set up user interface */
    public PetShow(){
        UI.initialise();
        UI.addButton("Clear", UI::clearGraphics );
        UI.addButton("Animate", this::animate );
        //UI.addButton("Three", this::threeAnimalsRoutine );
        UI.addButton("Quit", UI::quit );
        UI.setDivider(0);       // Expand the graphics area
    }

    public static void main(String[] args){
        new PetShow();
    }

}

