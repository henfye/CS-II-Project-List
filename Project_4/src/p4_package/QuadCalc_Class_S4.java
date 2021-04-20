package p4_package;

public class QuadCalc_Class_S4
   {
      // constants used in construction of the table
      public static final char DASH = '-';
      public static final char DOUBLE_DASH = '=';
      public static final char PIPE = '|';
      public static final char CROSS = '+';
      
      // constants that aid in the formatting of words within the table
      public static final String PIPE_SPACE = "| ";
      public static final String SPACE_PIPE = " |";
      public static final String CROSS_SPACE = "+ ";
      
      // constants that aid in formatting the table and with precision of
      // doubles
      public static final int PRECISION = 2;
      public static final int TABLE_WIDTH = 44;
      public static final int NAME_BLOCK_WIDTH = 29;
      public static final int VALUE_BLOCK_WIDTH = 12;
      
      // constant that will be used to help space out the program
      public static final int TWO_ENDLINES = 2;
      
      // precision offset constant used in the calculation of the roots
      public static final double PRECISION_OFFSET = 0.000001;
      
      // initialize console io globally
      public static final Console_IO_Class conIO = new Console_IO_Class();
      
      
      public static void main( String[] args )
      {
      // initialize the program
         
         // initialize variables
         double coefA;
         double coefB;
         double coefC;
         double discriminant;
         boolean negativeDiscriminant = false;
         double numeratorOne;
         double denomenatorOne;
         double numeratorTwo;
         double denomenatorTwo;
         double rootOne = 0;
         double rootTwo = 0;
         
         // show title and underline
            // method: printString, printChars, printEndline, printEndlines
         conIO.printString("Quadratic Root Finding Program");
         conIO.printEndline();
         conIO.printChars(30, DOUBLE_DASH);
         conIO.printEndlines(TWO_ENDLINES);
      
         
      // get coefficients from user
         
         // get coefficient A
            // method: promptForDouble
         coefA = conIO.promptForDouble( "    Enter Coefficient A: " );
         
         // get coefficient B
            // method: promptForDouble
         coefB = conIO.promptForDouble( "    Enter Coefficient B: " );
         
         // get coefficient C
            // method: promptForDouble
         coefC = conIO.promptForDouble( "    Enter Coefficient C: " );
         
         
      // process the quadratic square roots
         
         // calculate discriminant
         discriminant = ( coefB * coefB ) - 4 * coefA * coefC ;
         
         // check for a negative discriminant
         if ( discriminant < 0  )
            {
               // set negative discriminant flag to true
               negativeDiscriminant = true;
            }
         
         // calculate roots if they are not complex
         else 
            {
         
            // calculate root 1
            
               // calculate root 1 numerator
            numeratorOne = -coefB + Math.sqrt(discriminant);
            
               // calculate root 1 denominator
            denomenatorOne = 2 * coefA;
            
               // fully calculate root 1
            rootOne = numeratorOne / denomenatorOne;
            
            if ( discriminant > 0)
               {
                  // calculate root 2
                  
                     // calculate root 2 numerator
                  numeratorTwo = -coefB - Math.sqrt(discriminant);
                  
                        // calculate root 2 denominator
                  denomenatorTwo = 2 * coefA;
                  
                        // fully calculate root 2
                  rootTwo = numeratorTwo / denomenatorTwo;
               }
            }
      // display results to user
         
         // display top of table
            // method: printChar, printChars, printEndline
         conIO.printChar(PIPE);
         conIO.printChars(TABLE_WIDTH -2, DOUBLE_DASH );
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         // display title of table
            // method: printChar, printString, printEndline
         conIO.printChar(PIPE);
         conIO.printString("QUADRATIC ROOT RESULTS", TABLE_WIDTH - 2, "CENTER");
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         // display line under title
            // method: printChar, printChars, printEndline
         conIO.printChar(PIPE);
         conIO.printChars(TABLE_WIDTH -2, DASH );
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         // display column headers
            // method: printChar, printString, printEndline
         conIO.printChar(PIPE);
         conIO.printString("VALUE NAME", NAME_BLOCK_WIDTH, "CENTER");
         conIO.printChar(PIPE);
         conIO.printString("VALUE", VALUE_BLOCK_WIDTH, "CENTER");
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         // display line under column headers
            // method: printChar, printChars, printEndline
         conIO.printChar(PIPE);
         conIO.printChars(NAME_BLOCK_WIDTH, DOUBLE_DASH);
         conIO.printChar(PIPE);
         conIO.printChars(VALUE_BLOCK_WIDTH, DOUBLE_DASH);
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         // display coefficient A
            // method: printString, printChar, printDouble, printEndline
         conIO.printString(PIPE_SPACE);
         conIO.printString("Coefficient A", NAME_BLOCK_WIDTH -1, "LEFT");
         conIO.printChar(CROSS);
         conIO.printDouble(coefA, PRECISION, VALUE_BLOCK_WIDTH -1, "RIGHT");
         conIO.printString(SPACE_PIPE);
         conIO.printEndline();
         
         //display table line
            // method: printChar, printChars, printEndline
         conIO.printChar(PIPE);
         conIO.printChars(NAME_BLOCK_WIDTH, DASH);
         conIO.printChar(PIPE);
         conIO.printChars(VALUE_BLOCK_WIDTH, DASH);
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         // display coefficient B
            // method: printString, printChar, printDouble, printEndline
         conIO.printString(PIPE_SPACE);
         conIO.printString("Coefficient B", NAME_BLOCK_WIDTH -1, "LEFT");
         conIO.printChar(CROSS);
         conIO.printDouble(coefB, PRECISION, VALUE_BLOCK_WIDTH -1, "RIGHT");
         conIO.printString(SPACE_PIPE);
         conIO.printEndline();
         
         // display table line
            // method: printChar, printChars, printEndline
         conIO.printChar(PIPE);
         conIO.printChars(NAME_BLOCK_WIDTH, DASH);
         conIO.printChar(PIPE);
         conIO.printChars(VALUE_BLOCK_WIDTH, DASH);
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         // display coefficient C
            // method: printString, printChar, printDouble, printEndline
         conIO.printString(PIPE_SPACE);
         conIO.printString("Coefficient C", NAME_BLOCK_WIDTH -1, "LEFT");
         conIO.printChar(CROSS);
         conIO.printDouble(coefC, PRECISION, VALUE_BLOCK_WIDTH -1, "RIGHT");
         conIO.printString(SPACE_PIPE);
         conIO.printEndline();
         
         // display table line
            // method: printChar, printChars, printEndline
         conIO.printChar(PIPE);
         conIO.printChars(NAME_BLOCK_WIDTH, DOUBLE_DASH);
         conIO.printChar(PIPE);
         conIO.printChars(VALUE_BLOCK_WIDTH, DOUBLE_DASH);
         conIO.printChar(PIPE);
         conIO.printEndline();
         
         // display table with no roots
         if (negativeDiscriminant)
            {
               // print out complex roots
                  // method: printString, printChar, printEndline
               conIO.printString(PIPE_SPACE);
               conIO.printString("Roots", NAME_BLOCK_WIDTH -1, "LEFT");
               conIO.printChar(CROSS);
               conIO.printString("Complex", VALUE_BLOCK_WIDTH -1, "RIGHT");
               conIO.printString(SPACE_PIPE);
               conIO.printEndline();
            }
         
         // display table with one root
         else if (discriminant == 0)
            {
               // print out single root
                  // method: printString, printChar, printDouble, printEndline
               conIO.printString(PIPE_SPACE);
               conIO.printString("Single Root", NAME_BLOCK_WIDTH -1, "LEFT");
               conIO.printChar(CROSS);
               conIO.printDouble(rootOne, PRECISION, VALUE_BLOCK_WIDTH -1,
                     "RIGHT");
               conIO.printString(SPACE_PIPE);
               conIO.printEndline();
            }
         
         // if there are two roots display both
         else
            {
               // print out first root
                  // method: printString, printChar, printDouble, printEndline
               conIO.printString(PIPE_SPACE);
               conIO.printString("Root One", NAME_BLOCK_WIDTH -1, "LEFT");
               conIO.printChar(CROSS);
               conIO.printDouble(rootOne, PRECISION, VALUE_BLOCK_WIDTH -1,
                     "RIGHT");
               conIO.printString(SPACE_PIPE);
               conIO.printEndline();
               
               // print out table line
                  // method: printChar, printChars, printEndline
               conIO.printChar(PIPE);
               conIO.printChars(NAME_BLOCK_WIDTH, DASH);
               conIO.printChar(PIPE);
               conIO.printChars(VALUE_BLOCK_WIDTH, DASH);
               conIO.printChar(PIPE);
               conIO.printEndline();
               
               // print out second root
                  // method: printString, printChar, printDouble, printEndline
               conIO.printString(PIPE_SPACE);
               conIO.printString("Root Two", NAME_BLOCK_WIDTH -1, "LEFT");
               conIO.printChar(CROSS);
               conIO.printDouble(rootTwo, PRECISION, VALUE_BLOCK_WIDTH -1,
                     "RIGHT");
               conIO.printString(SPACE_PIPE);
               conIO.printEndline();
            }
         
         // display table line
            // method: printChar, printChars, printEndlines
         conIO.printChar(PIPE);
         conIO.printChars(NAME_BLOCK_WIDTH, DOUBLE_DASH);
         conIO.printChar(PIPE);
         conIO.printChars(VALUE_BLOCK_WIDTH, DOUBLE_DASH);
         conIO.printChar(PIPE);
         conIO.printEndlines(TWO_ENDLINES);
         
      // end program
         
         // display program end
            // method: printString, printEndline
         conIO.printString("End Program");
         conIO.printEndline();
      }
   }
