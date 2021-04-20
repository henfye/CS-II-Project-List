package p6_package;

public class QuadCalcClass_II_S5
   {
      // initialize table characters
      
      // initialize line controls

      // initialize table string components
      
      // initialize table widths

      // initialize two endlines constant
      
      // initialize console IO 
      
      public static void main( String[] args )
      {
      // initialize the program
         // declare variables
         
         // set title for program using method
            // method: printTitle
         
      // get coefficients from user
         // get coefficient A
            // method: promptForCoef
         
         // get coefficient B
            // method: promptForCoef
         
         // get coefficient C
            // method: promptForCoef, printEndline
         
      // process the quadratic roots
         // calculate the denominator
            // method: calcDenom
         
         // calculate the discriminant
            // method: calcDiscrim
         
         // test discriminant for complex condition
         
         // calculate square root of discriminant
            // method: Math.sqrt
         
         // calculate the roots
         
         // calculate root one
            // method: calcRoot
         
        // calculate root tow
            // method: calcRoot

         
      // display roots to user
         // display thick table line
            // method: displayLine, printEndline
         
         // display table title
            // method: displayTableTitle, printEndline
         
         // display thin table line
            // method: displayLine, printEndline
         
         // display sub titles
            // method: displaySubTitles, printEndline
         
         // display coefficient A
            // method: displayDataLine, printEndline
         
         // display coefficient B
            // method: displayDataLine, printEndline
         
         // display coefficient C
            // method: displayDataLine, printEndline
         
         // if root is complex display complex
            // method: displayDataLine, printEndline
         
         // if root is not complex, display root one
            // method: displayDataLine, printEndline
               
         // if the solution has two roots, display second root
            // method: displayDataLine, printEndline
         
         // print bottom line of table
            // method: displayLine, printEndlines
         
         
      // end program
         // print end program
            // method: printString, printEndline
      }
      
      /*
      Name: printTitle
      Process: displays the program title on the monitor
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Output/Monitor: title displayed
      Dependencies: Console IO Class Tools 
      */
      public static void printTitle()
      {
         // initialize method/variables
         
         // print title with underline and vertical space
         
            // print title
               // method: printString, printEndline
         
            // print underline
               // method: printChars, printEndlines
      }
      
      /*
      Name: promptForCoef
      Process: prompt user for appropriate coefficient, get coefficient,
      return coefficient
      Method Input/Parameters: coefficient letter (char)
      Method Output/Parameters: none
      Method Output/Returned: acquired coefficient (int)
      Device Input/Keyboard: user input
      Device Output/Monitor: title displayed
      Dependencies: Console IO Class Tools 
      */
      public static int promptForCoef( char coefLetter )
      {
         // initialize method/variables
         
         // prompt user for coefficient
            // method: promptForInt
         
         // return input
         return 0;   // temporary return value
      }
      
      /*
      Name: calcDenom
      Process: calculate denominator with coefficient A and return
      Method Input/Parameters: coefficient A (int)
      Method Output/Parameters: none
      Method Output/Returned: calculated denominator (int)
      Device Input: none
      Device Output: none
      Dependencies: none
      */
      public static int calcDenom( int coefA )
      {
         // initialize method/variables
         
         // multiply 2 times coefficient A
         
         // return denominator
         return 0;   // temporary return value
      }
      
      /*
      Name: calcDiscrim
      Process: calculate discriminant with three coefficients and return
      Method Input/Parameters: three coefficients (int)
      Method Output/Parameters: none
      Method Output/Returned: calculated discriminant (int)
      Device Input/Keyboard: none
      Device Output/Monitor: none
      Dependencies: none 
      */
      public static int calcDiscrim( int coefA, int coefB, int coefC )
      {
         // initialize method/variables
         
         // calculate discriminant
         
         // return discriminant
         return 0;   // temporary return value
      }
      
      /*
      Name: calcRoot
      Process: calculate single root solution with previously processed equation
               component, and return
      Method Input/Parameters: coefficient B (int) and the denominator (int),
              and the square root of the discriminant (double)
      Method Output/Parameters: none
      Method Output/Returned: calculated single root (double)
      Device Input: none
      Device Output: none
      Dependencies: none
      */
      public static double calcRoot( int coefB, int denominator, double discSqrt )
      {
         // initialize method/variables
         
         // calculate the numerator
         
         // calculate the root
         
         // return root
         return 0;   // temporary return value
      }
      
      /*
      Name: displayLine
      Process: display either a single dash line or double dash line depending
               on what parameter is input
      Method Input/Parameters: line thickness (string)
      Method Output/Parameters: none
      Method Output/Returned: outputs a line for the table
      Device Input: none
      Device Output: displays line to user
      Dependencies: Console IO Class Tools
      */
      public static void displayLine( char lineThickness, int lineType )
      {
         // initialize method/variables
         
         // print table if unbroken
            // method: printChar, printChars
         
         // print table if broken
            // method: printChar, printChars
      }
      /*
      Name: displayTableTitle
      Process: display the table's title
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: outputs the table's title
      Device Input: none
      Device Output: displays title to user
      Dependencies: Console IO Class Tools
      */
      public static void displayTableTitle()
      {
         // initialize method/variables
         
         // print table title
      }
      /*
      Name: displaySubTitles
      Process: display the table's subtitles
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: outputs the table's subtitles
      Device Input: none
      Device Output: displays subtitles to user
      Dependencies: Console IO Class Tools
      */
      public static void displaySubTitles()
      {
         // initialize method/variables
         
         // print table subtitles
      }
      /*
      Name: displayDataLine
      Process: display the appropriate data title and value
      Method Input/Parameters: data title (string) value (double), divider
                               character (char)
      Method Output/Parameters: none
      Method Output/Returned: outputs the table's data and line above
      Device Input: none
      Device Output: displays data to user
      Dependencies: Console IO Class Tools
      */
      public static void displayDataLine(String dataTitle, double value, 
            char dividerChar)
      {
         // initialize method/variables
         
         // draw correct line above value data 
            // method: displayLine, printEndline
         
         // display value data
            // method: printString, printChar, printDouble
      }
   }
