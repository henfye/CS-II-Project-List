package p6_package;

public class QuadCalcClass_II_S6
   {
      // initialize table characters
      public static final char DASH = '-';
      public static final char DOUBLE_DASH = '=';
      public static final char PIPE = '|';
      public static final char CROSS = '+';
      
      // initialize line controls
      public static final int SOLID = 1001;
      public static final int BROKEN = 2002; 

      // initialize table string components
      public static final String PIPE_SPACE = "| ";
      public static final String SPACE_PIPE = " |";
      public static final String CROSS_SPACE = "+ ";
      
      // initialize table widths
      public static final int PRECISION = 2;
      public static final int TABLE_WIDTH = 44;
      public static final int NAME_BLOCK_WIDTH = 29;
      public static final int VALUE_BLOCK_WIDTH = 12;

      // initialize two endlines constant
      public static final int TWO_ENDLINES = 2;
      
      public static void main( String[] args )
      {
      // initialize the program
         // declare variables
         int coefA, coefB, coefC;
         int denominator;
         int discriminant;
         double discSqrt = 0;
         boolean complexCondition = false;
         boolean oneRootCondition = false;
         double rootOne = 0;
         double rootTwo = 0;
         
         // set title for program using method
            // method: printTitle
         printTitle();
         
      // get coefficients from user
         // get coefficient A
            // method: promptForCoef
         coefA = promptForCoef( 'A' );
         
         // get coefficient B
            // method: promptForCoef
         coefB = promptForCoef( 'B' );
         
         // get coefficient C
            // method: promptForCoef, printEndline
         coefC = promptForCoef( 'C' );
         
      // process the quadratic roots
         // calculate the denominator
            // method: calcDenom
         denominator = calcDenom( coefA );
         
         // calculate the discriminant
            // method: calcDiscrim
         discriminant = calcDiscrim( coefA, coefB, coefC );
         
         // test discriminant for complex condition
         if (discriminant < 0)
            {
               complexCondition = true;
            }
         else if ( discriminant == 0 )
            {
               oneRootCondition = true;
            }
         
         // calculate square root of discriminant
            // method: Math.sqrt
         if ( !complexCondition )
         {
            discSqrt = Math.sqrt( discriminant );
         }
         
         // calculate the roots
         
            // calculate root one
               // method: calcRoot
         if ( !complexCondition )
            {
               rootOne = calcRoot( coefB, denominator, discSqrt );
               
               // calculate root tow
                  // method: calcRoot
               if ( !oneRootCondition )
                  {
                     rootTwo = calcRoot( coefB, denominator, -discSqrt );
                  }
            }
         
      // display roots to user
         // display thick table line
            // method: displayLine, printEndline
         displayLine( DOUBLE_DASH, SOLID );
         
         // display table title
            // method: displayTableTitle, printEndline
         displayTableTitle();
         
         // display thin table line
            // method: displayLine, printEndline
         displayLine( DASH, SOLID );
         
         // display sub titles
            // method: displaySubTitles, printEndline
         displaySubTitles();
         
         // display coefficient A
            // method: displayDataLine, printEndline
         displayDataLine( "Coefficient A", coefA, DOUBLE_DASH );
         
         // display coefficient B
            // method: displayDataLine, printEndline
         displayDataLine( "Coefficient B", coefB, DASH );
         
         // display coefficient C
            // method: displayDataLine, printEndline
         displayDataLine( "Coefficient C", coefC, DASH );
         
         // if root is complex display complex
         if (complexCondition)
            {
               displayDataLine( "Complex Roots", 0.00, DOUBLE_DASH );
            }
         
         // if root is not complex, display root one
         else
            {
               displayDataLine( "Root One", rootOne, DOUBLE_DASH );
               
               // if the solution has two roots, display second root
               if ( !oneRootCondition )
                  {
                     displayDataLine( "Root Two", rootTwo, DASH );
                  }
            }
         
         // print bottom line of table
            // method: displayLine, printEndlines
         displayLine( DOUBLE_DASH, BROKEN );         
         
      // end program
         // print end program
            // method: printString, printEndline
         displayProgramEnd();
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
         Console_IO_Class conIO = new Console_IO_Class();
         
         // print title with underline and vertical space
         
            // print title
               // method: printString, printEndline
         conIO.printString( "Quadratic Root Finding Program" );
         conIO.printEndline();
         
            // print underline
               // method: printChars, printEndlines
         conIO.printChars( 30, DOUBLE_DASH );
         conIO.printEndlines( TWO_ENDLINES );
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
         int coefValue;
         Console_IO_Class conIO = new Console_IO_Class();
         
         // prompt user for coefficient
            // method: promptForInt
         coefValue = conIO.promptForInt( "Enter coefficient " + coefLetter
               + ": " );
         
         // return input
         return coefValue;
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
         int denominator;
         
         // multiply 2 times coefficient A
         denominator = 2 * coefA;
         
         // return denominator
         return denominator;
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
         int discriminant;
         
         // calculate discriminant
         discriminant = coefB * coefB - 4 * coefA * coefC;
         
         // return discriminant
         return discriminant;
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
         double numerator;
         double root;
         
         // calculate the numerator
         numerator = -coefB + discSqrt;
         
         // calculate the root
         root = numerator / denominator;
         
         // return root
         return root;
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
         Console_IO_Class conIO = new Console_IO_Class();
         
         // print table if unbroken
            // method: printChar, printChars
         conIO.printChar(PIPE);
         if ( lineType == 1001 )
            {
               conIO.printChars(TABLE_WIDTH - 2, lineThickness );
            }
         // print table if broken
            // method: printChar, printChars
         else
            {
               conIO.printChars(NAME_BLOCK_WIDTH, lineThickness );
               conIO.printChar(PIPE);
               conIO.printChars(VALUE_BLOCK_WIDTH , lineThickness);
            }
         conIO.printChar(PIPE);
         conIO.printEndline();
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
         Console_IO_Class conIO = new Console_IO_Class();
         
         // print table title
         conIO.printChar(PIPE);
         conIO.printString("QUADRATIC ROOT RESULTS", TABLE_WIDTH -2, "CENTER");
         conIO.printChar(PIPE);
         conIO.printEndline();
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
         Console_IO_Class conIO = new Console_IO_Class();
         
         // print table subtitles
         conIO.printChar(PIPE);
         conIO.printString("VALUE NAME", NAME_BLOCK_WIDTH, "CENTER");
         conIO.printChar(PIPE);
         conIO.printString("VALUE", VALUE_BLOCK_WIDTH, "CENTER");
         conIO.printChar(PIPE);
         conIO.printEndline();
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
         Console_IO_Class conIO = new Console_IO_Class();
         
         // draw correct line above value data 
            // method: displayLine, printEndline
         displayLine(dividerChar, BROKEN);
         
         // display value data
            // method: printString, printChar, printDouble
         conIO.printString(PIPE_SPACE);
         conIO.printString(dataTitle, NAME_BLOCK_WIDTH -1, "LEFT");
         conIO.printChar(CROSS);
         conIO.printDouble(value, PRECISION, VALUE_BLOCK_WIDTH -1, "RIGHT");
         conIO.printString(SPACE_PIPE);
         conIO.printEndline();
      }
      /*
      Name: displayProgramEnd
      Process: display the end of the program
      Method Input/Parameters: none
      Method Output/Parameters: none
      Method Output/Returned: none
      Device Input: none
      Device Output: displays program end to user
      Dependencies: Console IO Class Tools
      */
      public static void displayProgramEnd()
      {
         // initialize method/variables
         Console_IO_Class conIO = new Console_IO_Class();
         
         // display program end
            // method: printString, printEndline
         conIO.printString("End Program");
         conIO.printEndline();
      }
   }
