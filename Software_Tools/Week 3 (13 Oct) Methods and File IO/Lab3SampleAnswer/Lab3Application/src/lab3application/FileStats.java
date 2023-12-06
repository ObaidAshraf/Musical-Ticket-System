package lab3application;

//  To calculate the statistics on a file of numbers
import java.io.*;          // for I/O classes
import java.util.Scanner;  // for the Scanner class

public class FileStats {

    private double mean; //the arithmetic average
    private double stdDev;//the standard deviation

    //Constructor calls calculateMean and calculateStdDev methods
    //and store the results in the respective instance variables
    public FileStats(String filename) throws IOException {
        mean = calculateMean(filename);
        stdDev = calculateStdDev(filename);
    }

    //returns the mean
    public double getMean() {
        return mean;
    }

    //returns the standard deviation
    public double getStdDev() {
        return stdDev;
    }

    //returns the calculated arithmetic average
    public double calculateMean(String filename) throws IOException {
        //ADD LINES FOR TASK 4

        File txtFile = new File(filename);// create file object passing it the filename
        Scanner inputFile = new Scanner(txtFile); // create a scanner object passing it the object name.
        // initialize all numbers variables to 0
        double accumulater = 0;
        int counter = 0;
        // loop that reads values from file to the end.
        while (inputFile.hasNextDouble()) {
            accumulater += inputFile.nextDouble();
            counter++;
        }
        inputFile.close();
        mean = accumulater / counter;

        return mean;
    }

    //returns the calculated standard deviation
    public double calculateStdDev(String filename) throws IOException {
        //ADD LINES FOR TASK 5

        File txtFile = new File(filename);// create file object passing it the filename
        Scanner inputFile = new Scanner(txtFile); // create a scanner object passing it the object name.
        // initialize all numbers variables to 0
        double accumulater = 0;
        double x = 0;
        int counter = 0;
        double difference = 0;
        while (inputFile.hasNextDouble()) {
            difference = inputFile.nextDouble() - mean;
            //diff = x - mean;
            accumulater += Math.pow(difference, 2);
            counter++;
        }
        inputFile.close();
        x = accumulater / counter;
        stdDev = Math.sqrt(x);

        return stdDev;

    }
}
