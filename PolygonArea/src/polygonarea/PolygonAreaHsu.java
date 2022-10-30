/* Caroline Hsu - due 12/01/2020
This program asks the user which method to solve for area (side length and no.
of sides or apothem length and perimeter) and allows the user to input the
data needed to solve it. The user can repeat the process however many times 
they want and at the end, they will receive all of the data inputed as
a result plus the areas.

import Scanner
declare variables and array size of 100
start do while loop to complete one and then repeat if while is fulfilled
  ask user for which formula they want to use

  if statement for if they choose 1st
    use method to ask for side length and side number
    use method to solve for 1st
    count amt of times 1st is solved for
  if statement for if they choose 2nd
    use method to ask for apothem and perimeter
    use method to solve for 2nd
    count amt of times 2nd is solved for

  ask user if they want to continue solving
  if answer is yes, repeat do while loop - use char y or Y (ignore case)
  if no, end do while loop 

display data with if and do while loops
  if amt of times 1st formula was solved with is greater than 0 display
    display the data with method
  if amt of times 2nd formula was solved with is greater than 0 display
    display the data with method

first method - method to read data inputed by the user
  declare scanner and data (data as a double variable)
  ask user and return the data

second method - method solve for the area with the first formula
  declare variables for calculations 
  do the computations
  return the area
  
third method - method to solve for the area with the second formula
  declare variables for calculations 
  do the computations
  return the area

fourth method - method to display the 1st formula areas and all data inputed 
by user
  print the values
  no return needed

fifth method - method to display the 2nd formula areas and all data inputed by 
user
  print the values
  no return needed */
package polygonarea;

// import scanner from API
import java.util.Scanner;

public class PolygonAreaHsu
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
    double[] apothemLength = new double[arraySize];
    double[] perimeter = new double[arraySize];
    double[] firstArea = new double[arraySize];
    double[] secondArea = new double[arraySize];
    int counter = 0;
    String response;
    char answer;
    final int START = 0;
    // count amt of times both formulas are solved with
    int firstTimes = 0;
    int secondTimes = 0;

    do
    /* loop repeats after one complete cycle if while statement is true,
    starts by prompting the user to answer the question */
    {
      // prompts the user if they would like to solve for area using 1st or 
      // 2nd formula
      System.out.print("Would you like to solve for the area of a regular "
                       + "\npolygon with the side length and number of "
                       + "sides \nor with the apothem and perimeter?"
                       + "\nPlease say 1st or 2nd for the choice. ");
      response = input.nextLine();
      
      // if statement for if the user wants to use the 1st formula
      if (response.equalsIgnoreCase("1st"))
      {
        // prompts the user for information to solve the area with 1st formula
        System.out.print("What is your side length? ");
        sideLength[firstTimes] = userData(); // utilize method to read data
        System.out.print("What is the number of sides? ");
        sideNumber[firstTimes] = userData(); // utilize method to read data

        // utilize method to calculate the value of firstArea and return it
        firstArea[firstTimes] = firstFormula(sideLength[firstTimes],
                                             sideNumber[firstTimes]);

        // print area for user
        System.out.printf("Your area is: %10.4f \n", firstArea[firstTimes]);
        firstTimes++; /* counts the amt of times area with first formula is 
        solved with */
      }

      // else if statement for if the user wants the 2nd formula
      else if (response.equalsIgnoreCase("2nd"))
      {
        // prompts the user for information to solve the 2nd formula
        System.out.print("What is your perimeter? ");
        perimeter[secondTimes] = userData(); // utilize method to read data
        System.out.print("What is your apothem length? ");
        apothemLength[secondTimes] = userData(); // utilize method to read data

        // utilize method to calculate the value of firstArea and return it
        secondArea[secondTimes] = secondFormula(apothemLength[secondTimes],
                                                perimeter[secondTimes]);

        // print area for user
        System.out.println("Your area is: " + secondArea[secondTimes]);
        secondTimes++; /* counts the amt of times area with second formula is 
        solved with */
      }

      /* ask the user if they would like to continue solving for area with any
      of the two formulas */
      System.out.print("Would you like to continue solving? Respond with y to"
                       + " continue: ");
      answer = input.nextLine().charAt(0);
    } while ((answer == 'y') || (answer == 'Y')); /* repeat the loop if answer 
    is yes */

    /* to display the information, use an if statement for if the amount of 
    times the first formula used is greater than 0 */
    if (firstTimes > START)
    {
      System.out.println("For your first choice: ");
      // loop that repeats until all information is displayed
      do
      {
        displayFirstArea(sideLength[counter], sideNumber[counter],
                         firstArea[counter]);
        counter++;
      } while (counter < firstTimes);
      /* repeats until it is 1 less (array starts at 0 so it will always be one 
      less) */
    }

    counter = START; // sets the counter to 0 to start displaying info again
    /* if statement for if the amount of times the 2nd formula used is greater
    than 0 */
    if (secondTimes > START)
    {
      System.out.println("For your second choice: ");
      do // loop that repeats until all information is displayed
      {
        displaySecondArea(apothemLength[counter], perimeter[counter],
                          secondArea[counter]);
        counter++;
      } while (counter < secondTimes);
      /* repeats until it is 1 less (array starts at 0 so it will always be 
      one less) */
    }
  }

  // method to read data inputed by the user
  public static double userData()
  {
    // declare variables 
    Scanner input = new Scanner(System.in);
    double data; // double because users can input decimals

    data = input.nextDouble(); // reads double input from user

    return data; // returns the double data value 
  }

  // method to solve for the area with the first formula
  public static double firstFormula(double sideLength, double sideNumber)
  {
    // declares variables for calculations
    double numerator;
    double denominator;
    double radians;
    final int DEGREES = 180;
    final int COEFFICIENT = 4;
    double firstArea;

    // does the computations for the 1st formula with info provided
    numerator = sideLength * sideLength;
    numerator = numerator * sideNumber;
    denominator = DEGREES / sideNumber;
    //converts into radians as tangent operation is in rad not deg
    radians = denominator * (Math.PI / DEGREES);
    denominator = Math.tan(radians);
    denominator = COEFFICIENT * denominator;
    firstArea = numerator / denominator;

    return firstArea; // returns firstArea value
  }

  // method to solve for the area with the second formula
  public static double secondFormula(double apothemLength, double perimeter)
  {
    // declares variables for calculations
    final double COEFFICIENT_TWO = 0.5;
    double secondArea;

    // completes the computations for the 2nd formula with the info provided
    secondArea = COEFFICIENT_TWO * apothemLength;
    secondArea = secondArea * perimeter;

    return secondArea; // returns the secondArea value
  }

  // method to display the 1st formula areas and all data inputed by user
  public static void displayFirstArea(double sideLength, double sideNumber,
                                      double firstArea)
  {
    // prints the data inputed by the user and what the program solved for
    System.out.printf("Your area is: %10.4f \n", firstArea);
    System.out.println("Your side length is: " + sideLength);
    System.out.println("Your side number is: " + sideNumber);
  }

  // method to display the 2nd formula areas and all data inputed by user
  public static void displaySecondArea(double apothemLength, double perimeter,
                                       double secondArea)
  {
    // prints the data inputed by the user and what the program solved for
    System.out.println("Your area is: " + secondArea);
    System.out.println("Your apothem length is: " + apothemLength);
    System.out.println("Your perimeter is: " + perimeter);
  }
}
