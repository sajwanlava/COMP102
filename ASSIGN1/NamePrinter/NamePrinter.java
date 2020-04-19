// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for Assignment 1, COMP 102
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/** A very simple program that prints out a name in two different ways*/
public class NamePrinter {


    /**
     * Constructor: Set up the GUI and the buttons
     */
    public NamePrinter(){
        UI.initialise();                            // initialise the UI window.
        UI.addButton("Print", this::printNameTag ); // make buttons and specify
        UI.addButton("Draw", this::drawNameTag );   // what actions they do.
        UI.addButton("Quit", UI::quit );
    }


  /**
   * Print a nametag with a name inside a box made of asterisks
   */
  public void printNameTag() {
      UI.clearText();                 // clears the text pane
      String name = UI.askString("What is your name");
      UI.println("*********************************");
      UI.println("*                               *");
      UI.println("*  HELLO, my name is            *");
      UI.println("*                               *");
      UI.println("*          " + name + "               *");
      UI.println("*                               *");
      UI.println("*********************************");
      UI.println();
     
  }


  /**
   * Draw a nametag on the graphics pane
   *  The rectangular nametag is 300 units wide and 150 units high
   *  and the left edge is 100 units over and the top is 70 units down
   */
    public void drawNameTag(){
        UI.clearGraphics();                            // clears the graphics pane
        String name = UI.askString("What name do you want on your tag?");
        UI.setFontSize(24);
        UI.setColor(Color.blue);
        UI.drawRect(100, 70, 600, 300);                // draws the outline of a rectangle
        UI.drawString("Hi I'm", 120, 125);  // puts the string near the top
        UI.drawString(name,  200, 170);                // puts the name near the center
    }



}
