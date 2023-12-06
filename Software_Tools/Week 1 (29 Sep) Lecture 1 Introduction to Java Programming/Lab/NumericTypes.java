package javaapplication1;
//This program demonstrates how numeric types and operators
//behave

//TASK #2 Add import statement here to use the Scanner class
//TASK #2 (Alternate) Add import statment to use JOptionPane

//class
public class NumericTypes
{
	public static void main (String [] args)
	{
		//TASK #2 Create a Scanner object here
		//(not used for alternate)
		//identifier declarations

		

		final int NUMBER = 2 ; // number of scores
		final int SCORE1 = 100; // first test score
		final int SCORE2 = 95; // second test score
		final int BOILING_IN_F = 212; // freezing temperature
		int fToC; // temperature in Celsius
		double average; // arithmetic average
		String output; // line of output to print out

		//TASK #2 declare variables used here
		//TASK #3 declare variables used here
		//TASK #4 declare variables used here
		
		// Find an arithmetic average
		average = SCORE1 + SCORE2 / NUMBER;
		output = SCORE1 + " and " + SCORE2 + " have an average of " + average;
		System.out.println(output);

		// Convert Fahrenheit temperatures to Celsius
		fToC = 5/9 * (BOILING_IN_F - 32);
		output = BOILING_IN_F + " in Fahrenheit is " + fToC + " in Celsius.";
		System.out.println(output);
		System.out.println(); // to leave a blank line

		// ADD LINES FOR TASK #2 HERE
		// prompt the user for first name
		// read the users first name
		// prompt the user for last name
		// read the users last name
		// concatenate the users first and last names
		// print out the users full name


		System.out.println(); // to leave a blank line


		// ADD LINES FOR TASK #3 HERE
		// get the first character from the users first name
		// print out the users first initial
		// convert the users full name to all capital letters
		// print out the users full name in all capital
		// letters and the number of characters in it


		System.out.println(); // to leave a blank line


		// ADD LINES FOR TASK #4 HERE
		// prompt the user for a diameter of a sphere
		// read the diameter
		// calculate the radius
		// calculate the volume
		// print out the volume
	}
}
