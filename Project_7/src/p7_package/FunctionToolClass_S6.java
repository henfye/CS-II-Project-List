package p7_package;

public class FunctionToolClass_S6
   {
      
      public static final int MENU_BLOCK_SIZE = 30;
      
      public static final int LOW_MENU_SELECTION = 1;
      public static final int HIGH_MENU_SELECTION = 3;
      
      public static final int FIND_NEXT_PRIME = 1;
      public static final int FIND_SINE = 2;
      public static final int FIND_SQUARE_ROOT = 3;

      public static final int SINE_ITERATIONS = 9;
      public static final double PRECISION = .000001;
      public static final int LONG_PRECISION = 6;
      public static final int TWO_ENDLINES = 2;
      
      public static Console_IO_Class conIO = new Console_IO_Class();
      
      public static void main( String[] args )
      {
      // initialize the program
         
         // initialize variables
         int operationSelection;
         double calculationInput = 0;
         double result = 0;
         
      // get input from user
         
         
         // print menu and get user selection for calculation
            // method: getUserSelection
         operationSelection = getUserSelection();
         
         
         // get value that will be involved in calculations
            // method: getUserInput( int operationSelection)
         calculationInput = getUserInput( operationSelection );
         
      // process the selected calculation
         
         // if user selects 1, find a prime value given that starting value
            // method: findNextPrime
         if (operationSelection == FIND_NEXT_PRIME)
            {
               result = findNextPrime((int) calculationInput);
            }
         
         // if user selects 2, find the sine of that given value
            // method: findSine( double value )
         else if (operationSelection == FIND_SINE)
            {
               result = findSine(calculationInput);
            }
         
         // if user selects 3, find the square root of that given value
            // method: findSquareRoot( double value )
         else
            {
               result = findSquareRoot(calculationInput);
            }
         
         
         
      // display results
            // method: showResults, printEndlines
         showResults(result, operationSelection);
         conIO.printEndlines(TWO_ENDLINES);
         
      // end program
            // method: printString, printEndline
         conIO.printString("Program End");
         conIO.printEndline();
         
      }
      
      /*
      Name: getUserSelection
      Process: Get user's selection for three different types of calculations
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: acquired calculation number (int 1-3)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: displayMenu 
      */
      public static int getUserSelection()
      {
         // initialize method/variables
         int operationSelection = 0; 
         
         // prompt displayMenu
            // method: displayMenu
         while (operationSelection < LOW_MENU_SELECTION || 
               operationSelection > HIGH_MENU_SELECTION)
            {
               operationSelection = displayMenu();
            }
         
         // return operationSelection
         return operationSelection;
      }
      
      /*
      Name: displayMenu
      Process: Display menu to user for three different types of calculations
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: user selection, int between 1-3
      Device Input/Keyboard: user input
      Device Output/Monitor: menu displayed
      Dependencies: console io tools
      */
      public static int displayMenu()
      {
         // initialize method/variables
         int operationInput;
         
         // display menu to the user
            // method: printString, printEndlines
         conIO.printString("MENU", MENU_BLOCK_SIZE, "CENTER");
         conIO.printEndlines(TWO_ENDLINES);
         
         conIO.printString("1. Find Next Prime");
         conIO.printEndlines(TWO_ENDLINES);
         
         conIO.printString("2. Find Sine");
         conIO.printEndlines(TWO_ENDLINES);
         
         conIO.printString("3. Find Square Root");
         conIO.printEndlines(2);
         
         // ask user for selection choice
            // method: promptForInt
         operationInput = conIO.promptForInt("Enter your selection choice: ");
         conIO.printEndline();
         
         // return the int selected
         return operationInput;
      }
      
      /*
      Name: getUserInput
      Process: take in user selection and prompt for the appropriate value
      Method Input/Parameters: user selection (int)
      Method Output/Parameters: none
      Method Output/Returned: input value (double)
      Device Input/Keyboard: user input
      Device Output/Monitor: input prompt displayed
      Dependencies: conIO
      */
      public static double getUserInput( int operationSelection)
         {
            // initialize method/variables
            double calculationInput = 0;
            
            // prompt user for correct input data
            if (operationSelection == FIND_NEXT_PRIME)
               {
                  calculationInput = conIO.promptForDouble("Enter start value for finding prime, must be greater than 1.0: ");
                  conIO.printEndline();
               }
            else if (operationSelection == FIND_SINE)
               {
                  calculationInput = conIO.promptForDouble("Enter value to find sine, must be greater than 1.0: ");
                  conIO.printEndline();
               }
            else
               {
                  calculationInput = conIO.promptForDouble("Enter value to find square root, must be greater than 1.0: ");
                  conIO.printEndline();
               }
            
            // return input data as a double
            return calculationInput;
         }
      
      /*
      Name: findNextPrime
      Process: take in a start value and find the next prime number after it
      Method Input/Parameters: startValue (int)
      Method Output/Parameters: none
      Method Output/Returned: next prime (int)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: isPrime
      */
      public static int findNextPrime( int startValue )
      {
         // initialize method/variables
         startValue += 1;
         
         // check numbers adding up to see if they are prime
         while (isPrime(startValue) == false)
            {
               startValue += 1;
            }
         
         // return prime number
         return startValue;
         
      }

      /*
      Name: isPrime
      Process: check to see if certain number is a prime number
      Method Input/Parameters: value (int)
      Method Output/Parameters: none
      Method Output/Returned: true or false depending on if prime
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: findSquareRoot
      */
      public static boolean isPrime( int value )
      {
         // initialize method/variables
         double valueSqrt;
         int nextNumberUp;
         int startingPoint;
         
         // find square root
         valueSqrt = findSquareRoot(value);
         
         // find next number up 
         nextNumberUp = (int) (valueSqrt + 1);
         
         // iterates through all whole numbers from 2 to the square root of 
         // the initial value rounded up. If the initial value is divisible by 
         // any of these numbers then it is not a prime number
         for (startingPoint = 2; startingPoint <= nextNumberUp; startingPoint++)
            {
               if (value % startingPoint == 0)
                  {
                     return false;
                  }
            }
         return true;
         
      }
      
      /*
      Name: findSine
      Process: take in a value and find the approximate sine of it
      Method Input/Parameters: value (double)
      Method Output/Parameters: none
      Method Output/Returned: result (double)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: findFactorial
      */
      public static double findSine(double value)
      {
         // initialize method/variables
         int counter;
         double numerator = value;
         double denomenator;
         int denomCount = 3;
         double result = value;
         double iterationValue;
         
         //iterate through the taylor series a number of times
         for (counter = 1; counter <= SINE_ITERATIONS; counter++)
            {
               // find the numerator iteratively
               numerator = numerator * -1 * (value * value);
               
               // find the denomenator with findFactorial
               denomenator = findFactorial(denomCount); 
               
               // divide numerator by denomenator
               iterationValue = numerator / denomenator;
               
               // add on to the result
               result += iterationValue;
               
               // counter the denomenator up by 2
               denomCount += 2;
            }
         
         // return the resulting sine value
         return result;
      }
      
      /*
      Name: findFactorial
      Process: take in a value and find its factorial
      Method Input/Parameters: value (int)
      Method Output/Parameters: none
      Method Output/Returned: multiplied factorial (long)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      public static long findFactorial (int value)
      {
         // initialize method/variables
         int counter;
         long recursiveFactorial = 1L;
         
         // recursively find the factorial number
         for (counter = 1; counter <= value; counter++)
            {
               recursiveFactorial = recursiveFactorial * counter;
            }
         
         // return the multiplied factorial number
         return recursiveFactorial;
      }
      
      /*
      Name: findSquareRoot
      Process: take in value and find the square root of it
      Method Input/Parameters: value (double)
      Method Output/Parameters: none
      Method Output/Returned: square root (double)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none
      */
      public static double findSquareRoot( double value )
      {
         // initialize method/variables
         double highValue;
         double lowValue;
         double midValue; 
         double testSq;
         
         // set initial values for highValue, lowValue, midValue, and a test
         // for the midValue squared
         highValue = value;
         lowValue = 0;
         midValue = (highValue + lowValue) / 2;
         testSq = midValue * midValue;
         
         
         // while the absolute value of every midpoint squared minus the
         // initial value is greater than precision, continue the loop
         while (Math.abs(testSq - value) > PRECISION)
            {
               // if midpoint squared is greater than initial value, the
               // high value then becomes the mid value
               if (testSq > value)
                  {
                     highValue = midValue;
                  }
               // otherwise, the bottom number of the range becomes the
               // midvalue
               else
                  {
                     lowValue = midValue;
                  }
               // find the new mid value off of the now changed high or low 
               // value
               midValue = (highValue + lowValue) / 2;
               
               // find the new test by squaring the mid value 
               testSq = midValue * midValue;
            }
            
         // return the square root of the input number
         return midValue;
      }
      
      /*
      Name: showResults
      Process: take in calculated results and selection and output
               appropriately to the user
      Method Input/Parameters: result (double) inputSelection (int)
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input/Keyboard: none
      Device Output/Monitor: result is displayed
      Dependencies: conIO
      */
      public static void showResults( double result, int inputSelection)
      {
         // initialize method/variables
         
         // print out the correct result depending on the user's selection
         if (inputSelection == FIND_NEXT_PRIME)
            {
               conIO.printString("Next prime value is: ");
               conIO.printInt((int) (result));
            }
         else if (inputSelection == FIND_SINE)
            {
               conIO.printString("Sine value is: ");
               conIO.printDouble(result, LONG_PRECISION);
            }
         else
            {
               conIO.printString("Square root is: ");
               conIO.printDouble(result, LONG_PRECISION);
            }
      }
   }
