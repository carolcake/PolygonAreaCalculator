/*
Caroline Hsu - due 12/01/2020

 */
package polygonarea;

// import scanner from API
import java.util.Scanner;
public class PolygonArea
{
  public static void main(String[] args)
  {
    // declare variables and declare type Scanner
    int arraySize = 100; // array size of 100 as users most likely won't ask 
                         // more than 100 times 
    Scanner input = new Scanner(System.in);
    // declare array variables with size 100
    double[] sideLength = new double[arraySize];
    double[] sideNumber = new double[arraySize];
    double[] numerator = new double[arraySize];
    double[] denominator = new double[arraySize];
    double[] apothemLength = new double[arraySize];
    double[] perimeter = new double[arraySize];
    double[] firstArea = new double[arraySize];
    double[] secondArea = new double[arraySize];
    double[] radians = new double[arraySize];
    final int DEGREES = 180;
    final int COEFFICIENT = 4;
    final double COEFFICIENT_TWO = 0.5;
    int counter = 0;
    String response;
    char answer;
    final int START = 0;
    int firstTimes = 0;
    int secondTimes = 0;
    
    do // do while loop repeats after one complete cycle if while statement
       // is true, starts by prompting the user to answer the question
    {
      // prompts the user if they would like to solve for area using 1st or 
      // 2nd formula
      System.out.print("Would you like to solve for the area of a regular "
          + "\npolygon with the side length and number of "
          + "sides \nor with the apothem and area?"
          + "\nPlease say 1st or 2nd for the choice. ");
      response = input.nextLine();
      // if statement for if the user wants to use the 1st formula
      if (response.equalsIgnoreCase("1st"))
      {
        // prompts the user for information to solve the area with 1st formula
        System.out.print("What is your side length? ");
        sideLength[firstTimes] = input.nextDouble();
        input.nextLine();
        System.out.print("What is the number of sides? ");
        sideNumber[firstTimes] = input.nextDouble();

        // does the computations for the 1st formula with info provided
        numerator[firstTimes] = sideLength[firstTimes] * sideLength[firstTimes];
        numerator[firstTimes] = numerator[firstTimes] * sideNumber[firstTimes];
        denominator[firstTimes] = DEGREES / sideNumber[firstTimes];
        //converts into radians as tangent operation is in rad not deg
        radians[firstTimes] = denominator[firstTimes] * (Math.PI / DEGREES);
        denominator[firstTimes] = Math.tan(radians[firstTimes]);
        denominator[firstTimes] = COEFFICIENT * denominator[firstTimes];
        firstArea[firstTimes] = numerator[firstTimes] / denominator[firstTimes];
        firstTimes++; // adds 1 to the firstTimes counter
      }
      // else if stateement for if the user wants the 2nd formula
      else if (response.equalsIgnoreCase("2nd"))
      {
        // prompts the user for information to solve the 2nd formula
        System.out.print("What is your perimeter? ");
        perimeter[secondTimes] = input.nextDouble();
        input.nextLine();
        System.out.print("What is your apothem length? ");
        apothemLength[secondTimes] = input.nextDouble();

        // does the computations for the 2nd formula with info provided
        secondArea[secondTimes] = COEFFICIENT_TWO * apothemLength[secondTimes];
        secondArea[secondTimes] = secondArea[secondTimes] * 
                                  perimeter[secondTimes];
        secondTimes++;
      }
      // ask the user if they would like to continue solving for area with any
      // of the two formulas
      System.out.print("Would you like to continue? Respond with y to" + 
                       " continue: ");
      input.nextLine();
      answer = input.nextLine().charAt(0);
    } while ((answer == 'y') || (answer == 'Y')); // repeat the loop if answer 
                                                  // is yes
    /* to display the information use if statement for if the amount of times
    the first formula used is greater than 0 */
    
    if (firstTimes > START)
    {
      System.out.println("For your first choice: ");
      // do while loop that repeats until all information is displayed
      do
      {
        System.out.println("Your area is: " + firstArea[counter]);
        System.out.println("Your side length is: " + sideLength[counter]);
        System.out.println("Your side number is: " + sideNumber[counter]);
        counter++;
      } while (counter < firstTimes); /* repeats until it is 1 less (array 
                                      starts at 0 so it will always be one 
                                      less) */
    }
    
    counter = START; // sets the counter to 0 to start displaying info again
    /* if statement for if the amount of times the 2nd formula used is greater
    than 0 */
    if (secondTimes > START)
    {
      System.out.println("For your second choice: ");
      do // do while loop that repeats until all information is displayed
      {
        System.out.println("Your area is: " + secondArea[counter]);
        System.out.println("Your perimeter is: " + perimeter[counter]);
        System.out.println("Your apothem length is: " + apothemLength[counter]);
        counter++;
      } while (counter < secondTimes); /* repeats until it is 1 less (array 
                                       starts at 0 so it will always be one 
                                       less) */
    }
  }
}
