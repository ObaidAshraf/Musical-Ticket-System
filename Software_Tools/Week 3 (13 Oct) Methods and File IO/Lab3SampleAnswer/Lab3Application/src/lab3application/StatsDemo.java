package lab3application;

import java.text.DecimalFormat;//step a
import java.io.*;
import java.util.Scanner;// step b

public class StatsDemo {

    public static void main(String[] args) throws IOException {

        //format our output with 3 decimal places
        DecimalFormat threeDecimal = new DecimalFormat("0.000");//a
        // Create a Scanner object to get the file name input from the user (Don’t forget the needed import statement).
        Scanner keyboard = new Scanner(System.in);//b

        System.out.print("Enter the filename: ");//c-1
        String txtFile = keyboard.nextLine();
        File file= new File("Numbers.txt");
        Scanner inputFile = new Scanner(file);
        FileStats fn= new FileStats(txtFile); // ask Tuan for this issue.
        inputFile.close();

        PrintWriter outputFile = new PrintWriter("Results.txt"); // create PrintWrite object passing it
        outputFile.println("this point is: mean = " + threeDecimal.format(fn.getMean()));
        outputFile.println("standard deviation: deviation = " + threeDecimal.format(fn.getStdDev()));
        //close the output file
        outputFile.close();
    }

}
