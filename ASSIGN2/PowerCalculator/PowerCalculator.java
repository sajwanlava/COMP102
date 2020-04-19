// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP 102 Assignment 2 
 * Name:
 * Usercode:
 * ID:
 */

import ecs100.*;

/** Program for calculating how much you can save on your power bill */
// http://www.powerwise.co.nz/why-choose-led-light-bulbs/led-light-bulb-facts/

public class PowerCalculator{

    public static final double priceKWh = 20.34;         // cents
    public static final int incandescentLifeSpan = 1000; // hours
    public static final int ledLifeSpan = 25000;         // hours
    public static final double incandescentPrice = .99;   // dollars

    /** Calculates and prints how long it would take you to amortise your cost of switching
     *  to energy saving bulbs
     */
    public void calculateCostSaverCore(){
        /*# YOUR CODE HERE */
        double oldb = UI.askDouble("How many watts did the old bulbs use?");
        double newb = UI.askDouble("How many watts do the new bulbs use?");
        int change = UI.askInt("How many bulbs are being replaced?");

        double powerReduc = (oldb-newb)*change/1000;

        UI.println("The total power reduction is: " + powerReduc + " KWh");

        double hours = UI.askDouble("How many hours each day is the light on in your house?");
        double days = UI.askDouble("How many days per week is the light used?");
        double weeks = UI.askDouble("How many weeks is the light used in a year?");

        double total = hours*days*weeks*powerReduc;

        UI.printf("The total power saved per year is: %.2fKWh%n" , total);

        double money = total*priceKWh/100;

        UI.printf("The total dollars saved per year is: $%.2f%n" , money);

        double cost = UI.askDouble("How much does one LED bulb cost?");
        double breakEven = (change*cost)/(money);

        UI.printf("The number of years to break even is: %.2f%n ", breakEven);
        
        
        


    }

    /** Calculates and prints how long it would take you to amortise your cost of switching
     *  to energy saving bulbs
     *  For the Completion part consider the life span of each type of bulbs and prints
     *  how much saving will be done after numYears years
     *  
     */
    public void calculateCostSaverCompletion(){
        /*# YOUR CODE HERE */
        double oldb = UI.askDouble("How many watts did the old bulbs use?");
        double newb = UI.askDouble("How many watts do the new bulbs use?");
        int change = UI.askInt("How many bulbs are being replaced?");

        double powerReduc = (oldb-newb)*change/1000;

        UI.println("The total power reduction is: " + powerReduc + " KWh");

        double hours = UI.askDouble("How many hours each day is the light on in your house?");
        double days = UI.askDouble("How many days per week is the light used?");
        double weeks = UI.askDouble("How many weeks is the light used in a year?");

        double total = hours*days*weeks*powerReduc;

        UI.printf("The total power saved per year is: %.2fKWh%n" , total);

        double money = total*priceKWh/100;

        UI.printf("The total dollars saved per year is: $%.2f%n" , money);

        double cost = UI.askDouble("How much does one LED bulb cost?");
        double breakEven = (change*cost)/(money);

        UI.printf("The number of years to break even is: %.2f%n ", breakEven);

        //COMPLETION CODE STARTS HERE
        double years = UI.askDouble("What is the number of years to calculate the savings over?");
        double oldbRun = UI.askDouble("How much did the original bulbs cost to run per month?");
        double oldbRep = UI.askDouble("How much did the original bulb cost to replace?");
        double costToRunOldb = (7*24*oldbRun*years/12)+(oldbRep*change);

        UI.printf("The cost of running and replacing the old bulbs was $%.2f%n " , costToRunOldb);

        double newbRun = UI.askDouble("How much do the new LED bulbs cost to run?");
        double howLong = UI.askDouble("Aproximately how many months have the LED bulbs been in use?");
        double costToRunLED = (change * cost * newbRun * howLong);

        UI.printf("The cost of changing to and then using LED bulbs so far is $%.2f%n", costToRunLED);

        double savings = years * (costToRunOldb-costToRunLED);

        UI.printf("The savings over those years are $%.2f%n " , savings);

    }
    /** ---------- The code below is already written for you ---------- **/
    /** Constructor, sets up the user interface */
    public PowerCalculator(){
        UI.initialise();
        UI.addButton("Core", this::calculateCostSaverCore); 
        UI.addButton("Completion", this::calculateCostSaverCompletion );
        UI.addButton("Quit", UI::quit);
        UI.setDivider(1);    // Expand the Text pane
    }

}
