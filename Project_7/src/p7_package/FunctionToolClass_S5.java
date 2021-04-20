package p7_package;

public class FunctionToolClass_S5
   {
      
      public static void main( String[] args )
      {
      // initialize the program
         
         // initialize variables
         
      // get input from user
         
         
         // print menu and get user selection for calculation
            // method: getUserSelection
         
         
         // get value that will be involved in calculations
            // method: getUserInput( int operationSelection)
         
      // process the selected calculation
         
         // if user selects 1, find a prime value given that starting value
            // method: findNextPrime
         
         // if user selects 2, find the sine of that given value
            // method: findSine( double value )
         
         // if user selects 3, find the square root of that given value
            // method: findSquareRoot( double value )     
         
         
      // display results
            // method: showResults, printEndlines
         
      // end program
            // method: printString, printEndline
         
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
         
         // prompt displayMenu
            // method: displayMenu
         
         // return operationSelection
         return 0; // temporary value
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
         
         // display menu to the user
            // method: printString, printEndlines
         
         // ask user for selection choice
            // method: promptForInt
         
         // return the int selected
         return 0; //temporary holder
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

            
            // prompt user for correct input data

            // return input data as a double
            return 0; // temporary holder

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
         
         // use is prime to iterate through and find next prime
         
         // return next prime
         return 0; //temporary holder
         
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
         
         // find square root
         
         // find next number up 

         
         // iterates through all whole numbers from 2 to the square root of 
         // the initial value rounded up. If the initial value is divisible by 
         // any of these numbers then it is not a prime number
         return false; //temporary holder
         
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
         
         // find  the numerator and denomenator and then add them on to the 
         // result of the taylor series each time

         return 0; // temporary holder
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
         
         // multiply each number recursively to find the factorial
         
         //return factorial number
         return 0; // temporary holder
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
         
         // set initial values for highValue, lowValue, midValue, and a test
         // for the midValue squared
         
         
         // while the absolute value of every midpoint squared minus the
         // initial value is greater than precision, continue the loop

               // if midpoint squared is greater than initial value, the
               // high value then becomes the mid value

               // otherwise, the bottom number of the range becomes the
               // midvalue

               // find the new mid value off of the now changed high or low 
               // value

               
               // find the new test by squaring the mid value 

            
         // return the square root of the input number
         return 0; //temporary holder
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
         
         // print out the appropriate end result for the program
      }
   }
