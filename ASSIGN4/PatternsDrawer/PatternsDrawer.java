// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 4, 
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;

/** PatternsDrawer
Draw various patterns. */

public class PatternsDrawer{

    public static final double boardLeft = 50;   // Top left corner of the board
    public static final double boardTop = 50;
    public static final double boardSize = 300;  // The size of the board on the window

    /** Draw a square grid board with white squares.
     *  Asks the user for the number of squares on each side
     *
     *  CORE
     */
    public void drawGridBoard(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:"); //total column and rows
       
        int col = 0; //start column
        int row = 0; //start row
        int size = 15; //15 by 15 square
        while(row<num){ //when start row is less than num
            col = 0;
            while(col<num){ // when col
                double x = boardLeft+col*size;
                double y = boardTop+row*size;
                UI.drawRect(x,y,size,size);
                col++;
            }
            row++;
        }

    }

    /** Illusion
     *  a pattern that makes dark circles appear in the intersections
     *  when you look at it. 
     *
     *  CORE
     **/
    public void drawIllusion(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:"); //total column and rows
        int col = 0; //start column
        int row = 0; //start row
        int size = 15; //10 by 10 square
        double x = boardLeft;
        double y = boardTop;
        for(row=num; row<=num ; row--){ //minus rows 
            x = boardLeft;
            for(col=0; col<num; col++){ //for col is less than num add more coll 
                x = x+20;
                UI.fillRect(x,y,size,size);
            }
            y = y+20;
            num--; //minus num
        }
    }

    /** Draw a checkered board with alternating black and white squares
     *    Asks the user for the number of squares on each side
     *
     *  COMPLETION
     */
    public void drawCheckersBoard(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:"); //total column and rows
        int col = 0; //start column
        int row = 0; //start row
        int size = 15; //15 by 15 square
        
        while(row<num){ //when start row is less than num
            col = 0;
            while(col<num){ // when col is less than row
                //start position
                double x = boardLeft+col*size;
                double y = boardTop+row*size;
                
                if(row%2 == col%2){ //if the remainder of the row div by 2 and col div by  2 are equall than draw fillRecgt
                    UI.fillRect(x,y,size,size);
                }
                else{ //otherwise drawRect
                    UI.drawRect(x,y,size,size);
                }
                col++;
            }
            row++;
        }

    }

    /** Draw a board made of concentric circles, 2 pixel apart
     *  Asks the user for the number of squares on each side
     *
     *  CHALLENGE
     */
    public void drawConcentricBoard(){
        UI.clearGraphics();
        int num = UI.askInt("How many rows:"); //total column and rows
        int row = 0; //start row
        int size = 70; //70 by 70 circle
        int ring = 0; // inner circles
        
        while(row<num){ //when start row is less than num
            int col = 0; //start column
            while(col<num){ // when col
                double x = boardLeft+col*size; //start x position/top left
                double y = boardTop+row*size; //start y position/top left
                UI.drawOval(x, y, size, size); //draw outer oval
                while(ring<=size){
                    UI.drawOval(x+ring/2, y+ring/2, size-ring, size-ring); //draw inner ovals
                    ring = ring +3; //make the inner circle bigger so diameter becomes smaller as in the diam parameters of the draw oval in this loop
                }
                ring = 0; //set ring back to zero
                col++; //next column
            }
            row++; //next row 
        }
        
    }

    /*# YOUR CODE HERE */

    /** ---------- The code below is already written for you ---------- **/
    public PatternsDrawer(){
        UI.initialise();
        UI.addButton("Clear",UI::clearPanes);
        UI.addButton("Core: Grid", this::drawGridBoard);
        UI.addButton("Core: Illusion", this::drawIllusion);
        UI.addButton("Completion: Checkers", this::drawCheckersBoard);
        UI.addButton("Challenge: Concentric", this::drawConcentricBoard);
        UI.addButton("Quit",UI::quit);
    }   

}
