//  To calculate the statistics on a file of numbers

import java.io.*;          // for I/O classes
import java.util.Scanner;  // for the Scanner class

public class FileStats
{
   private double mean; //the arithmetic average
   private double stdDev;//the standard deviation

   //Constructor calls calculateMean and calculateStdDev methods
   //and store the results in the respective instance variables
   public FileStats(String filename) throws IOException
   {
      mean = calculateMean(filename);
      stdDev = calculateStdDev(filename);
   }

   //returns the mean
   public double getMean()
   {
      return mean;
   }

   //returns the standard deviation
   public double getStdDev()
   {
      return stdDev;
   }

   //returns the calculated arithmetic average
   public double calculateMean(String filename)throws IOException
   {
		//ADD LINES FOR TASK 4
	     return 0;
   }

   //returns the calculated standard deviation
   public double calculateStdDev(String filename)throws IOException
   {
		//ADD LINES FOR TASK 5
		return 0;

   }
}