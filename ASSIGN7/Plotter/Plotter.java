// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP102 Assignment 7 
 * Name: 
 * Usercode:
 * ID:
 */

import ecs100.*;
import java.util.*;
import java.io.*;
import java.awt.Color;

/**
 * This is an extension of the StockAnalyser program from assignment 3
 * which plots a sequence of stock prices and prints some statistics.
 * However, instead of reading data from the user, it reads the data from
 * a file into an array, which means that it can analyse the numbers
 * more easily and in more different ways.
 * It can also cope with much larger sets of numbers.
 * It plots the data in two different ways.
 * The numbers are guaranteed to be integers.
 * The first number in the file is always the number of numbers.
 *
 * There are 9 methods you are to complete, all focusing on the array of data.
 * CORE
 *   doRead:      asks user for file and reads numbers (integers) into an array
 *   minValue:    returns the smallest value in the array 
 *   maxValue:    returns the largest value in the array 
 *   mean:        returns the mean of the values in the array
 *   doPlotData:  plots a line graph of all the values in the array
 *                  (partly completed for you)
 * COMPLETION                
 *   arrayOfCounts: used by histogram.
 *   doHistogram:   computes and draws a histogram of the numbers. 
 *
 * CHALLENGE                
 *   standardDeviation: returns the standard deviation of the values.
 *   median: returns the median
 */

public class Plotter {
    // Fields 
    private int[] allNumbers;   // the field to hold the array of data

    // (You shouldn't add any more fields for core or completion)

    // Constant fields holding the dimensions of the graph for the plotData method
    public static final int GRAPH_LEFT = 10;
    public static final int GRAPH_TOP = 10;
    public static final int GRAPH_RIGHT = GRAPH_LEFT + 500;
    public static final int GRAPH_BOT = GRAPH_TOP + 450;

    /*** 
     * [CORE]
     * Asks user for the file (using UIFileChooser.open() and
     * creates an array stored in a field, then 
     * reads data from the file into the array
     * Assumes all data values are positive integers. 
     */
    public void doRead(){
        UI.clearPanes();

        // Read first value from the file and create the array of that size
        // Read that many numbers from the file into the array
        /*# YOUR CODE HERE */

        try {
            Scanner scan = new Scanner(new File(UIFileChooser.open()));
            int size = scan.nextInt();
            allNumbers = new int[size];
            //int num = 0;
            for(int i=0; i<allNumbers.length; i++){
                allNumbers[i] = scan.nextInt();
                UI.println(allNumbers[i]);
            }
            scan.close();
        }catch(IOException e) {UI.printf("File Failure %s \n", e);}

    }

    /**
     * [CORE]
     * Returns the smallest value in the data array. 
     * Assumes there is at least one value 
     */
    public int minValue(){
        /*# YOUR CODE HERE */
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<allNumbers.length; i++){
            if( min > allNumbers[i]){
                min = allNumbers[i];
            }
        }
        return min;
    }

    /**
     * [CORE]
     * Returns the largest value in the data array. 
     * Assumes there is at least one value 
     */
    public int maxValue(){
        /*# YOUR CODE HERE */
        int max = Integer.MIN_VALUE;
        for(int i =0; i<allNumbers.length; i++){
            if(max< allNumbers[i]){
                max = allNumbers[i];
            }
        }
        return max;
    }

    /**
     * [CORE]
     * Returns the mean of the values in the data array. 
     * Assumes there is at least one value
     */
    public double mean(){
        /*# YOUR CODE HERE */
        double mean = 0;
        double total = 0;
        for(int i = 0; i<allNumbers.length; i++){
            total = total + allNumbers[i];
        }
        mean = total/(allNumbers.length);
        return mean;
    }

    /**
     * CORE
     * Plots a line graph of the data
     * Assume all data values are positive and fewer than 500 values.
     * Draws the x and y axis,
     * Plots a line graph of all the points with a blue line between
     *  each pair of adjacent points
     * Uses the GRAPH_LEFT, GRAPH_TOP, etc fields for the dimensions and positions of the graph.
     */
    public void doPlotData(){
        if (this.allNumbers==null || this.allNumbers.length<2){ //there is no data to analyse
            UI.println("No data to plot");
            return;
        }
        UI.clearGraphics();

        // draw axes
        UI.setColor(Color.black);
        UI.drawLine(this.GRAPH_LEFT, this.GRAPH_TOP, this.GRAPH_LEFT, this.GRAPH_BOT); 
        UI.drawLine(this.GRAPH_LEFT, this.GRAPH_BOT, this.GRAPH_RIGHT, this.GRAPH_BOT);

        // plot points: line between each pair of values
        /*# YOUR CODE HERE */
        UI.setColor(Color.orange);
        int x = 0;
        for(int i = 0; i<allNumbers.length; i++){
            UI.drawLine(GRAPH_LEFT+x, (GRAPH_BOT - allNumbers[i]), GRAPH_LEFT+x+1, (GRAPH_BOT - allNumbers[i+1]));
            x++; 
        }

    }

    /**
     * COMPLETION
     * Draw histogram
     * Assumes all values are between 0 and 450, and
     * also that the count of any single value is less than 450.
     * Plots a (green) vertical line for each possible value.
     * Height of line is 5 times the count of that value.
     * Uses the arrayOfCounts method to construct the data for the
     * histogram.
     */
    public void doHistogram(){
        if (this.allNumbers==null){ //there is no data to analyse
            UI.println("No data to plot histogram");
            return;
        }
        UI.clearGraphics();

        // draw axes
        UI.setColor(Color.black);
        UI.drawLine(this.GRAPH_LEFT, this.GRAPH_TOP, this.GRAPH_LEFT, this.GRAPH_BOT); 
        UI.drawLine(this.GRAPH_LEFT, this.GRAPH_BOT, this.GRAPH_RIGHT, this.GRAPH_BOT);

        // Plots a (green) vertical line for each possible value.
        // Height of line is 5 times the count of that value.
        /*# YOUR CODE HERE */
        UI.setColor(Color.green);
        int [] count = this.arrayOfCounts();
        for(int i = 0; i<count.length; i++){
            double x = this.GRAPH_LEFT;
            double y = this.GRAPH_BOT;
            double x1 = this.GRAPH_LEFT+20;
            double y1 = this.GRAPH_BOT - (5*(count[i]));
            x = x + 20;
            
            UI.drawLine(x,y,x,y1);
        }

    }

    /**
     * COMPLETION
     * Constructs and returns an array of counts of each value.
     * (the "count array")
     * Assumes that all values are non-negative.
     * The count array will have a count for each integer from 0
     * to the maximum value in the data
     */
    public int[] arrayOfCounts(){
        /*# YOUR CODE HERE */
        int [] count = new int[this.maxValue()+1];
        for(int i = 0; i<allNumbers.length; i++){
            if(allNumbers[i] >= 0){
                count[allNumbers[i]] = count [allNumbers[i]]+1;
                UI.println(count[allNumbers[i]]);
            }
        }
        return count;  
    }

    /**
     * CHALLENGE
     * Returns the standard deviation of the values in the data array. 
     * Assumes there is at least one value
     */
    public double standardDeviation(){
        /*# YOUR CODE HERE */
        double mean = this.mean(); 
        double total = 0;
        double number = 0;
        for(int i=0; i<allNumbers.length; i++){
            number = Math.pow(allNumbers[i] - mean ,2);
            total = total + number;
        }
        double mean2 = total/allNumbers.length;
        double root = Math.sqrt(mean2);

        return root;   // Required to make it compile. You may change this line.
    }

    /**
     * CHALLENGE
     * Returns the median value in the data array. 
     * Assumes there is at least one value 
     */
    public double median(){
        /*# YOUR CODE HERE */
        double median = 0;
        for(int i=0; i<allNumbers.length; i++){
            int half = allNumbers.length /2;
            if(i == half){
                median =  allNumbers[i];
            }

        }

        return median;   // Required to make it compile. You may change this line.
    }

    /** ---------- The code below is already written for you ---------- **/

    /** Constructor:
     * Set up the five buttons
     */

    public Plotter(){
        UI.addButton("Read Data", this::doRead);
        UI.addButton("Report Stats", this::doReportStats);
        UI.addButton("Plot Data", this::doPlotData);
        UI.addButton("Histogram", this::doHistogram);
        UI.addButton("Challenge Stats", this::doChallengeStats);
    }

    /**
     * Computes and writes out the min, max, mean of the data.
     * Appends the data to the textArea.
     */
    public void doReportStats(){
        if (this.allNumbers==null){ //there is no data to analyse
            UI.println("No data to report on");
            return;
        }
        UI.println("\n\nStatistics:\n-------------");
        UI.printf("Count:  %d\n", this.allNumbers.length);
        UI.printf("Min:    %d\n", this.minValue());
        UI.printf("Max:    %d\n", this.maxValue());
        UI.printf("Mean:   %4.3f\n", this.mean());
    }

    /**
     * Computes and writes out the standard deviation and median of the data.
     * Appends the data to the textArea.
     */
    public void doChallengeStats(){
        if (this.allNumbers==null){ //there is no data to analyse
            UI.println("No data to report on");
            return;
        }
        UI.println("\n\nChallenge Statistics:\n-------------");
        UI.printf("SD:     %4.3f\n", this.standardDeviation());
        UI.printf("median: %4.1f\n", this.median());
    }

    // Main
    public static void main(String[] arguments){
        new Plotter();
    }        

}
