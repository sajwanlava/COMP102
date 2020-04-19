
// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 3
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.awt.Color;

/**
 * Reads a date from the user as three integers, and then checks that the date is valid
 */

public class DateValidator {

    /**
     * Asks user for a date, then determines whether the date
     *    specified by the three integers is a valid date.
     * For the Core, you may assume that
     * - All months have 31 days, numbered 1 to 31
     * - The months run from 1 to 12
     * - Years start from 1900 
     */
    public void validateDateCore(){
        /*# YOUR CODE HERE */
        String test = ("Thank god it's friday");
        String s = test.substring(5,15);
        UI.println(s);
        int day = UI.askInt("What is the day?");
        
        int month = UI.askInt("What number month is it?");
        int year = UI.askInt("What year is it?");

        if((day>=1 && day<=31) && (month>=1 && month<=12) && (year>=1990 && year<=2016 )){
            UI.println("This is valid");
        }
        else{
            UI.println("This is invalid");
        }

    }

    /**
     * Asks user for a date, then determines whether the date
     *    specified by the three integers is a valid date.
     * For the Completion, you should also check that
     * - Months have the correct number of days
     * - On leap years February should have 29 days.
     *    A year is a leap year if:
     *       - The year can be evenly divided by 4 but not 100
     *       - The year can be evenly divided by 400 
     */
    public void validateDateCompletion(){
        /*# YOUR CODE HERE */
        int day = UI.askInt("What is the day?");
        int month = UI.askInt("What number month is it?");
        int year = UI.askInt("What year is it?");

        int leap = year%4;

        if((month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) && (day<=31 && day>0)){
            UI.println("This is valid");
        }

        else if((month==4 || month==6 || month==9 || month==11) && (day<=30 && day>0)){
            UI.println("This is valid");
        }

        else if(month==2){
            if(day==29 && day>0 && leap==0){
                UI.println("This is valid");
            }
            else if(day<=28 && day>0){
                UI.println("This is valid");
            }
            else{
                UI.println("This is not a valid date");
            }
        }

        else{
            UI.println("This is not a valid date");
        }

    }

    /**
     * For the challenge, your program should be extended to deal with the transition from the Julian to Gregorian calendar. 
     * The program should look at the date, determine whether this should be a Julian or Gregorian date, and test it appropriately. 
     * You will need to find the rules of the Julian calendar yourselves. 
     * 
     */
    public void validateDateChallenge(){
        /*# YOUR CODE HERE */

    }

    /** ---------- The code below is already written for you ---------- **/
    /** Constructor: set up user interface */
    public DateValidator(){
        UI.initialise();
        UI.addButton("Clear", UI::clearText );
        UI.addButton("Validate Date Core", this::validateDateCore );
        UI.addButton("Validate Date Completion", this::validateDateCompletion );
        UI.addButton("Quit", UI::quit );
        UI.setDivider(1);       // Expand the text area
    }

}
