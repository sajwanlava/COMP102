// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 2
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/**
 * Draws various symbols: flags, signs, and car logos
 *
 * The correct dimensions of the official flags varies from country to country,
 * The exact colours of the flags will also be difficult to match;
 * It is fine to use the standard colours: red, green, blue, orange, etc
 * You can find lots of flag details (including the correct dimensions and colours)
 * from   http://www.crwflags.com/fotw/flags/    
 */
public class SymbolDrawer{

    public static final double top = 100;
    public static final double left = 50;

    /** The flag of Belgium has three vertical stripes;
     *  The left is black, the middle is yellow, and the right is red.
     *  The flag is 13/15 as high as it is wide (ratio 13:15).
     *  CORE
     */
    public void belgiumFlag(){
        /*# YOUR CODE HERE */
        double width = UI.askDouble("What is the width?");
        double height = width*2/3;
        UI.clearGraphics();
        UI.setColor(Color.black);
        UI.fillRect(left,top,width,height);
        UI.setColor(Color.yellow);
        UI.fillRect(left+width/3,top,width/3,height);
        UI.setColor(Color.red);
        UI.fillRect(left+width*2/3,top,width/3,height);
        UI.setColor(Color.black);
        UI.drawRect(left,top,width,height);

    }

    /** The first aid sign consists of a green square with a big centred white cross
     *  CORE
     */
    public void firstAidSign() {
        /*# YOUR CODE HERE */
        double size = UI.askDouble("What is the size?");
        double height = size;
        UI.clearGraphics();
        UI.setColor(Color.green);
        UI.fillRect(left,top,size,size);
        UI.setColor(Color.black);
        UI.drawRect(left,top,size,size);
        UI.setColor(Color.white);
        UI.fillRect(left+size*0.4,top+size*0.1,size*0.2,size*0.8);
        UI.fillRect(left+size*0.1,top+size*0.4,size*0.8,size*0.2);

    } 

    /**
     *  The unofficial flag of Palmyra Atoll has three horizontal stripes with part of a yellow circle.
     *  The flag is 2/3 as high as it is wide (ratio 2:3).
     *  The top stripe is red and is 1/2 of the height of the flag.
     *  The middle stripe is blue and is 7/20 of the height of the flag.
     *  The bottom stripe is yellow and is 3/20 of the height of the flag.
     *  The diameter of the yellow circle is 1/2 of the width of the flag, 
     *      and its top is slightly below the top of the flag.
     *  HINT: think in which order to paint the different parts of the flag.
     *  CORE
     */
    public void palmyraFlag() {
        /*# YOUR CODE HERE */
        double width = UI.askDouble("What is the width?");
        double height = width*2/3;
        UI.clearGraphics();
        UI.setColor(Color.red);
        UI.fillRect(left,top,width,height);
        UI.setColor(Color.yellow);
        UI.fillOval(left+width/4,top+height/25,width/2,width/2);
        //UI.setColor(Color.black);
        //UI.drawOval(left+width/4,top+height/25,width/2,width/2);
        UI.setColor(Color.blue);
        UI.fillRect(left,top+height/2,width,height*0.35);
        //UI.setColor(Color.black);
        //UI.drawRect(left,top+height/2,width,height*0.35);
        UI.setColor(Color.yellow);
        UI.fillRect(left,top+height*0.85,width,height*0.15);
        UI.setColor(Color.black);
        // UI.drawRect(left,top+height*0.85,width,height*0.15);
        UI.drawRect(left,top,width,height);

    }

    /**
     *  The flag of the United Arab Emirates is divided into four rectangular parts.
     *  The first red rectangle is the vertical band nearest to the mast, its length being
     *  equivalent to the height of the flag, while its width is one quarter of the length of
     *  the entire flag.
     *  The other three parts are three horizontal stripes of equal size.
     *  The top most is green, the middle is white and the lower is black.
     *  The flag is 1/2 as high as it is wide (ratio 1:2).
     *  COMPLETION
     */
    public void uaeFlag() {
        /*# YOUR CODE HERE */
        double width = UI.askDouble("Please enter the width");
        double height = width * 1/2;
        UI.clearGraphics();
        UI.setColor(Color.black);
        UI.fillRect(left,top,width,height);
        UI.setColor(Color.green.darker());
        UI.fillRect(left,top,width,height/3);
        UI.setColor(Color.white);
        UI.fillRect(left,top+(height/3),width,height/3);
        UI.setColor(Color.red);
        UI.fillRect(left, top, (width/4), height);
        UI.setColor(Color.black);
        UI.drawRect(left,top,width,height);

    }

    /** Pacman
     *  A red pacman facing up on a black background chasing yellow, green, and blue dots.
     *  COMPLETION
     */
    public  void pacman() {
        double width = UI.askDouble("What is the width?");
        double length = width*1.5;
        UI.clearGraphics();
        UI.setColor(Color.black);
        UI.fillRect(left,top,width,length);
        UI.setColor(Color.red);
        UI.fillOval(left+width/4,top+length/2,width/2,width/2);
        UI.setColor(Color.black);
        UI.fillArc(left+width/4,top+length/2,width/2,width/2,65,50);
        UI.setColor(Color.yellow);
        UI.fillOval(left+width/2-width/20,top+length/2-width/10,width/10,width/10);
        UI.setColor(Color.green);
        UI.fillOval(left+width/2-width/20,top+length/2-(3*width/10),width/10,width/10);
        UI.setColor(Color.blue);
        UI.fillOval(left+width/2-width/20,top+length/2-(5*width/10),width/10,width/10);

        
    }
    /** Mitsubishi
     * 
     *  CHALLENGE
     */
    public void mitsubishiLogo() {
        /*# YOUR CODE HERE */
        double width = UI.askDouble("Please enter the size");
        double height = width;

        UI.clearGraphics();
        UI.setColor(Color.black);
        UI.drawRect(left,top,width,height);
        UI.setColor(Color.red);
        double [] x = {left+width/2, left+width-(11*width/12),left+width-width/12 };
        double [] y = {(2*left)+10,height+70,height+70};
        UI.fillPolygon(x,y,3);
        
        UI.setColor(Color.white);
        double [] x1 = {left+width/2,left+width-(8*width/12),left+width-(4*width/12)};
        double [] y1 = {(2*left)+10,height+70,height+70};
        UI.fillPolygon(x1,y1,3);

    }

    /** The Koru flag belongs to the long list of new flags designs
     *  It has been designed by Sven Baker from Wellington
     *  The flag is 1/2 as high as it is wide (ratio 1:2).
     *  CHALLENGE
     */
    public void koruFlag() {
        /*# YOUR CODE HERE */
        double width = UI.askDouble("Please enter the width");
        double height = width * 1/2;
        UI.clearGraphics();
        UI.setColor(Color.black);
        UI.drawRect(left,top,width,height);
        UI.setColor(Color.red);
        UI.fillRect(left, top, width, height);
        UI.setColor(Color.blue.darker());
        UI.fillRect(left + (width/2),top,(width/2),height);
        UI.setColor(Color.white);
        UI.fillOval(left + width/4, top, height, height);
        UI.setColor(Color.blue.darker());
        UI.fillOval((left + width/4) + (height - height*3.5/5)/2, top + (height - height*3.5/5)/2 , height*3.5/5, height*3.5/5);
        UI.setColor(Color.blue.darker());
        UI.fillOval(left + (width*3.23/5), top + (height*1.25/3), width*1/9,width*1/9);
        UI.setColor(Color.white);
        UI.fillOval(left + (width*3.05/5), top + (height*1.25/5), width*1.30/9,width*1.30/9);

    }

    /** ---------- The code below is already written for you ---------- **/
    /** Constructor, sets up the user interface */
    public SymbolDrawer(){
        UI.initialise();

        // CORE
        UI.addButton("Core: Flag of Belgium", this::belgiumFlag);
        UI.addButton("Core: First Aid", this::firstAidSign);
        UI.addButton("Core: Flag of Palmyra Atoll", this::palmyraFlag);

        // COMPLETION
        UI.addButton("Completion: Flag of UAE", this::uaeFlag);
        UI.addButton("Completion: Pacman", this::pacman);

        // CHALLENGE
        UI.addButton("Challenge: Mitsubishi", this::mitsubishiLogo);
        UI.addButton("Challenge: Koru Flag", this::koruFlag);
        UI.addButton("Quit", UI::quit);
    }

}
