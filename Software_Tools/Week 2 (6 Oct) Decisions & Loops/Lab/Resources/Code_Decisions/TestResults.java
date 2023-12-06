import java.util.Scanner;  // Needed for the Scanner class

/**
 * This program uses the TestGrade class to determine
 * a letter grade for a numeric test score. The
 * program displays an error message if an invalid
 * numeric score is entered.
 */

public class TestResults
{
   public static void main(String[] args)
   {
      int testScore;     // To hold a test score
      char letterGrade;  // To hold a letter grade

      // Create a Scanner object to read input.
      Scanner keyboard = new Scanner(System.in);

      // Get the numeric test score.
      System.out.print("Enter your numeric test score and "
                       + "I will tell you the grade: ");
      testScore = keyboard.nextInt();

      // Create a TestGrade object with the numeric score.
      TestGrade test = new TestGrade(testScore);

      // Get the letter grade.
      letterGrade = test.getLetterGrade();

      // Display the grade.
      if (letterGrade == '?')
         System.out.println("The score you entered "
                            + "is invalid.");
      else      
         System.out.print("Your grade is " + letterGrade);
   }
}
